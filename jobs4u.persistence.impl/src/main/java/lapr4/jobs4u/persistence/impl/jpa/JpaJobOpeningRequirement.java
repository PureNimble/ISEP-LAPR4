package lapr4.jobs4u.persistence.impl.jpa;

import lapr4.jobs4u.Application;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpeningRequirement;
import lapr4.jobs4u.jobopeningmanagement.repositories.JobOpeningRequirementRepository;

import java.util.List;
import java.util.Optional;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

/**
 * @author 2DI2
 */
class JpaJobOpeningRequirementRepository extends JpaAutoTxRepository<JobOpeningRequirement, Long, Long>
        implements JobOpeningRequirementRepository {

    public JpaJobOpeningRequirementRepository(final TransactionalContext autoTx) {
        super(autoTx, "pk");
    }

    public JpaJobOpeningRequirementRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(),
                "pk");
    }

    @Override
    public Optional<JobOpeningRequirement> findJobOpeningRequirementsByJobOpening(JobOpening jobOpening) {
        List<JobOpeningRequirement> results = createQuery("SELECT jr FROM JobOpeningRequirement jr WHERE jr.jobOpening = :jobOpening", JobOpeningRequirement.class)
                .setParameter("jobOpening", jobOpening)
                .getResultList();
        return results.isEmpty() ? Optional.empty() : Optional.of(results.get(0));
    }
}