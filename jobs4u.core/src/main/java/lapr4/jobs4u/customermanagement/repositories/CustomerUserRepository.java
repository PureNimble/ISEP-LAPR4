package lapr4.jobs4u.customermanagement.repositories;

import java.util.Optional;

import eapli.framework.domain.repositories.DomainRepository;
import eapli.framework.infrastructure.authz.domain.model.Username;
import lapr4.jobs4u.customermanagement.domain.CustomerCode;
import lapr4.jobs4u.customermanagement.domain.CustomerUser;

public interface CustomerUserRepository extends DomainRepository<Long, CustomerUser> {
    Optional<CustomerUser> findByCustomerCode(final CustomerCode number);
    Optional<CustomerUser> findByEmail(final Username identity);
}

