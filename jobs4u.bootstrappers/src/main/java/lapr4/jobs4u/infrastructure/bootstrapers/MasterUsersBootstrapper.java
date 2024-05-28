package lapr4.jobs4u.infrastructure.bootstrapers;

import java.util.HashSet;
import java.util.Set;

import lapr4.jobs4u.usermanagement.domain.BaseRoles;
import eapli.framework.actions.Action;
import eapli.framework.infrastructure.authz.domain.model.Role;

/**
 * @author 2DI2
 */
public class MasterUsersBootstrapper extends Jobs4UBootstrapperBase implements Action {

    @Override
    public boolean execute() {
        registerAdmin("admin@email.local", "John", "Doe");
        return true;
    }

    /**
     *
     */
    private void registerAdmin(final String email, final String firstName,
            final String lastName) {
        final Set<Role> roles = new HashSet<>();
        roles.add(BaseRoles.ADMIN);
        
        registerUser(email, firstName, lastName, roles);
    }
}
