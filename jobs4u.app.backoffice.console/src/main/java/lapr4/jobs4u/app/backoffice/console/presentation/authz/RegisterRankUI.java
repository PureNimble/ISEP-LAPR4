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

/**
 * @author 2DI2
 */
public class RegisterRankUI extends AbstractUI {

    private final TransactionalContext txCtx = PersistenceContext.repositories().newTransactionalContext();
    private final ListJobOpeningsController jobOpeningsController = new ListJobOpeningsController(
            PersistenceContext.repositories().jobOpenings(), AuthzRegistry.authorizationService());
    private final ListApplicationsController applicationsController = new ListApplicationsController(
            PersistenceContext.repositories().applications(), AuthzRegistry.authorizationService());

    private final RegisterRankController controller = new RegisterRankController(
            AuthzRegistry.authorizationService(), PersistenceContext.repositories().ranks(txCtx));

    @Override
    protected boolean doShow() {
        final Iterable<JobOpeningDTO> jobOpenings = this.jobOpeningsController.filterWithAvailablePhaseForRanking();
        final SelectWidget<JobOpeningDTO> selector = new SelectWidget<>("Job Openings:", jobOpenings,
                new JobOpeningPrinter());
        selector.show();
        final JobOpeningDTO theJobOpeningDTO = selector.selectedElement();
        if (theJobOpeningDTO == null) {
            return false;
        }
        final JobOpening theJobOpening = jobOpeningsController.selectedJobOpening(theJobOpeningDTO);

        if (controller.hasRank(theJobOpening)) {

            System.out.println("This job opening already has a rank.\n");

            final List<RankDTO> ranksDTOs = (List<RankDTO>) controller.findByJobOpening(theJobOpening);
            System.out.println(header());
            ranksDTOs.forEach(ranksDTO -> System.out.println(String.format("%-3s%-20s%-20s", ranksDTO.getPlacement(),
                    ranksDTO.getCandidateEmail(), ranksDTO.getCandidateName())));

            if (!Utils.confirm("\nDo you wish to edit this rank?")) {
                System.out.println("No changes were made.");
                return false;
            }

            final List<String> options = Arrays.asList("Add Candidate", "Edit Positions");
            final int option = Utils.showAndSelectIndex(options, "\nWhich change do you wish to apply?");
            if (option == 1) {
                editRank(theJobOpening, ranksDTOs);
                return false;
            }
        }
        addRank(theJobOpening);
        return false;
    }

    private void editRank(final JobOpening theJobOpening, final List<RankDTO> ranksDTOs) {

        do {
            final SelectWidget<RankDTO> applicationSelector = new SelectWidget<>("\nCurrent Rank:\n" + header(), ranksDTOs,
                    new RankPrinter());
            applicationSelector.show();
            final RankDTO rankDTO = applicationSelector.selectedElement();
            if (rankDTO == null)
                return;
            int placement = 0;
            do {
                placement = Console
                        .readInteger(
                                "Insert a new placement for the candidate: " + rankDTO.getCandidateEmail());
                if (placement < 1 || placement > ranksDTOs.size()) {
                    System.out.println("Invalid placement.");
                }

            } while (placement < 1 || placement > ranksDTOs.size());

            final int oldPosition = ranksDTOs.indexOf(rankDTO);
            final int newPosition = placement - 1;
            if (oldPosition != -1) {
                ranksDTOs.remove(oldPosition);
                ranksDTOs.add(newPosition, rankDTO);
            }

        } while (Utils.confirm("Do you wish to edit another placement?"));

        System.out.println("Result:\n" + header());
        for (final RankDTO ranksDTO : ranksDTOs) {
            System.out
                    .println(String.format("%-3s%-20s%-20s", ranksDTO.getPlacement(), ranksDTO.getCandidateEmail(),
                            ranksDTO.getCandidateName()));
        }

        if (!Utils.confirm("Do you wish to save this changes?"))
            return;

        try {
            txCtx.beginTransaction();
            int i = 1;
            for (final RankDTO ranksDTO : ranksDTOs) {
                controller.editRank(controller.selectedRank(ranksDTO), Integer.toString(i));
                i++;
            }
            txCtx.commit();
        } catch (final IntegrityViolationException | ConcurrencyException e) {
            System.out.println("There was an error saving the changes.");
            txCtx.rollback();
        } finally {
            txCtx.close();
        }
    }

    private void addRank(final JobOpening theJobOpening) {

        final List<ApplicationDTO> applicationDTOS = (List<ApplicationDTO>) applicationsController
                .unrankedApplicationByJobOpening(theJobOpening);
        if (applicationDTOS.isEmpty()) {
            System.out.println("There are no applications to rank.");
            return;
        }
        List<Application> applications = new LinkedList<>();
        int i;
        for (i = 0; i < applicationDTOS.size(); i++) {
            System.out.printf("Rank nº %d\n", i + 1);
            final SelectWidget<ApplicationDTO> applicationSelector = new SelectWidget<>("Candidates: ",
                    applicationDTOS, new ApplicationPrinter());
            applicationSelector.show();
            final ApplicationDTO applicationDTO = applicationSelector.selectedElement();
            if (applicationDTO == null)
                return;

            applicationDTOS.remove(applicationDTO);
            final Application application = applicationsController.selectedApplication(applicationDTO);
            applications.addLast(application);

        }

        System.out.println("Result:");
        System.out.println(header());
        for (final Application application : applications) {
            final Integer index = applications.indexOf(application) + 1;
            System.out.printf(String.format("%-3d%-20s%-20s", index, application.candidate().emailAddress(),
                    application.candidate().name()));
        }

        if (!Utils.confirm("\nDo you wish to save this rank?"))
            return;

        try {
            txCtx.beginTransaction();
            for (final Application application : applications) {
                final Integer index = applications.indexOf(application) + 1;
                this.controller.setupRank(Integer.toString(index), application);
                applications.remove(application);
            }
            txCtx.commit();
        } catch (final IntegrityViolationException | ConcurrencyException e) {
            System.out.println("There is already a rank with that rank reference. Please try again.");
            txCtx.rollback();
        } finally {
            txCtx.close();
        }
    }

    private String header() {
        return String.format("%-3s%-20s%-20s", "#", "C. EMAIL", "C. NAME");
    }

    @Override
    public String headline() {
        return "Rank Candidates";
    }
}
