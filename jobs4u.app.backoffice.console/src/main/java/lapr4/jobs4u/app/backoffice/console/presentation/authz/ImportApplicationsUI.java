package lapr4.jobs4u.app.backoffice.console.presentation.authz;

import lapr4.jobs4u.app.common.console.presentation.utils.Utils;
import lapr4.jobs4u.applicationmanagement.application.ImportApplicationsController;
import lapr4.jobs4u.applicationmanagement.domain.File;
import lapr4.jobs4u.candidatemanagement.application.RegisterCandidateController;
import lapr4.jobs4u.candidatemanagement.domain.Candidate;
import lapr4.jobs4u.infrastructure.persistence.PersistenceContext;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
import lapr4.jobs4u.jobopeningmanagement.domain.JobReference;
import lapr4.jobs4u.usermanagement.application.AddUserController;
import lapr4.jobs4u.usermanagement.domain.BaseRoles;

import java.nio.file.Path;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import java.util.Map;

import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.presentation.console.AbstractUI;

/**
 * @author 2DI2
 */
public class ImportApplicationsUI extends AbstractUI {

    private static final String EMAIL_ALREADY_REGISTERED = "That E-mail is already registered.";
    private static final String JOB_OPENING_DOES_NOT_EXIST = "Job Opening does not exist";

    private final TransactionalContext txCtx = PersistenceContext.repositories().newTransactionalContext();
    private final RegisterCandidateController registerCandidateController;
    private final AddUserController addUserController;
    private final ImportApplicationsController theController;

    public ImportApplicationsUI() {
        registerCandidateController = new RegisterCandidateController(
                PersistenceContext.repositories().candidates(txCtx),
                PersistenceContext.repositories().candidateUsers(txCtx),
                AuthzRegistry.authorizationService());

        addUserController = new AddUserController();

        theController = new ImportApplicationsController(
                PersistenceContext.repositories().applications(txCtx), PersistenceContext.repositories().jobOpenings());
    }

    @Override
    protected boolean doShow() {
        System.out.println("Please insert the folder path");
        final Path path = Utils.getPath(true);
        if (path == null)
            return false;
        final String folder = path.toString();
        if (folder == null && haveReportFile(folder)) {
            System.out.println("Invalid Folder");
            return false;
        }

        Map<String, Set<String>> candidateJobMap = theController.getCandidates(folder);
        processCandidates(candidateJobMap, folder);

        return false;
    }

    private void processCandidates(final Map<String, Set<String>> candidateJobMap, final String folder) {
        candidateJobMap.forEach((jobOffer, candidateSet) -> {
            candidateSet.forEach(candidateId -> {
                final JobOpening job = theController.getJobOpening(JobReference.valueOf(jobOffer));
                if (job == null) {
                    System.out.println(JOB_OPENING_DOES_NOT_EXIST);
                    return;
                }
                final List<File> files = theController.getFiles(folder, candidateId, jobOffer);
                if (files.isEmpty()) {
                    System.out.println("No files found for candidate " + candidateId + " in job offer " + jobOffer);
                    return;
                }
                try {
                    txCtx.beginTransaction();
                    final Candidate candidate = registerCandidates(folder, candidateId, jobOffer);
                    registerApplication(files, job, candidate);
                    txCtx.commit();
                } catch (final IntegrityViolationException | ConcurrencyException e) {
                    txCtx.rollback();
                    System.out.println(EMAIL_ALREADY_REGISTERED);
                } finally {
                    txCtx.close();
                }
            });
        });
    }

    private Candidate registerCandidates(final String folder, final String candidateId, final String jobOffer) {
        List<String> output = theController.getCandidateInfo(folder, candidateId, jobOffer);
        final String email = output.get(0);
        final String phoneNumber = output.get(1);
        final String firstName = output.get(2);
        final String lastName = output.get(3);

        final Set<Role> roleTypes = new HashSet<>();
        roleTypes.add(BaseRoles.CANDIDATE);
        final Candidate candidate = registerCandidateController.registerCandidate(firstName, lastName,
                email,
                phoneNumber);
        final SystemUser user = addUserController.addUser(email, firstName,
                lastName, roleTypes);
        registerCandidateController.registerCandidateUser(candidate, user);

        return candidate;
    }

    private void registerApplication(final List<File> files, final JobOpening job, final Candidate candidate) {
        theController.registerApplication(files, job, candidate);
    }

    private boolean haveReportFile(final String folder) {
        return theController.isPathValid(folder);
    }

    @Override
    public String headline() {
        return "Import Applications";
    }
}