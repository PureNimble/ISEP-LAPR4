package lapr4.jobs4u.persistence.impl.inmemory;

import java.util.Optional;

import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpeningRequirement;
import lapr4.jobs4u.jobopeningmanagement.repositories.JobOpeningRequirementRepository;

public class InMemoryJobOpeningRequirementRepository extends InMemoryDomainRepository<JobOpeningRequirement, Long>
        implements JobOpeningRequirementRepository {

    static {
        InMemoryInitializer.init();
    }

    @Override
    public Optional<JobOpeningRequirement> findJobOpeningRequirementsByJobOpening(JobOpening jobOpening) {
        return matchOne(e -> e.jobOpening().equals(jobOpening));
    }

}
