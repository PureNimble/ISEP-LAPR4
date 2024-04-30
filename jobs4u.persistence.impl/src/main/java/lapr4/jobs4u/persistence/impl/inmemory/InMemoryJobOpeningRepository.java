package lapr4.jobs4u.persistence.impl.inmemory;

import java.util.Optional;

import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
import lapr4.jobs4u.jobopeningmanagement.domain.JobReference;
import lapr4.jobs4u.jobopeningmanagement.repositories.JobOpeningRepository;

public class InMemoryJobOpeningRepository extends InMemoryDomainRepository<JobOpening, JobReference>
        implements JobOpeningRepository {

    static {
        InMemoryInitializer.init();
    }

    @Override
    public Optional<JobOpening> findByJobReference(final JobReference reference) {
        return Optional.of(data().get(reference));
    }
 }