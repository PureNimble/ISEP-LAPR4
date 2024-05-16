package lapr4.jobs4u.recruitmentprocessmanagement.repositories;

import java.util.Optional;

import eapli.framework.domain.repositories.DomainRepository;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
import lapr4.jobs4u.recruitmentprocessmanagement.domain.RecruitmentProcess;

public interface RecruitmentProcessRepository extends DomainRepository<Long, RecruitmentProcess> {

    Optional<String> currentPhase(JobOpening jobOpening);
    Optional<RecruitmentProcess> findByJobOpening(JobOpening theJobOpening);
}
