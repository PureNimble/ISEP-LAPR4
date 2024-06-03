package lapr4.jobs4u.persistence.impl.inmemory;

import java.util.Optional;

import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
import lapr4.jobs4u.recruitmentprocessmanagement.domain.RecruitmentProcess;
import lapr4.jobs4u.recruitmentprocessmanagement.repositories.RecruitmentProcessRepository;

/**
 * @author 2DI2
 */
public class InMemoryRecruitmentProcessRepository extends InMemoryDomainRepository<RecruitmentProcess, Long>
        implements RecruitmentProcessRepository {
    static {
        InMemoryInitializer.init();
    }

    @Override
    public Optional<String> currentPhase(final JobOpening jobOpening) {
        return currentPhase(jobOpening);
    }

    @Override
    public Optional<RecruitmentProcess> findByJobOpening(final JobOpening theJobOpening) {
        return matchOne(e -> e.jobOpening().equals(theJobOpening));
    }
}
