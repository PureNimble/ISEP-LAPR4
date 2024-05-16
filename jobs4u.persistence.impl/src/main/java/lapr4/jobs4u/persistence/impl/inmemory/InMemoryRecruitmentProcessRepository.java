package lapr4.jobs4u.persistence.impl.inmemory;

import java.util.Optional;

import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
import lapr4.jobs4u.recruitmentprocessmanagement.domain.RecruitmentProcess;
import lapr4.jobs4u.recruitmentprocessmanagement.repositories.RecruitmentProcessRepository;

public class InMemoryRecruitmentProcessRepository extends InMemoryDomainRepository<RecruitmentProcess, Long>
        implements RecruitmentProcessRepository {
    static {
        InMemoryInitializer.init();
    }

    @Override
    public Optional<String> currentPhase(JobOpening jobOpening) {
        return currentPhase(jobOpening);
    }

    @Override
    public Optional<RecruitmentProcess> findByJobOpening(JobOpening theJobOpening) {
        return matchOne(e -> e.jobOpening().equals(theJobOpening));
    }
}
