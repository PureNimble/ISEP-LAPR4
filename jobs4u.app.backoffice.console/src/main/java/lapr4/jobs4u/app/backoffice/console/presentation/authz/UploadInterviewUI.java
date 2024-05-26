package lapr4.jobs4u.app.backoffice.console.presentation.authz;

import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;
import lapr4.jobs4u.app.backoffice.console.presentation.authz.printer.ApplicationPrinter;
import lapr4.jobs4u.app.backoffice.console.presentation.authz.printer.JobOpeningPrinter;
import lapr4.jobs4u.app.common.console.presentation.utils.Utils;
import lapr4.jobs4u.applicationmanagement.application.ListApplicationsController;
import lapr4.jobs4u.applicationmanagement.domain.Application;
import lapr4.jobs4u.applicationmanagement.domain.File;
import lapr4.jobs4u.applicationmanagement.dto.ApplicationDTO;
import lapr4.jobs4u.infrastructure.persistence.PersistenceContext;
import lapr4.jobs4u.interviewmanagement.application.UploadInterviewController;
import lapr4.jobs4u.interviewmanagement.domain.Interview;
import lapr4.jobs4u.jobopeningmanagement.application.ListJobOpeningsController;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
import lapr4.jobs4u.jobopeningmanagement.dto.JobOpeningDTO;

public class UploadInterviewUI extends AbstractUI {

    private final UploadInterviewController controller;
    private final ListApplicationsController applicationController;
    private final ListJobOpeningsController jobOpeningsController;

    public UploadInterviewUI() {
        controller = new UploadInterviewController(PersistenceContext.repositories().interviews(),
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
        // list interviews
        Interview i = controller.findInterview(app);
        if (i == null) {
            return false;
        }
        String file = Utils.getPath(false);
        i.addFile(File.valueOf(file));
        checkInterview(); // TODO: LPROG

        controller.save(i);

        return false;

    }

    private Application selectApplication() {
        final Iterable<JobOpeningDTO> jobOpenings = this.jobOpeningsController.filterWithAvailablePhase();
        final SelectWidget<JobOpeningDTO> selector = new SelectWidget<>("Job Openings:", jobOpenings,
                new JobOpeningPrinter());
        selector.show();
        final JobOpeningDTO theJobOpeningDTO = selector.selectedElement();
        if (theJobOpeningDTO == null) {
            return null;
        }
        JobOpening theJobOpening = jobOpeningsController.selectedJobOpening(theJobOpeningDTO);
        final Iterable<ApplicationDTO> applications = applicationController
                .findApplicationWithInterviewRecord(theJobOpening);
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

    private void checkInterview() {

    }
}
