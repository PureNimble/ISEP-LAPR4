package lapr4.jobs4u.persistence.impl.jpa;

import lapr4.jobs4u.applicationmanagement.domain.Application;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
import lapr4.jobs4u.requirementmanagement.domain.Requirement;
import lapr4.jobs4u.requirementmanagement.repositories.RequirementRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

/**
 * @author 2DI2
 */
class JpaRequirementRepository extends JpaAutoTxRepository<Requirement, Long, Long> implements RequirementRepository {

    public JpaRequirementRepository(final TransactionalContext autoTx) {
        super(autoTx, "ID");
    }

    public JpaRequirementRepository(final String puname) {
        super(puname, lapr4.jobs4u.Application.settings().getExtendedPersistenceProperties(), "ID");
    }

    @Override
    public Optional<Requirement> findRequirement(final Application application) {
        final Map<String, Object> params = new HashMap<>();
        params.put("application", application);
        return matchOne("e.application=:application", params);
    }

    @Override
    public Iterable<Requirement> findRequirementsByJobOpening(final JobOpening jobOpening) {
        final Map<String, Object> params = new HashMap<>();
        params.put("jobOpening", jobOpening);
        return match("e.application.jobOpening=:jobOpening", params);
    }

}
