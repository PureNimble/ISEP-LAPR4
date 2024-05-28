package lapr4.jobs4u.persistence.impl.inmemory;

import java.util.Optional;

import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpeningInterview;
import lapr4.jobs4u.jobopeningmanagement.repositories.JobOpeningInterviewRepository;

/**
 * @author 2DI2
 */
public class InMemoryJobOpeningInterviewRepository extends InMemoryDomainRepository<JobOpeningInterview, Long>
        implements JobOpeningInterviewRepository {

    static {
        InMemoryInitializer.init();
    }

    @Override
    public Optional<JobOpeningInterview> findJobOpeningInterviewsByJobOpening(JobOpening jobOpening) {
        return matchOne(e -> e.jobOpening().equals(jobOpening));
    }

}
