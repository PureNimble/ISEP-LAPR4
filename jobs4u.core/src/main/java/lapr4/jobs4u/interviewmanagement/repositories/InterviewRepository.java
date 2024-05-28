package lapr4.jobs4u.interviewmanagement.repositories;

import java.util.Optional;

import eapli.framework.domain.repositories.DomainRepository;
import lapr4.jobs4u.applicationmanagement.domain.Application;
import lapr4.jobs4u.interviewmanagement.domain.Interview;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;

/**
 * @author 2DI2
 */
public interface InterviewRepository extends DomainRepository<Long, Interview> {

    Optional<Interview> findInterviewByApplication(final Application application);
    Iterable<Interview> findInterviewsByJobOpening(final JobOpening jobOpening);
}
