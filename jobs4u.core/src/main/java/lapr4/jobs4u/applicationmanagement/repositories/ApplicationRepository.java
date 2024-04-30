package lapr4.jobs4u.applicationmanagement.repositories;

import java.util.Optional;

import eapli.framework.domain.repositories.DomainRepository;
import lapr4.jobs4u.applicationmanagement.domain.Application;
import lapr4.jobs4u.applicationmanagement.domain.ApplicationNumber;

public interface ApplicationRepository extends DomainRepository<ApplicationNumber, Application> {
    Optional<Application> findByApplicationNumber(final ApplicationNumber number);
}
