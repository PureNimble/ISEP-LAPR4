package lapr4.jobs4u.interviewmanagement.repositories;

import java.util.Optional;

import eapli.framework.domain.repositories.DomainRepository;
import lapr4.jobs4u.applicationmanagement.domain.Application;
import lapr4.jobs4u.interviewmanagement.domain.Interview;

public interface InterviewRepository extends DomainRepository<Long, Interview> {

    Optional<Interview> findInterview(Application application);
}
