package lapr4.jobs4u.persistence.impl.jpa;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;
import lapr4.jobs4u.Application;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
import lapr4.jobs4u.jobopeningmanagement.domain.JobReference;
import lapr4.jobs4u.jobopeningmanagement.repositories.JobOpeningRepository;


public class JpaJobOpeningRepository extends JpaAutoTxRepository<JobOpening, JobReference, JobReference>
        implements JobOpeningRepository {
    public JpaJobOpeningRepository(final TransactionalContext autoTx) {
        super(autoTx, "jobReference");
    }

    public JpaJobOpeningRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(),
                "jobReference");
    }

    @Override
    public Optional<JobOpening> findByJobReference(final JobReference reference) {
        final Map<String, Object> params = new HashMap<>();
        params.put("Job Reference", reference);
        return matchOne("e.jobReference=:reference", params);
    }

}
