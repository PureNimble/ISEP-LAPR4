package lapr4.jobs4u.jobopeningmanagement.repositories;

import eapli.framework.domain.repositories.DomainRepository;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpeningInterview;

public interface JobOpeningInterviewRepository extends DomainRepository<Long, JobOpeningInterview> {
    Iterable<JobOpeningInterview> findAll();

}
