package lapr4.jobs4u.customerusermanagement.application;

import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import lapr4.jobs4u.customerusermanagement.domain.Customer;
import lapr4.jobs4u.customerusermanagement.domain.CustomerBuilder;
import lapr4.jobs4u.customerusermanagement.repositories.CustomerRepository;
import lapr4.jobs4u.usermanagement.domain.BaseRoles;

@UseCaseController
public class RegisterCustomerController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final CustomerRepository customerRepository;

    public RegisterCustomerController(final CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer registerCustomer(final SystemUser systemUser, final String name, final String address, final String customerCode,
    final String email, final String phoneNumber) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER);
        return createCustomer(systemUser, name, address, customerCode, email, phoneNumber);
    }

    private Customer createCustomer(final SystemUser systemUser, final String name, final String address, final String customerCode,
    final String email, final String phoneNumber) {
        final Customer customer = doCreateCustomer(systemUser, name, address, customerCode, email, phoneNumber);
        return customerRepository.save(customer);
    }

    private Customer doCreateCustomer(final SystemUser systemUser, final String name, final String address, final String customerCode,
            final String email, final String phoneNumber) {
        return new CustomerBuilder().with(systemUser, name, address, customerCode, email, phoneNumber).build();
    }
}
