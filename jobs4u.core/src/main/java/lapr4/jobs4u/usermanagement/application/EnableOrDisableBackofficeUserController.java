package lapr4.jobs4u.usermanagement.application;

import lapr4.jobs4u.usermanagement.domain.BaseRoles;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserManagementService;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

/**
 * @author 2DI2
 */
@UseCaseController
public class EnableOrDisableBackofficeUserController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final UserManagementService userSvc = AuthzRegistry.userService();

    public Iterable<SystemUser> allUsers() {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.ADMIN, BaseRoles.POWERUSER);

        return userSvc.allUsers();
    }

    public Iterable<SystemUser> activeUsers() {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.ADMIN, BaseRoles.POWERUSER);

        return this.backOffice(userSvc.activeUsers());
    }

    public Iterable<SystemUser> deactivatedUsers() {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.ADMIN, BaseRoles.POWERUSER);

        return this.backOffice(userSvc.deactivatedUsers());
    }

    public Iterable<SystemUser> backOffice(Iterable<SystemUser> systemUsers) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.ADMIN, BaseRoles.POWERUSER);

        List<SystemUser> userList = new ArrayList<>();
        systemUsers.forEach(userList::add);
        List<SystemUser> filtered = userList.stream()
                .filter(systemUser -> systemUser.hasAny(BaseRoles.nonUserValues()))
                .collect(Collectors.toList());
        return filtered;
    }

    public void enableOrDisableUser(SystemUser user, String newStatus) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.ADMIN, BaseRoles.POWERUSER);

        if (newStatus.equalsIgnoreCase("enable")) {
            userSvc.activateUser(user);
        } else if (newStatus.equalsIgnoreCase("disable")) {
            userSvc.deactivateUser(user);
        }
    }
}
