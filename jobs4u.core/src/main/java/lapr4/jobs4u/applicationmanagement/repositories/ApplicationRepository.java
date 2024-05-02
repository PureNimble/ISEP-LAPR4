package lapr4.jobs4u.applicationmanagement.repositories;

import java.util.Optional;

import eapli.framework.domain.repositories.DomainRepository;
import lapr4.jobs4u.applicationmanagement.domain.Application;
import lapr4.jobs4u.applicationmanagement.domain.ApplicationCode;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
import lapr4.jobs4u.jobopeningmanagement.domain.JobReference;

public interface ApplicationRepository extends DomainRepository<ApplicationCode, Application> {
    Optional<Application> findByApplicationCode(final ApplicationCode code);
    Iterable<Application> filterByJobOpening(final JobOpening jobOpening);

    String findHighestSequenceForCustomer(JobReference jobReference);
}
