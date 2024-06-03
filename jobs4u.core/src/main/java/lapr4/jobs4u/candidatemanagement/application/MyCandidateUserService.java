package lapr4.jobs4u.candidatemanagement.application;

import java.util.Optional;

import lapr4.jobs4u.candidatemanagement.domain.CandidateUser;
import lapr4.jobs4u.candidatemanagement.repositories.CandidateUserRepository;
import lapr4.jobs4u.infrastructure.persistence.PersistenceContext;
import lapr4.jobs4u.usermanagement.domain.BaseRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserSession;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

/**
 * @author 2DI2
 */
public class MyCandidateUserService {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final CandidateUserRepository repo = PersistenceContext.repositories().candidateUsers();

    public CandidateUser me() {
        final UserSession s = authz.session().orElseThrow(IllegalStateException::new);
        final SystemUser myUser = s.authenticatedUser();
        // TODO cache the client user object
        final Optional<CandidateUser> me = repo.findBySystemUser(myUser);
        return me.orElseThrow(IllegalStateException::new);
    }

    public CandidateUser myUser() {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER);
        final UserSession s = authz.session().orElseThrow(IllegalStateException::new);
        final SystemUser me = s.authenticatedUser();
        return repo.findBySystemUser(me).orElseThrow(IllegalStateException::new);
    }

}
