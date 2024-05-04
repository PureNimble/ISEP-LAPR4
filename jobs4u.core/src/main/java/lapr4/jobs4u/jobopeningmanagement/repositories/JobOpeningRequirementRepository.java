package lapr4.jobs4u.jobopeningmanagement.repositories;

import eapli.framework.domain.repositories.DomainRepository;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpeningRequirement;

public interface JobOpeningRequirementRepository extends DomainRepository<Long, JobOpeningRequirement> {
    Iterable<JobOpeningRequirement> findAll();

}
