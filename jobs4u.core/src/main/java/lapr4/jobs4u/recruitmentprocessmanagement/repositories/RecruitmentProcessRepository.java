package lapr4.jobs4u.recruitmentprocessmanagement.repositories;

import eapli.framework.domain.repositories.DomainRepository;
import lapr4.jobs4u.recruitmentprocessmanagement.domain.RecruitmentProcess;

public interface RecruitmentProcessRepository extends DomainRepository<Long, RecruitmentProcess> {
    //Iterable<RecruitmentProcess> findAllActive();
}
