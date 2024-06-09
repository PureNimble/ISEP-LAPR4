package lapr4.jobs4u.usermanagement.application;

import java.util.Calendar;
import java.util.Set;

import lapr4.jobs4u.usermanagement.domain.BaseRoles;
import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserManagementService;
import eapli.framework.infrastructure.authz.domain.model.RandomRawPassword;
import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.time.util.CurrentTimeCalendars;

/**
 * @author 2DI2
 */
@UseCaseController
public class AddUserController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final UserManagementService userSvc = AuthzRegistry.userService();

    /**
     * Get existing RoleTypes available to the user.
     *
     * @return a list of RoleTypes
     */
    public Role[] getRoleTypes() {
        return BaseRoles.nonUserValues();
    }

    public SystemUser addUser(final String email, final String password, final String firstName, final String lastName,
            final Set<Role> roles, final Calendar createdOn) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.ADMIN, BaseRoles.CUSTOMER_MANAGER, BaseRoles.OPERATOR,
                BaseRoles.POWERUSER);

        return userSvc.registerNewUser(email, password, firstName, lastName, roles, createdOn);
    }

    public SystemUser addUser(final String email, final String firstName, final String lastName,
            final Set<Role> roles) {
        return addUser(email, new RandomRawPassword().toString().replaceAll("€", ""), firstName, lastName, roles,
                CurrentTimeCalendars.now());
    }
}
