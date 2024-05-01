package lapr4.jobs4u.customermanagement.application;

import java.util.Optional;

import lapr4.jobs4u.customermanagement.domain.Customer;
import lapr4.jobs4u.customermanagement.domain.CustomerCode;
import lapr4.jobs4u.usermanagement.domain.BaseRoles;
import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

/**
 *
 * @author losa
 */
@UseCaseController
public class ListCustomersController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final ListCustomersService customerService = new ListCustomersService();

    public Iterable<Customer> allCustomers() {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER);
        return customerService.allUsers();
    }

    public Optional<Customer> find(final CustomerCode u) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER);
        return customerService.findByCustomerCode(u);
    }

    public Iterable<Customer> filterByCostumerManager() {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER);
        return customerService.filterByCostumerManager();
    }
}
