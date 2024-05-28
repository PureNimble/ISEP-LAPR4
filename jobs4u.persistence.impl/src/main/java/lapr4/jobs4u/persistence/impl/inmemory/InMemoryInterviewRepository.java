package lapr4.jobs4u.persistence.impl.inmemory;

import java.util.Optional;

import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;
import lapr4.jobs4u.applicationmanagement.domain.Application;
import lapr4.jobs4u.interviewmanagement.domain.Interview;
import lapr4.jobs4u.interviewmanagement.repositories.InterviewRepository;

/**
 * @author 2DI2
 */
public class InMemoryInterviewRepository extends InMemoryDomainRepository<Interview, Long>
        implements InterviewRepository {

    static {
        InMemoryInitializer.init();
    }

    @Override
    public Optional<Interview> findInterview(Application application) {
        return findInterview(application);
    }

}
