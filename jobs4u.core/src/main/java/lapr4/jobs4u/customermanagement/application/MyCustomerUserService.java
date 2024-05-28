package lapr4.jobs4u.customermanagement.application;

import java.util.Optional;

import lapr4.jobs4u.customermanagement.domain.CustomerUser;
import lapr4.jobs4u.customermanagement.repositories.CustomerUserRepository;
import lapr4.jobs4u.infrastructure.persistence.PersistenceContext;
import lapr4.jobs4u.usermanagement.domain.BaseRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserSession;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

/**
 * @author 2DI2
 */
public class MyCustomerUserService {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final CustomerUserRepository repo = PersistenceContext.repositories().customerUsers();

    public CustomerUser me() {
        final UserSession s = authz.session().orElseThrow(IllegalStateException::new);
        final SystemUser myUser = s.authenticatedUser();
        // TODO cache the client user object
        final Optional<CustomerUser> me = repo.findByEmail(myUser.identity());
        return me.orElseThrow(IllegalStateException::new);
    }

    public CustomerUser myUser() {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER);
        final UserSession s = authz.session().orElseThrow(IllegalStateException::new);
        final SystemUser me = s.authenticatedUser();
        return repo.findByEmail(me.identity()).orElseThrow(IllegalStateException::new);
    }

}
