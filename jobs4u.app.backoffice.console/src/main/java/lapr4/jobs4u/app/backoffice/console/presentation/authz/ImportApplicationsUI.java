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

public class ImportApplicationsUI extends AbstractUI {

    private static final String DEFAULT_FOLDER = "jobs4u.applicationsFileBot/resources/output";
    private static final String EMAIL_ALREADY_REGISTERED = "That E-mail is already registered.";
    private static final String JOB_OPENING_DOES_NOT_EXIST = "Job Opening does not exist";
    private static final String INVALID_PATH = "Invalid Path";

    private final RegisterCandidateController registerCandidateController;
    private final AddUserController addUserController;
    private final ImportApplicationsController theController;

    public ImportApplicationsUI() {
        registerCandidateController = new RegisterCandidateController(
                PersistenceContext.repositories().candidates(), PersistenceContext.repositories().candidateUsers(),
                AuthzRegistry.authorizationService());

        addUserController = new AddUserController();

        theController = new ImportApplicationsController(
                PersistenceContext.repositories().applications(), PersistenceContext.repositories().jobOpenings());
    }

    @Override
    protected boolean doShow() {
        String folder = getFolderPath();
        if (folder == null) {
            return false;
        }

        Map<String, Set<String>> candidateJobMap = theController.getCandidates(folder);
        processCandidates(candidateJobMap, folder);

        return false;
    }

    private String getFolderPath() {
        if (Console.readBoolean("Do you want to use the default Path? (Y/N)")) {
            return DEFAULT_FOLDER;
        } else {
            String folder = Console.readLine("Shared Folder Path (Insert a valid path):");
            if (!Files.exists(Paths.get(folder)) && haveReportFile(folder)) {
                System.out.println(INVALID_PATH);
                return null;
            }
            return folder;
        }
    }

    private void processCandidates(Map<String, Set<String>> candidateJobMap, String folder) {
        candidateJobMap.forEach((jobOffer, candidateSet) -> {
            candidateSet.forEach(candidateId -> {
                JobOpening job = theController.getJobOpening(JobReference.valueOf(jobOffer));
                if (job == null) {
                    System.out.println(JOB_OPENING_DOES_NOT_EXIST);
                    return;
                }
                List<File> files = theController.getFiles(folder, candidateId, jobOffer);
                Candidate candidate = registerCandidates(folder, candidateId, jobOffer);
                registerApplication(files, job, candidate);
            });
        });
    }

    private Candidate registerCandidates(String folder, String candidateId, String jobOffer) {
        List<String> output = theController.getCandidateInfo(folder, candidateId, jobOffer);
        String email = output.get(0);
        String phoneNumber = output.get(1);
        String firstName = output.get(2);
        String lastName = output.get(3);

        try {
            final Set<Role> roleTypes = new HashSet<>();
            roleTypes.add(BaseRoles.CANDIDATE);
            final Candidate candidate = registerCandidateController.registerCandidate(firstName, lastName,
                    email,
                    phoneNumber);
            final SystemUser user = addUserController.addUser(email, firstName,
                    lastName, roleTypes);
            registerCandidateController.registerCandidateUser(candidate, user);

            return candidate;
        } catch (final IntegrityViolationException | ConcurrencyException e) {
            System.out.println(EMAIL_ALREADY_REGISTERED);
        }
        return null;
    }

    private void registerApplication(List<File> files, JobOpening job, Candidate candidate) {
        theController.registerApplication(files, job, candidate);
    }

    private boolean haveReportFile(String folder) {
        return theController.haveReportFile(folder);
    }

    @Override
    public String headline() {
        return "Import Applications";
    }
}