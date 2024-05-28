package lapr4.jobs4u.infrastructure.bootstrapers.demo;

import java.util.HashSet;
import java.util.Set;

import lapr4.jobs4u.infrastructure.bootstrapers.Jobs4UBootstrapperBase;
import lapr4.jobs4u.usermanagement.domain.BaseRoles;
import eapli.framework.actions.Action;
import eapli.framework.infrastructure.authz.domain.model.Role;

/**
 * @author 2DI2
 */
public class BackofficeUsersBootstrapper extends Jobs4UBootstrapperBase implements Action {

    @Override
    public boolean execute() {
        registerCustomerManager("cm@email.local", "Customer", "Manager");
        registerOperator("op@email.local", "Operator", "Operator");
        registerLanguageEngineer("le@email.local", "Language", "Engineer");
        return true;
    }

    private void registerCustomerManager(final String email, final String firstName, final String lastName) {
        final Set<Role> roles = new HashSet<>();
        roles.add(BaseRoles.CUSTOMER_MANAGER);
    
        registerUser(email, firstName, lastName, roles);
    }
    
    private void registerOperator(final String email, final String firstName, final String lastName) {
        final Set<Role> roles = new HashSet<>();
        roles.add(BaseRoles.OPERATOR);
    
        registerUser(email, firstName, lastName, roles);
    }
    
    private void registerLanguageEngineer(final String email, final String firstName, final String lastName) {
        final Set<Role> roles = new HashSet<>();
        roles.add(BaseRoles.LANGUAGE_ENGINEER);
    
        registerUser(email, firstName, lastName, roles);
    }
}
