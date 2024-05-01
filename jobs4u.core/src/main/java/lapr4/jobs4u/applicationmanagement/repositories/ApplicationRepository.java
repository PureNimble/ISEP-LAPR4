package lapr4.jobs4u.applicationmanagement.repositories;

import java.util.Optional;

import eapli.framework.domain.repositories.DomainRepository;
import lapr4.jobs4u.applicationmanagement.domain.Application;
import lapr4.jobs4u.applicationmanagement.domain.ApplicationNumber;
import lapr4.jobs4u.jobopeningmanagement.domain.JobReference;

public interface ApplicationRepository extends DomainRepository<ApplicationNumber, Application> {
    Optional<Application> findByApplicationNumber(final ApplicationNumber number);

    String findHighestSequenceForCustomer(JobReference jobReference);
}
