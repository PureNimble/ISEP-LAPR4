package lapr4.jobs4u.jobopeningmanagement.repositories;

import java.util.Optional;

import eapli.framework.domain.repositories.DomainRepository;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpeningRequirement;

/**
 * @author 2DI2
 */
public interface JobOpeningRequirementRepository extends DomainRepository<Long, JobOpeningRequirement> {
    Iterable<JobOpeningRequirement> findAll();
    Optional<JobOpeningRequirement> findJobOpeningRequirementsByJobOpening(final JobOpening jobOpening);
}
