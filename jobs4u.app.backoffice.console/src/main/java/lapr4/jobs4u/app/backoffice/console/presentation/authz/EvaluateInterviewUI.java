package lapr4.jobs4u.app.backoffice.console.presentation.authz;

import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;
import lapr4.jobs4u.app.backoffice.console.presentation.authz.printer.JobOpeningPrinter;
import lapr4.jobs4u.infrastructure.persistence.PersistenceContext;
import lapr4.jobs4u.interviewmanagement.application.EvaluateInterviewController;
import lapr4.jobs4u.jobopeningmanagement.application.ListJobOpeningsController;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
import lapr4.jobs4u.jobopeningmanagement.dto.JobOpeningDTO;

/**
 * @author 2DI2
 */
public class EvaluateInterviewUI extends AbstractUI {

    private final EvaluateInterviewController evaluateInterviewController = new EvaluateInterviewController(
            PersistenceContext.repositories().interviewQuestion(),
            PersistenceContext.repositories().recruitmentProcesses(),
            PersistenceContext.repositories().jobOpeningInterviews(),
            PersistenceContext.repositories().interviews(),
            AuthzRegistry.authorizationService());
    private final ListJobOpeningsController listJobpeningsController = new ListJobOpeningsController(
            PersistenceContext.repositories().jobOpenings(), AuthzRegistry.authorizationService());

    @Override
    protected boolean doShow() {

        final Iterable<JobOpeningDTO> jobOpenings = this.listJobpeningsController
                .filterWithAvailablePhaseForInterviewEvaluation();
        final SelectWidget<JobOpeningDTO> selector = new SelectWidget<>("Job Openings:", jobOpenings,
                new JobOpeningPrinter());
        selector.show();
        final JobOpeningDTO theJobOpeningDTO = selector.selectedElement();
        if (theJobOpeningDTO == null) {
            return false;
        }

        final JobOpening theJobOpening = listJobpeningsController.selectedJobOpening(theJobOpeningDTO);

        try {
            this.evaluateInterviewController.evaluateInterview(theJobOpening);
            System.out.println("The interviews have been successfully evaluated");
        } catch (final Exception e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
        return false;
    }

    @Override
    public String headline() {
        return "Evaluate Interview";
    }
}