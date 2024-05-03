package lapr4.jobs4u.app.backoffice.console.presentation.authz;

import lapr4.jobs4u.applicationmanagement.application.ImportApplicationsController;
import lapr4.jobs4u.applicationmanagement.domain.File;
import lapr4.jobs4u.candidatemanagement.application.RegisterCandidateController;
import lapr4.jobs4u.candidatemanagement.domain.Candidate;
import lapr4.jobs4u.infrastructure.persistence.PersistenceContext;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
import lapr4.jobs4u.jobopeningmanagement.domain.JobReference;
import lapr4.jobs4u.usermanagement.application.AddUserController;
import lapr4.jobs4u.usermanagement.domain.BaseRoles;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import java.util.Map;

import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

/**
 * UI for adding a user to the application.
 *
 * Created by nuno on 22/03/16.
 */
public class ImportApplicationsUI extends AbstractUI {

    private final RegisterCandidateController registerCandidateController = new RegisterCandidateController(
            PersistenceContext.repositories().candidates(), PersistenceContext.repositories().candidateUsers(),
            AuthzRegistry.authorizationService());

    private final AddUserController addUserController = new AddUserController();

    private final ImportApplicationsController theController = new ImportApplicationsController(
            PersistenceContext.repositories().applications(), PersistenceContext.repositories().jobOpenings());

    private final static String DEFAULT_FOLDER = "jobs4u.applicationsFileBot/resources/output";

    @Override
    protected boolean doShow() {

        // TODO: If user already exists, skip application
        // TODO: If candidate already exists, skip application
        // TODO: If application already exists, skip application
        // TODO: If job opening does not exist, skip application

        String folder;
        if (Console.readBoolean("Do you want to use the default Path? (Y/N)")) {
            folder = DEFAULT_FOLDER;
        } else {

            folder = Console.readLine("Shared Folder Path (Insert a valid path):");
            if (!Files.exists(Paths.get(folder)) && haveReportFile(folder)) {
                System.out.println("Invalid Path");
                return false;
            }
        }

        Map<String, Set<String>> candidateJobMap = new HashMap<>();

        candidateJobMap = this.theController.getCandidates(folder);

        candidateJobMap.forEach((jobOffer, candidateSet) -> {
            candidateSet.forEach(candidateId -> {
                Candidate candidate = registerCandidates(folder, candidateId, jobOffer);
                JobOpening job = this.theController.getJobOpennig(JobReference.valueOf(jobOffer));
                if (job == null) {
                    System.out.println("Job Opening does not exist");
                    return;
                }
                List<File> files = this.theController.getFiles(folder, candidateId, jobOffer);

                registerApplication(files, job, candidate);
            });
        });

        return false;
    }

    private Candidate registerCandidates(String folder, String candidateId, String jobOffer) {

        List<String> output = this.theController.getCandidateInfo(folder, candidateId, jobOffer);
        String email = output.get(0);
        String phoneNumber = output.get(1);
        String firstName = output.get(2);
        String lastName = output.get(3);

        try {
            final Set<Role> roleTypes = new HashSet<>();
            roleTypes.add(BaseRoles.CANDIDATE);
            final Candidate candidate = this.registerCandidateController.registerCandidate(firstName, lastName,
                    email,
                    phoneNumber);
            final SystemUser user = this.addUserController.addUser(email, firstName,
                    lastName, roleTypes);
            this.registerCandidateController.registerCandidateUser(candidate, user);

            return candidate;
        } catch (final IntegrityViolationException | ConcurrencyException e) {
            System.out.println("That E-mail is already registered.");
        }
        return null;

    }

    private void registerApplication(List<File> files, JobOpening job,
            Candidate candidate) {

        this.theController.registerApplication(files, job, candidate);
    }

    private boolean haveReportFile(String folder) {
        return this.theController.haveReportFile(folder);
    }

    @Override
    public String headline() {
        return "Import Applications";
    }
}
