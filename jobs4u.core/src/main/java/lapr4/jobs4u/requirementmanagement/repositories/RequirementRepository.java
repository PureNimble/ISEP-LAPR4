package lapr4.jobs4u.requirementmanagement.repositories;

import java.util.Optional;

import eapli.framework.domain.repositories.DomainRepository;
import lapr4.jobs4u.applicationmanagement.domain.Application;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
import lapr4.jobs4u.requirementmanagement.domain.Requirement;

/**
 * @author 2DI2
 */
public interface RequirementRepository extends DomainRepository<Long, Requirement> {

    Optional<Requirement> findRequirement(final Application application);
    Iterable<Requirement> findRequirementsByJobOpening(JobOpening jobOpening);
    Iterable<Requirement> findEvaluatedRequirementsByJobOpening(JobOpening jobOpening);

}
