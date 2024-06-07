package lapr4.jobs4u.persistence.impl.inmemory;

import java.util.Optional;

import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.domain.model.Username;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;
import lapr4.jobs4u.customermanagement.domain.Customer;
import lapr4.jobs4u.customermanagement.domain.CustomerCode;
import lapr4.jobs4u.customermanagement.repositories.CustomerRepository;

/**
 * @author 2DI2
 */
public class InMemoryCustomerRepository
        extends InMemoryDomainRepository<Customer, CustomerCode>
        implements CustomerRepository {

    static {
        InMemoryInitializer.init();
    }

    @Override
    public Optional<Customer> findByCustomerCode(final CustomerCode number) {
        return Optional.of(data().get(number));
    }

    @Override
    public Iterable<Customer> filterByCostumerManager(final Username name) {
        return match(e -> e.manager().username().equals(name));
    }

    @Override
    public Optional<Customer> findByEmail(final EmailAddress email) {
        return matchOne(e -> e.email().equals(email));
    }
}
