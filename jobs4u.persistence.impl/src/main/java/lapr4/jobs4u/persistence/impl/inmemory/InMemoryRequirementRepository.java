package lapr4.jobs4u.persistence.impl.inmemory;

import java.util.Optional;

import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;
import lapr4.jobs4u.applicationmanagement.domain.Application;
import lapr4.jobs4u.requirementmanagement.domain.Requirement;
import lapr4.jobs4u.requirementmanagement.repositories.RequirementRepository;

/**
 *
 * @author Jorge Santos ajs@isep.ipp.pt 02/04/2016
 */
public class InMemoryRequirementRepository extends InMemoryDomainRepository<Requirement, Long>
        implements RequirementRepository {

    static {
        InMemoryInitializer.init();
    }

    @Override
    public Optional<Requirement> findRequirement(Application application) {
        return findRequirement(application);
    }

}