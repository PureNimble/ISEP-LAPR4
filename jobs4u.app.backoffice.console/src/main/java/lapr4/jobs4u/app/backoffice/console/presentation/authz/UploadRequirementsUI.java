package lapr4.jobs4u.app.backoffice.console.presentation.authz;

import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;
import lapr4.jobs4u.app.backoffice.console.presentation.authz.printer.ApplicationPrinter;
import lapr4.jobs4u.app.backoffice.console.presentation.authz.printer.JobOpeningPrinter;
import lapr4.jobs4u.app.common.console.presentation.utils.Utils;
import lapr4.jobs4u.applicationmanagement.application.ListApplicationsController;
import lapr4.jobs4u.applicationmanagement.domain.Application;
import lapr4.jobs4u.applicationmanagement.dto.ApplicationDTO;
import lapr4.jobs4u.infrastructure.persistence.PersistenceContext;
import lapr4.jobs4u.interviewmanagement.domain.Interview;
import lapr4.jobs4u.jobopeningmanagement.application.ListJobOpeningsController;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
import lapr4.jobs4u.jobopeningmanagement.dto.JobOpeningDTO;
import lapr4.jobs4u.requirementmanagement.application.RecordRequirementController;
import lapr4.jobs4u.requirementmanagement.application.UploadRequirementController;
import lapr4.jobs4u.requirementmanagement.domain.Requirement;

import java.io.IOException;
import java.nio.file.Path;

/**
 * @author 2DI2
 */
public class UploadRequirementsUI extends AbstractUI {

    private final UploadRequirementController uploadController;
    private final RecordRequirementController recordController;
    private final ListApplicationsController applicationController;
    private final ListJobOpeningsController jobOpeningsController;
    private static final String OUTPUT_FOLDER = "./jobs4u.ANTLR/src/main/resources/input/answers/";

    public UploadRequirementsUI() {
        uploadController = new UploadRequirementController(PersistenceContext.repositories().requirements(),
                AuthzRegistry.authorizationService());
        applicationController = new ListApplicationsController(PersistenceContext.repositories().applications(),
                AuthzRegistry.authorizationService());
        jobOpeningsController = new ListJobOpeningsController(PersistenceContext.repositories().jobOpenings(),
                AuthzRegistry.authorizationService());
        recordController = new RecordRequirementController(PersistenceContext.repositories().requirements(),
                AuthzRegistry.authorizationService());
    }

    @Override
    protected boolean doShow() {

        final Application app = selectApplication();
        if (app == null)
            return false;
        Requirement requirement = uploadController.findRequirement(app);
        if (requirement == null) {
            requirement = createRequirement(app);
            recordController.save(requirement);
        }
        final Path file = Utils.getPath(false);
        final String finalPath = OUTPUT_FOLDER + file.getFileName().toString();
        if (!Utils.copyFile(file, finalPath))
            return false;
        try {
            if (!uploadController.isCorrectRequirement(requirement, finalPath))
                return false;
        } catch (final IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        uploadController.registerRequirement(requirement, finalPath);
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

    private Requirement createRequirement(Application app) {
        try {
            return Requirement.valueOf(app);

        } catch (final ConcurrencyException | IntegrityViolationException e) {
            System.out.println("Invalid data.");
            return null;
        }

    }

    @Override
    public String headline() {
        return "Upload Requirements";
    }
}