package lapr4.jobs4u.customermanagement.application;

import java.util.Optional;

import lapr4.jobs4u.customermanagement.domain.Customer;
import lapr4.jobs4u.customermanagement.domain.CustomerCode;
import lapr4.jobs4u.customermanagement.repositories.CustomerRepository;
import lapr4.jobs4u.usermanagement.domain.BaseRoles;
import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;

/**
 *
 * @author losa
 */
@UseCaseController
public class ListCustomersController {

    private final AuthorizationService authz;
    private final ListCustomersService customerService;

    public ListCustomersController(CustomerRepository customerRepository, AuthorizationService authz) {
        this.customerService = new ListCustomersService(customerRepository, authz);
        this.authz = authz;
    }


    public Iterable<Customer> allCustomers() {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER, BaseRoles.POWERUSER);
        return customerService.allUsers();
    }

    public Optional<Customer> find(final CustomerCode u) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER, BaseRoles.POWERUSER);
        return customerService.findByCustomerCode(u);
    }

    public Iterable<Customer> filterByCostumerManager() {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER, BaseRoles.POWERUSER);
        return customerService.filterByCostumerManager();
    }
}
