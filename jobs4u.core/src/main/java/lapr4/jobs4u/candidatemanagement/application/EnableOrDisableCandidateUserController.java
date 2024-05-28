package lapr4.jobs4u.candidatemanagement.application;

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
public class EnableOrDisableCandidateUserController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final UserManagementService userSvc = AuthzRegistry.userService();

    public Iterable<SystemUser> activeUsers() {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.OPERATOR, BaseRoles.POWERUSER);

        return this.candidateUsers(userSvc.activeUsers());
    }

    public Iterable<SystemUser> deactivatedUsers() {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.OPERATOR, BaseRoles.POWERUSER);

        return this.candidateUsers(userSvc.deactivatedUsers());
    }

    public Iterable<SystemUser> candidateUsers(Iterable<SystemUser> systemUsers) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.OPERATOR, BaseRoles.POWERUSER);

        List<SystemUser> userList = new ArrayList<>();
        systemUsers.forEach(userList::add);
        List<SystemUser> filtered = userList.stream()
                .filter(systemUser -> systemUser.hasAny(BaseRoles.CANDIDATE))
                .collect(Collectors.toList());
        return filtered;
    }

    public void enableOrDisableUser(SystemUser user, String newStatus) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.OPERATOR, BaseRoles.POWERUSER);

        if (newStatus.equalsIgnoreCase("enable")) {
            userSvc.activateUser(user);
        } else if (newStatus.equalsIgnoreCase("disable")) {
            userSvc.deactivateUser(user);
        }
    }
}
