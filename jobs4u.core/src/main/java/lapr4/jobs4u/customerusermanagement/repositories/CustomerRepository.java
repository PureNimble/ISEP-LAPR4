package lapr4.jobs4u.customerusermanagement.repositories;

import java.util.Optional;

import eapli.framework.domain.repositories.DomainRepository;
import eapli.framework.infrastructure.authz.domain.model.Username;
import lapr4.jobs4u.customerusermanagement.domain.Customer;
import lapr4.jobs4u.customerusermanagement.domain.CustomerCode;

public interface CustomerRepository extends DomainRepository<CustomerCode, Customer> {
    Iterable<Customer> findAllActive();
    Optional<Customer> findByCustomerCode(final CustomerCode number);
    Optional<Customer> findByEmail(final Username identity);
}

