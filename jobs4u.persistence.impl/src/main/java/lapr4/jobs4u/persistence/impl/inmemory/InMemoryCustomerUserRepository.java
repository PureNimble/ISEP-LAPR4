package lapr4.jobs4u.persistence.impl.inmemory;

import java.util.Optional;

import eapli.framework.infrastructure.authz.domain.model.Username;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;
import lapr4.jobs4u.customermanagement.domain.CustomerCode;
import lapr4.jobs4u.customermanagement.domain.CustomerUser;
import lapr4.jobs4u.customermanagement.repositories.CustomerUserRepository;

public class InMemoryCustomerUserRepository extends InMemoryDomainRepository<CustomerUser, Long>
        implements CustomerUserRepository {

    static {
        InMemoryInitializer.init();
    }

    @Override
    public Optional<CustomerUser> findByEmail(final Username email) {
        return matchOne(e -> e.user().username().equals(email));
    }

    @SuppressWarnings("unlikely-arg-type")
    @Override
    public Optional<CustomerUser> findByCustomerCode(final CustomerCode number) {
        return Optional.of(data().get(number));
    }
}
