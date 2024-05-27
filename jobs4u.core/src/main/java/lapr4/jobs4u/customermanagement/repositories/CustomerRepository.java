package lapr4.jobs4u.customermanagement.repositories;

import java.util.Optional;

import eapli.framework.domain.repositories.DomainRepository;
import eapli.framework.infrastructure.authz.domain.model.Username;
import lapr4.jobs4u.customermanagement.domain.Customer;
import lapr4.jobs4u.customermanagement.domain.CustomerCode;

/**
 * @author 2DI2
 */
public interface CustomerRepository extends DomainRepository<CustomerCode, Customer> {
    Optional<Customer> findByCustomerCode(final CustomerCode number);
    Iterable<Customer> findAll();
    Iterable<Customer> filterByCostumerManager(final Username name);
}

