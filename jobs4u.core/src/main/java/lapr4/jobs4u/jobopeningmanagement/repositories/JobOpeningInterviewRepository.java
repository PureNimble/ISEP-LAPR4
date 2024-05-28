package lapr4.jobs4u.jobopeningmanagement.repositories;

import java.util.Optional;

import eapli.framework.domain.repositories.DomainRepository;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpeningInterview;

/**
 * @author 2DI2
 */
public interface JobOpeningInterviewRepository extends DomainRepository<Long, JobOpeningInterview> {
    Iterable<JobOpeningInterview> findAll();
    Optional<JobOpeningInterview> findJobOpeningInterviewsByJobOpening(final JobOpening jobOpening);
}
