package lapr4.jobs4u.usermanagement.application;

import java.util.Optional;

import lapr4.jobs4u.usermanagement.domain.BaseRoles;
import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserManagementService;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.authz.domain.model.Username;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;

/**
 * @author 2DI2
 */
@UseCaseController
public class ListUsersController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final UserManagementService userSvc = AuthzRegistry.userService();
    private final ListBackofficeUsersService listBackofficeUsersService;

    public ListUsersController(UserRepository userRepository) {
        this.listBackofficeUsersService = new ListBackofficeUsersService(userRepository);
    }

    public Iterable<SystemUser> allUsers() {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.ADMIN, BaseRoles.POWERUSER);

        return userSvc.allUsers();
    }

    public Optional<SystemUser> find(final Username u) {
        return userSvc.userOfIdentity(u);
    }

    public Iterable<SystemUser> backofficeUsers() {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.ADMIN, BaseRoles.POWERUSER);

        return listBackofficeUsersService.backofficeUsers();
    }
}
