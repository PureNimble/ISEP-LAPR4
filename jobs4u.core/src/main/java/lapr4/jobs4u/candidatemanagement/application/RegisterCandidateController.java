package lapr4.jobs4u.candidatemanagement.application;

import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserSession;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import lapr4.jobs4u.candidatemanagement.domain.Candidate;
import lapr4.jobs4u.candidatemanagement.domain.CandidateBuilder;
import lapr4.jobs4u.candidatemanagement.domain.CandidateUser;
import lapr4.jobs4u.candidatemanagement.domain.CandidateUserBuilder;
import lapr4.jobs4u.candidatemanagement.repositories.CandidateRepository;
import lapr4.jobs4u.candidatemanagement.repositories.CandidateUserRepository;
import lapr4.jobs4u.usermanagement.domain.BaseRoles;

@UseCaseController
public class RegisterCandidateController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final CandidateRepository candidateRepository;
    private final CandidateUserRepository candidateUserRepository;

    public RegisterCandidateController(final CandidateRepository candidateRepository,
            final CandidateUserRepository candidateUserRepository) {
        this.candidateRepository = candidateRepository;
        this.candidateUserRepository = candidateUserRepository;
    }

    public Candidate registerCandidate(final String firstName, final String lastName,
            final String email, final String phoneNumber) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.OPERATOR);
        return createCandidate(firstName, lastName, email, phoneNumber);
    }

    public CandidateUser registerCandidateUser(final Candidate candidate,
            final SystemUser systemUser) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.OPERATOR);
        final UserSession s = authz.session().orElseThrow(IllegalStateException::new);
        final SystemUser manager = s.authenticatedUser();
        return createCandidateUser(candidate, systemUser, manager);
    }

    private Candidate createCandidate(final String firstName, final String lastName,
            final String email, final String phoneNumber) {
        final Candidate candidate = doCreateCandidate(firstName, lastName, email, phoneNumber);
        return candidateRepository.save(candidate);
    }

    private CandidateUser createCandidateUser(final Candidate candidate,
            final SystemUser systemUser,
            final SystemUser manager) {
        final CandidateUser candidateUser = doCreateCandidateUser(candidate, systemUser, manager);
        return candidateUserRepository.save(candidateUser);
    }

    private Candidate doCreateCandidate(final String firstName, final String lastName,
            final String email, final String phoneNumber) {
        return new CandidateBuilder().with(firstName, lastName,
                email, phoneNumber).build();
    }

    private CandidateUser doCreateCandidateUser(final Candidate candidate,
            final SystemUser systemUser,
            final SystemUser manager) {
        return new CandidateUserBuilder().with(candidate,
                systemUser, manager).build();
    }
}
