package lapr4.jobs4u.app.backoffice.console.presentation.authz;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;

import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.io.util.Files;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;
import lapr4.jobs4u.app.backoffice.console.presentation.authz.printer.ApplicationPrinter;
import lapr4.jobs4u.app.backoffice.console.presentation.authz.printer.JobOpeningPrinter;
import lapr4.jobs4u.app.common.console.presentation.utils.Utils;
import lapr4.jobs4u.applicationmanagement.application.DisplayApplicationDataController;
import lapr4.jobs4u.applicationmanagement.application.ListApplicationsController;
import lapr4.jobs4u.applicationmanagement.domain.Application;
import lapr4.jobs4u.applicationmanagement.domain.File;
import lapr4.jobs4u.applicationmanagement.dto.ApplicationDTO;
import lapr4.jobs4u.infrastructure.persistence.PersistenceContext;
import lapr4.jobs4u.interviewmanagement.domain.Interview;
import lapr4.jobs4u.jobopeningmanagement.application.ListJobOpeningsController;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
import lapr4.jobs4u.jobopeningmanagement.dto.JobOpeningDTO;
import lapr4.jobs4u.requirementmanagement.domain.Requirement;

/**
 * @author 2DI2
 */
public class DisplayApplicationDataUI extends AbstractUI {

    private static final String EVALUATED_TAG = "Evaluated";
    private final ListApplicationsController listApplicationsController = new ListApplicationsController(
            PersistenceContext.repositories().applications(), AuthzRegistry.authorizationService());
    private final ListJobOpeningsController listJobpeningsController = new ListJobOpeningsController(
            PersistenceContext.repositories().jobOpenings(), AuthzRegistry.authorizationService());
    private final DisplayApplicationDataController displayApplicationDataController = new DisplayApplicationDataController(
            PersistenceContext.repositories().requirements(), PersistenceContext.repositories().interviews(),
            AuthzRegistry.authorizationService());

    @Override
    public String headline() {
        return "Display Applications Data";
    }

    @Override
    protected boolean doShow() {

        final Iterable<JobOpeningDTO> jobOpenings = this.listJobpeningsController.filterByCostumerManager();
        final SelectWidget<JobOpeningDTO> jobOpeningSelector = new SelectWidget<>("Job Openings:", jobOpenings,
                new JobOpeningPrinter());
        jobOpeningSelector.show();
        final JobOpeningDTO theJobOpeningDTO = jobOpeningSelector.selectedElement();
        if (theJobOpeningDTO == null) {
            return false;
        }

        final JobOpening theJobOpening = listJobpeningsController.selectedJobOpening(theJobOpeningDTO);
        final Iterable<ApplicationDTO> applications = applicationsByJobOpening(theJobOpening);

        final SelectWidget<ApplicationDTO> ApplicationSelector = new SelectWidget<>("Applications:", applications,
                new ApplicationPrinter());
        ApplicationSelector.show();
        final ApplicationDTO theApplicationDTO = ApplicationSelector.selectedElement();
        if (theApplicationDTO == null) {
            return false;
        }

        final Application application = listApplicationsController.selectedApplication(theApplicationDTO);
        final Optional<Requirement> requirement = displayApplicationDataController
                .getApplicationRequirementFile(application);
        String requirementFile = null;
        if (requirement.isPresent() && requirement.get().file() != null) {
            final Path requirementPath = new java.io.File(requirement.get().file().toString()).toPath();
            final Path parentPath = requirementPath.getParent();
            final String fileName = requirementPath.getFileName().toString();
            final String newFileName = EVALUATED_TAG + fileName;
            final Path newPath = parentPath.resolve(newFileName);
            requirementFile = newPath.toString().replace("input", "output");
        }

        final Optional<Interview> interview = displayApplicationDataController.getApplicationInterviewFile(application);

        String interviewFile = null;
        if (interview.isPresent() && interview.get().file() != null) {
            final Path interviewPath = new java.io.File(interview.get().file().toString()).toPath();
            final Path parentPath = interviewPath.getParent();
            final String fileName = interviewPath.getFileName().toString();
            final String newFileName = EVALUATED_TAG + fileName;
            final Path newPath = parentPath.resolve(newFileName);
            interviewFile = newPath.toString().replace("input", "output");
        }

        System.out.println("Application Data:\n");
        System.out.println(
                String.format(
                        "Application Code: %s\nCandidate: %s\nApplication Files: %s\nRequirement: %s\nInterview: %s",
                        application.applicationCode(),
                        application.candidate().toString(),
                        application.getFiles().toString(),
                        requirementFile != null ? requirementFile : "No requirement file found.",
                        interviewFile != null ? interviewFile : "No interview file found."));

        if (!Utils.confirm("Do you wish to open the files?")) {
            return false;
        }

        try {
            application.getFiles().forEach(file -> {
                try {

                    File.openInOSViewer(new java.io.File(file.toString()).toPath().toAbsolutePath().toString());
                } catch (final IOException | InterruptedException e) {
                    System.out.println("Error opening file: " + e.getMessage());
                }
            });

            if (requirementFile != null) {
                Files.openInOSViewer(new java.io.File(requirementFile).toPath().toAbsolutePath().toString());
            }

            if (interviewFile != null) {
                Files.openInOSViewer(new java.io.File(interviewFile).toPath().toAbsolutePath().toString());
            }
        } catch (final IOException | InterruptedException e) {
            System.out.println("Error opening file: " + e.getMessage());
        }

        return false;
    }

    private Iterable<ApplicationDTO> applicationsByJobOpening(final JobOpening jobOpening) {
        return listApplicationsController.filterByJobOpening(jobOpening);
    }
}
