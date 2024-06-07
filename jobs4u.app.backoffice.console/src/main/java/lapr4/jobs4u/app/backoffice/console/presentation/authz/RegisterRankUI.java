package lapr4.jobs4u.app.backoffice.console.presentation.authz;

import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;
import lapr4.jobs4u.app.backoffice.console.presentation.authz.printer.ApplicationPrinter;
import lapr4.jobs4u.app.backoffice.console.presentation.authz.printer.JobOpeningPrinter;
import lapr4.jobs4u.app.backoffice.console.presentation.authz.printer.RankPrinter;
import lapr4.jobs4u.app.common.console.presentation.utils.Utils;
import lapr4.jobs4u.applicationmanagement.application.ListApplicationsController;
import lapr4.jobs4u.applicationmanagement.domain.Application;
import lapr4.jobs4u.applicationmanagement.dto.ApplicationDTO;
import lapr4.jobs4u.infrastructure.persistence.PersistenceContext;
import lapr4.jobs4u.jobopeningmanagement.application.ListJobOpeningsController;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
import lapr4.jobs4u.jobopeningmanagement.dto.JobOpeningDTO;
import lapr4.jobs4u.rankmanagement.application.RegisterRankController;
import lapr4.jobs4u.rankmanagement.dto.RankDTO;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/**
 * @author 2DI2
 */
public class RegisterRankUI extends AbstractUI {

    private final TransactionalContext txCtx = PersistenceContext.repositories().newTransactionalContext();
    private final ListJobOpeningsController jobOpeningsController = new ListJobOpeningsController(
            PersistenceContext.repositories().jobOpenings(), AuthzRegistry.authorizationService());
    private final ListApplicationsController applicationsController = new ListApplicationsController(
            PersistenceContext.repositories().applications(), AuthzRegistry.authorizationService());
    private final RegisterRankController registerRankController = new RegisterRankController(
            AuthzRegistry.authorizationService(), PersistenceContext.repositories().ranks(txCtx));

    @Override
    protected boolean doShow() {

        final Iterable<JobOpeningDTO> jobOpenings = jobOpeningsController.filterWithAvailablePhaseForRanking();
        final SelectWidget<JobOpeningDTO> selector = new SelectWidget<>("Job Openings:", jobOpenings,
                new JobOpeningPrinter());
        selector.show();
        final JobOpeningDTO selectedJobOpeningDTO = selector.selectedElement();

        if (selectedJobOpeningDTO == null)
            return false;

        final JobOpening selectedJobOpening = jobOpeningsController.selectedJobOpening(selectedJobOpeningDTO);
        if (registerRankController.hasRank(selectedJobOpening))
            handleExistingRank(selectedJobOpening);
        else
            addRank(selectedJobOpening);

        return false;
    }

    private void handleExistingRank(final JobOpening jobOpening) {

        System.out.println("This job opening already has a rank.\n");

        final List<RankDTO> ranks = (List<RankDTO>) registerRankController.findByJobOpening(jobOpening);
        System.out.println(header());
        ranks.forEach(rank -> System.out.printf("%-3s%-20s%-20s%n", rank.getPlacement(), rank.getCandidateEmail(),
                rank.getCandidateName()));

        if (!Utils.confirm("\nDo you wish to edit this rank?")) {
            System.out.println("No changes were made.");
            return;
        }

        final List<String> options = Arrays.asList("Add Candidate", "Edit Positions");
        final int option = Utils.showAndSelectIndex(options, "\nWhich change do you wish to apply?");
        if (option == 1)
            editRank(jobOpening, ranks);
        else if (option == 0)
            addRank(jobOpening);
    }

    private void editRank(final JobOpening jobOpening, final List<RankDTO> ranks) {

        do {
            final SelectWidget<RankDTO> rankSelector = new SelectWidget<>("\nCurrent Rank:\n" + header(), ranks,
                    new RankPrinter());
            rankSelector.show();
            final RankDTO selectedRank = rankSelector.selectedElement();
            if (selectedRank == null) {
                return;
            }

            final int newPlacement = getNewPlacement(ranks.size());

            ranks.remove(selectedRank);
            ranks.add(newPlacement - 1, selectedRank);

        } while (Utils.confirm("Do you wish to edit another placement?"));

        System.out.println(header());
        for (int i = 0; i < ranks.size(); i++) {
            final RankDTO rank = ranks.get(i);
            System.out.printf("%-3d%-20s%-20s%n", i + 1, rank.getCandidateEmail(), rank.getCandidateName());
        }

        if (Utils.confirm("Do you wish to save these changes?"))
            saveRankChanges(ranks);
        else
            System.out.println("No changes were made.");

    }

