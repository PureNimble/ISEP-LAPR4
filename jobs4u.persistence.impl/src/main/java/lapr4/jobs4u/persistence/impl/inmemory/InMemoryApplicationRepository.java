package lapr4.jobs4u.persistence.impl.inmemory;

import java.util.Optional;

import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;
import lapr4.jobs4u.applicationmanagement.domain.Application;
import lapr4.jobs4u.applicationmanagement.domain.ApplicationNumber;
import lapr4.jobs4u.applicationmanagement.repositories.ApplicationRepository;

/**
 *
 * @author Jorge Santos ajs@isep.ipp.pt 02/04/2016
 */
public class InMemoryApplicationRepository
        extends InMemoryDomainRepository<Application, ApplicationNumber>
        implements ApplicationRepository {

    static {
        InMemoryInitializer.init();
    }

    @Override
    public Optional<Application> findByApplicationNumber(final ApplicationNumber number) {
        return Optional.of(data().get(number));
    }
}
