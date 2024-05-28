package lapr4.jobs4u.customermanagement.application;

import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.UserSession;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import lapr4.jobs4u.customermanagement.domain.Customer;
import lapr4.jobs4u.customermanagement.domain.CustomerBuilder;
import lapr4.jobs4u.customermanagement.domain.CustomerUser;
import lapr4.jobs4u.customermanagement.domain.CustomerUserBuilder;
import lapr4.jobs4u.customermanagement.repositories.CustomerRepository;
import lapr4.jobs4u.customermanagement.repositories.CustomerUserRepository;
import lapr4.jobs4u.usermanagement.domain.BaseRoles;

/**
 * @author 2DI2
 */
@UseCaseController
public class RegisterCustomerController {

    private final AuthorizationService authz;
    private final CustomerRepository customerRepository;
    private final CustomerUserRepository customerUserRepository;

    public RegisterCustomerController(final CustomerRepository customerRepository,
            final CustomerUserRepository customerUserRepository, final AuthorizationService authz) {
        this.customerRepository = customerRepository;
        this.customerUserRepository = customerUserRepository;
        this.authz = authz;
    }

    public Customer registerCustomer(final String name, final String address, final String customerCode,
            final String email, final String phoneNumber) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER, BaseRoles.POWERUSER);
        final UserSession s = authz.session().orElseThrow(IllegalStateException::new);
        final SystemUser manager = s.authenticatedUser();
        return createCustomer(name, address, customerCode, email, phoneNumber, manager);
    }

    public CustomerUser registerCustomerUser(final Customer customer,
            final SystemUser systemUser) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER, BaseRoles.POWERUSER);
        return createCustomerUser(customer, systemUser);
    }

    private Customer createCustomer(final String name, final String address, final String customerCode,
            final String email, final String phoneNumber, final SystemUser manager) {
        final Customer customer = doCreateCustomer(name, address, customerCode, email, phoneNumber, manager);
        return customerRepository.save(customer);
    }

    private CustomerUser createCustomerUser(final Customer customer,
            final SystemUser systemUser) {
        final CustomerUser customerUser = doCreateCustomerUser(customer, systemUser);
        return customerUserRepository.save(customerUser);
    }

    private Customer doCreateCustomer(final String name, final String address, final String customerCode,
            final String email, final String phoneNumber, final SystemUser manager) {
        return new CustomerBuilder().with(name, address, customerCode, email, phoneNumber, manager).build();
    }

    private CustomerUser doCreateCustomerUser(final Customer customer,
            final SystemUser systemUser) {
        return new CustomerUserBuilder().with(customer,
                systemUser).build();
    }
}