    private int getNewPlacement(final int size) {
        int placement;
        do {
            placement = Console.readInteger("Insert a new placement for the candidate: ");
            if (placement < 1 || placement > size) {
                System.out.println("Invalid placement.");
            }
        } while (placement < 1 || placement > size);
        return placement;
    }

    private void saveRankChanges(final List<RankDTO> ranks) {
        try {
            txCtx.beginTransaction();
            for (int i = 0; i < ranks.size(); i++) {
                registerRankController.editRank(registerRankController.selectedRank(ranks.get(i)),
                        Integer.toString(i + 1));
            }
            txCtx.commit();
        } catch (final IntegrityViolationException | ConcurrencyException e) {
            System.out.println("There was an error saving the changes.");
            txCtx.rollback();
        } finally {
            txCtx.close();
        }
    }

    private void addRank(final JobOpening jobOpening) {

        final List<ApplicationDTO> applications = (List<ApplicationDTO>) applicationsController
                .unrankedApplicationByJobOpening(jobOpening);
        if (applications.isEmpty()) {
            System.out.println("There are no applications to rank.");
            return;
        }

        final Optional<Long> lastPlacement = registerRankController.lastPlacement();
        final Long lastPlacementValue = lastPlacement.orElse(0L);

        final List<Application> rankedApplications = rankApplications(applications, lastPlacementValue);
        if (!rankedApplications.isEmpty()
                && jobOpening.numberOfVacancies().toInt() < (lastPlacementValue + rankedApplications.size())) {
            displayRankedApplications(rankedApplications, lastPlacementValue);
            if (Utils.confirm("\nDo you wish to save this rank?"))
                saveNewRank(rankedApplications, lastPlacementValue);
            return;
        }

        System.out.println("No changes were made. The number of placements is under the number of vacancies.");
    }

    private List<Application> rankApplications(final List<ApplicationDTO> applications, Long lastPlacementValue) {

        List<Application> rankedApplications = new LinkedList<>();
        final int size = applications.size();

        for (int i = 0; i < size; i++) {
            System.out.printf("Placement nº %d\n", lastPlacementValue);
            final SelectWidget<ApplicationDTO> applicationSelector = new SelectWidget<>("Candidates: ", applications,
                    new ApplicationPrinter());
            applicationSelector.show();
            final ApplicationDTO selectedApplicationDTO = applicationSelector.selectedElement();
            if (selectedApplicationDTO == null) {
                break;
            }

            applications.remove(selectedApplicationDTO);
            rankedApplications.addLast(applicationsController.selectedApplication(selectedApplicationDTO));
            lastPlacementValue++;
        }
        return rankedApplications;
    }

    private void saveNewRank(final List<Application> rankedApplications, Long lastPlacementValue) {
        try {
            txCtx.beginTransaction();
            for (int i = 0; i < rankedApplications.size(); i++) {
                registerRankController.setupRank(Long.toString(lastPlacementValue), rankedApplications.get(i));
                lastPlacementValue++;
            }
            txCtx.commit();
        } catch (final IntegrityViolationException | ConcurrencyException e) {
            System.out.println("There was an error saving the rank. Please try again.");
            txCtx.rollback();
        } finally {
            txCtx.close();
        }
    }

    private void displayRankedApplications(final List<Application> applications, Long lastPlacementValue) {
        System.out.println("Result:");
        System.out.println(header());
        for (final Application application : applications) {
            System.out.printf("%-3d%-20s%-20s%n", lastPlacementValue, application.candidate().emailAddress(),
                    application.candidate().name());
            lastPlacementValue++;
        }
    }

    private String header() {
        return String.format("%-10s%-20s%-20s", "#", "C. EMAIL", "C. NAME");
    }

    @Override
    public String headline() {
        return "Rank Candidates";
    }
}
