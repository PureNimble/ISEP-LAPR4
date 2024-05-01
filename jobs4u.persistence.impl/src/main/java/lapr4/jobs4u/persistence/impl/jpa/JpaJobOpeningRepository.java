package lapr4.jobs4u.persistence.impl.jpa;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.domain.model.Username;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;
import lapr4.jobs4u.Application;
import lapr4.jobs4u.candidatemanagement.domain.Candidate;
import lapr4.jobs4u.customermanagement.domain.CustomerCode;
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
    public Iterable<JobOpening> filterByCostumerManager(final Username name) {
        final Map<String, Object> params = new HashMap<>();
        params.put("name", name);
        return match("e.customer.manager.username=:name", params);
    }

    @Override
    public String findHighestSequenceForCustomer(final CustomerCode customerCode) {
        Long count = createQuery(
                "SELECT COUNT(jo) FROM JobOpening jo WHERE jo.customer.customerCode = :customerCode",
                Long.class)
                .setParameter("customerCode", customerCode)
                .getSingleResult() + 1;
        return count.toString();
    }

    @Override
    public Optional<JobOpening> findJobOpeningByReference(final JobReference jobReference) {
        final Map<String, Object> params = new HashMap<>();
        params.put("jobReference", jobReference);
        return matchOne("e.jobReference=:jobReference", params);
    }

}
