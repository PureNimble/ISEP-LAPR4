package lapr4.jobs4u.persistence.impl.inmemory;

import java.util.Optional;

import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;
import lapr4.jobs4u.applicationmanagement.domain.Application;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
import lapr4.jobs4u.requirementmanagement.domain.Requirement;
import lapr4.jobs4u.requirementmanagement.repositories.RequirementRepository;

/**
 * @author 2DI2
 */
public class InMemoryRequirementRepository extends InMemoryDomainRepository<Requirement, Long>
        implements RequirementRepository {

    static {
        InMemoryInitializer.init();
    }

    @Override
    public Optional<Requirement> findRequirement(final Application application) {
        return findRequirement(application);
    }

    @Override
    public Iterable<Requirement> findRequirementsByJobOpening(final JobOpening jobOpening) {
        return match(e -> e.application().jobOpening().equals(jobOpening));
    }

}