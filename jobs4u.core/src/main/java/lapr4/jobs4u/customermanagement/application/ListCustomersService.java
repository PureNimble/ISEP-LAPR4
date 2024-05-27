package lapr4.jobs4u.customermanagement.application;

import java.util.Optional;

import org.springframework.stereotype.Component;

import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.UserSession;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import lapr4.jobs4u.customermanagement.domain.Customer;
import lapr4.jobs4u.customermanagement.domain.CustomerCode;
import lapr4.jobs4u.customermanagement.repositories.CustomerRepository;

/**
 * @author 2DI2
 */
@Component
public class ListCustomersService {

    private final CustomerRepository customerRepository;
    private final AuthorizationService authz;

    public ListCustomersService(CustomerRepository customerRepository, AuthorizationService authz) {
        this.customerRepository = customerRepository;
        this.authz = authz;
    }

    public Iterable<Customer> allUsers() {
        return this.customerRepository.findAll();
    }

    public Optional<Customer> findByCustomerCode(final CustomerCode code) {
        return this.customerRepository.ofIdentity(code);
    }

    public Iterable<Customer> filterByCostumerManager() {
        final UserSession s = authz.session().orElseThrow(IllegalStateException::new);
        final SystemUser manager = s.authenticatedUser();
        return this.customerRepository.filterByCostumerManager(manager.username());
    }
}