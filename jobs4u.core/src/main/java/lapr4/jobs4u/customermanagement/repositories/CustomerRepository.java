package lapr4.jobs4u.customermanagement.repositories;

import java.util.Optional;

import eapli.framework.domain.repositories.DomainRepository;
import lapr4.jobs4u.customermanagement.domain.Customer;
import lapr4.jobs4u.customermanagement.domain.CustomerCode;

public interface CustomerRepository extends DomainRepository<CustomerCode, Customer> {
    Optional<Customer> findByCustomerCode(final CustomerCode number);
}

