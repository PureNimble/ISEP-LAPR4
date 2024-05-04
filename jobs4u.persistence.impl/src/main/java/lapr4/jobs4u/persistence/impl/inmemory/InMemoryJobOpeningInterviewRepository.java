package lapr4.jobs4u.persistence.impl.inmemory;

import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpeningInterview;
import lapr4.jobs4u.jobopeningmanagement.repositories.JobOpeningInterviewRepository;

public class InMemoryJobOpeningInterviewRepository extends InMemoryDomainRepository<JobOpeningInterview, Long>
        implements JobOpeningInterviewRepository {

    static {
        InMemoryInitializer.init();
    }

}
