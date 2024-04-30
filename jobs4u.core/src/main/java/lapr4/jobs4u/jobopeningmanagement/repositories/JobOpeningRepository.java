package lapr4.jobs4u.jobopeningmanagement.repositories;

import java.util.Optional;

import eapli.framework.domain.repositories.DomainRepository;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
import lapr4.jobs4u.jobopeningmanagement.domain.JobReference;

public interface JobOpeningRepository extends DomainRepository<JobReference, JobOpening> {
    Optional<JobOpening> findByJobReference(final JobReference reference);
}

