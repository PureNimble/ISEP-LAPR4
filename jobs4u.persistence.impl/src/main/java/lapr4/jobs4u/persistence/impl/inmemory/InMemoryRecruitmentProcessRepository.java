package lapr4.jobs4u.persistence.impl.inmemory;

import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;
import lapr4.jobs4u.recruitmentprocessmanagement.domain.RecruitmentProcess;
import lapr4.jobs4u.recruitmentprocessmanagement.repositories.RecruitmentProcessRepository;

public class InMemoryRecruitmentProcessRepository extends InMemoryDomainRepository<RecruitmentProcess, Long>
        implements RecruitmentProcessRepository {
    static {
        InMemoryInitializer.init();
    }

    /* @Override
    public Iterable<RecruitmentProcess> findAllActive() {
        return match(e -> e.isActive());
    } */

}
