package lapr4.jobs4u.recruitmentprocessmanagement.repositories;

import java.util.Optional;

import eapli.framework.domain.repositories.DomainRepository;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
import lapr4.jobs4u.recruitmentprocessmanagement.domain.RecruitmentProcess;

/**
 * @author 2DI2
 */
public interface RecruitmentProcessRepository extends DomainRepository<Long, RecruitmentProcess> {

    Optional<String> currentPhase(final JobOpening jobOpening);
    Optional<RecruitmentProcess> findByJobOpening(final JobOpening theJobOpening);
}
