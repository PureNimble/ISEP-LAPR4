package lapr4.jobs4u.app.backoffice.console.presentation.authz;

import java.util.ArrayList;
import java.util.List;

import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;
import lapr4.jobs4u.app.backoffice.console.presentation.authz.printer.JobOpeningPrinter;
import lapr4.jobs4u.app.common.console.presentation.utils.Utils;
import lapr4.jobs4u.infrastructure.persistence.PersistenceContext;
import lapr4.jobs4u.jobopeningmanagement.application.ListJobOpeningsController;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
import lapr4.jobs4u.jobopeningmanagement.dto.JobOpeningDTO;
import lapr4.jobs4u.recruitmentprocessmanagement.application.OpenOrClosePhaseController;

/**
 * @author 2DI2
 */
@SuppressWarnings("squid:S106")
public class OpenOrClosePhaseUI extends AbstractUI {

    private final TransactionalContext ctx = PersistenceContext.repositories().newTransactionalContext();
    private final ListJobOpeningsController listJobOpeningsController = new ListJobOpeningsController(
            PersistenceContext.repositories().jobOpenings(), AuthzRegistry.authorizationService());
    private final OpenOrClosePhaseController openOrClosePhaseController = new OpenOrClosePhaseController(
            PersistenceContext.repositories().recruitmentProcesses(ctx),
            PersistenceContext.repositories().jobOpenings(ctx),
            PersistenceContext.repositories().jobOpeningRequirements(),
            PersistenceContext.repositories().jobOpeningInterviews(), PersistenceContext.repositories().applications(),
            AuthzRegistry.authorizationService(), ctx);

    @Override
    protected boolean doShow() {
        final List<String> options = new ArrayList<>();
        final int option;
        final Iterable<JobOpeningDTO> jobOpenings = listJobOpeningsController
                .getIntersection(listJobOpeningsController.hasRecruitmentProcess(true));
        final SelectWidget<JobOpeningDTO> selector = new SelectWidget<>("Job Openings:", jobOpenings,
                new JobOpeningPrinter());
        selector.show();
        final JobOpeningDTO theJobOpeningDTO = selector.selectedElement();
        if (theJobOpeningDTO == null) {
            return false;
        }
        JobOpening theJobOpening = listJobOpeningsController.selectedJobOpening(theJobOpeningDTO);
        final String currentPhase = jobOpeningCurrentPhase(theJobOpening);
        if (currentPhase == null) {
            options.add("Yes");
            options.add("No");
            option = Utils.showAndSelectIndex(options,
                    "There is no open phase for this job opening. Do you wish to start the recruitment process?");
            if (option == 1) {
                System.out.println("No changes were made.");
                return false;
            }
        } else {
            options.add("Go to the next Phase");
            options.add("Go to the previous Phase");
            option = Utils.showAndSelectIndex(options,
                    "The current phase is: " + currentPhase
                            + ". Do you wish to go to the next one or go back to the previous state?");
        }
        try {
            openOrClosePhaseController.changePhase(currentPhase, theJobOpening, option == 0);
            System.out.println("Phase changed successfully");
        } catch (Exception e) {
            System.out.println("Error changing phase: " + e.getMessage());
        }
        return true;
    }

    @Override
    public String headline() {
        return "Open or Close Phase";
    }

    protected String jobOpeningCurrentPhase(final JobOpening jobOpening) {
        return openOrClosePhaseController.currentPhase(jobOpening);
    }
}