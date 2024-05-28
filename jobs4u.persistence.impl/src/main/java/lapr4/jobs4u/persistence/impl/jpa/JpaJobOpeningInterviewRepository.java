package lapr4.jobs4u.persistence.impl.jpa;

import lapr4.jobs4u.Application;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpeningInterview;
import lapr4.jobs4u.jobopeningmanagement.repositories.JobOpeningInterviewRepository;

import java.util.List;
import java.util.Optional;

import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

/**
 * @author 2DI2
 */
class JpaJobOpeningInterviewRepository extends JpaAutoTxRepository<JobOpeningInterview, Long, Long>
        implements JobOpeningInterviewRepository {

    public JpaJobOpeningInterviewRepository(final TransactionalContext autoTx) {
        super(autoTx, "pk");
    }

    public JpaJobOpeningInterviewRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(),
                "pk");
    }

    @Override
    public Optional<JobOpeningInterview> findJobOpeningInterviewsByJobOpening(JobOpening jobOpening) {
        List<JobOpeningInterview> results = createQuery("SELECT ji FROM JobOpeningInterview ji WHERE ji.jobOpening = :jobOpening", JobOpeningInterview.class)
                .setParameter("jobOpening", jobOpening)
                .getResultList();
        return results.isEmpty() ? Optional.empty() : Optional.of(results.get(0));
    }
}
