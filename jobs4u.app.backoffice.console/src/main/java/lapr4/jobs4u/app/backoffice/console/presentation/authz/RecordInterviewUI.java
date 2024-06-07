package lapr4.jobs4u.app.backoffice.console.presentation.authz;

import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;
import lapr4.jobs4u.app.backoffice.console.presentation.authz.printer.ApplicationPrinter;
import lapr4.jobs4u.app.backoffice.console.presentation.authz.printer.JobOpeningPrinter;
import lapr4.jobs4u.applicationmanagement.application.ListApplicationsController;
import lapr4.jobs4u.applicationmanagement.domain.Application;
import lapr4.jobs4u.applicationmanagement.dto.ApplicationDTO;
import lapr4.jobs4u.infrastructure.persistence.PersistenceContext;
import lapr4.jobs4u.interviewmanagement.application.RecordInterviewController;
import lapr4.jobs4u.interviewmanagement.domain.Interview;
import lapr4.jobs4u.jobopeningmanagement.application.ListJobOpeningsController;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
import lapr4.jobs4u.jobopeningmanagement.dto.JobOpeningDTO;

/**
 * @author 2DI2
 */
public class RecordInterviewUI extends AbstractUI {

    private final RecordInterviewController controller;
    private final ListApplicationsController applicationController;
    private final ListJobOpeningsController jobOpeningsController;

    public RecordInterviewUI() {
        controller = new RecordInterviewController(PersistenceContext.repositories().interviews(),
                AuthzRegistry.authorizationService());
        applicationController = new ListApplicationsController(PersistenceContext.repositories().applications(),
                AuthzRegistry.authorizationService());
        jobOpeningsController = new ListJobOpeningsController(PersistenceContext.repositories().jobOpenings(),
                AuthzRegistry.authorizationService());
    }

    @Override
    protected boolean doShow() {

        Application app = selectApplication();
        if (app == null)
            return false;
        Interview i = createInterview(app);
        if (i == null)
            return false;
        controller.save(i);

        return false;

    }

    private Application selectApplication() {
        final Iterable<JobOpeningDTO> jobOpenings = this.jobOpeningsController.filterWithAvailablePhaseForInterviews();
        final SelectWidget<JobOpeningDTO> selector = new SelectWidget<>("Job Openings:", jobOpenings,
                new JobOpeningPrinter());
        selector.show();
        final JobOpeningDTO theJobOpeningDTO = selector.selectedElement();
        if (theJobOpeningDTO == null) {
            return null;
        }
        JobOpening theJobOpening = jobOpeningsController.selectedJobOpening(theJobOpeningDTO);
        final Iterable<ApplicationDTO> applications = this.applicationController
                .findApplicationThatPassInRequirements(theJobOpening);
        final SelectWidget<ApplicationDTO> selector1 = new SelectWidget<>("Applications:", applications,
                new ApplicationPrinter());
        selector1.show();
        final ApplicationDTO theApplicationDTO = selector1.selectedElement();
        if (theApplicationDTO == null) {
            return null;
        }
        return applicationController.selectedApplication(theApplicationDTO);

    }

    @Override
    public String headline() {
        return "Import Applications";
    }

    private Interview createInterview(Application app) {
        try {
            System.out.println("Interview Date:");
            final String date = Console.readLine("Date:");
            final String time = Console.readLine("Time:");

            return Interview.valueOf(date, time, app);

        } catch (final ConcurrencyException | IntegrityViolationException e) {
            System.out.println("Invalid data.");
            return null;
        }

    }
}
