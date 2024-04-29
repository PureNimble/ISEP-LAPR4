package lapr4.jobs4u.customermanagement.application;

import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserSession;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import lapr4.jobs4u.customermanagement.domain.Customer;
import lapr4.jobs4u.customermanagement.domain.CustomerBuilder;
import lapr4.jobs4u.customermanagement.domain.CustomerUser;
import lapr4.jobs4u.customermanagement.domain.CustomerUserBuilder;
import lapr4.jobs4u.customermanagement.repositories.CustomerRepository;
import lapr4.jobs4u.customermanagement.repositories.CustomerUserRepository;
import lapr4.jobs4u.usermanagement.domain.BaseRoles;

@UseCaseController
public class RegisterCustomerController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final CustomerRepository customerRepository;
    private final CustomerUserRepository customerUserRepository;

    public RegisterCustomerController(final CustomerRepository customerRepository,
            final CustomerUserRepository customerUserRepository) {
        this.customerRepository = customerRepository;
        this.customerUserRepository = customerUserRepository;
    }

    public Customer registerCustomer(final String name, final String address, final String customerCode,
            final String email, final String phoneNumber) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER);
        return createCustomer(name, address, customerCode, email, phoneNumber);
    }

    public CustomerUser registerCustomerUser(final Customer customer,
            final SystemUser systemUser) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER);
        final UserSession s = authz.session().orElseThrow(IllegalStateException::new);
        final SystemUser manager = s.authenticatedUser();
        return createCustomerUser(customer, systemUser, manager);
    }

    private Customer createCustomer(final String name, final String address, final String customerCode,
            final String email, final String phoneNumber) {
        final Customer customer = doCreateCustomer(name, address, customerCode, email, phoneNumber);
        return customerRepository.save(customer);
    }

    private CustomerUser createCustomerUser(final Customer customer,
            final SystemUser systemUser,
            final SystemUser manager) {
        final CustomerUser customerUser = doCreateCustomerUser(customer, systemUser, manager);
        return customerUserRepository.save(customerUser);
    }

    private Customer doCreateCustomer(final String name, final String address, final String customerCode,
            final String email, final String phoneNumber) {
        return new CustomerBuilder().with(name, address, customerCode, email, phoneNumber).build();
    }

    private CustomerUser doCreateCustomerUser(final Customer customer,
            final SystemUser systemUser,
            final SystemUser manager) {
        return new CustomerUserBuilder().with(customer,
                systemUser, manager).build();
    }
}
