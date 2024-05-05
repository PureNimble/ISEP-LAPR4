package lapr4.jobs4u.persistence.impl.jpa;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.domain.model.Username;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;
import jakarta.persistence.Query;
import jakarta.persistence.TemporalType;
import lapr4.jobs4u.Application;
import lapr4.jobs4u.customermanagement.domain.Customer;
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
    public Iterable<JobOpening> filterByCostumer(final Customer customer) {
        final Map<String, Object> params = new HashMap<>();
        params.put("customer", customer);
        return match("e.customer=:customer", params);
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
    public Iterable<JobOpening> filterByActive(final boolean active) {
        final Map<String, Object> params = new HashMap<>();
        params.put("active", active);
        return match("e.active=:active", params);
    }

    @SuppressWarnings("unchecked")
    @Override
    public Iterable<JobOpening> filterByPeriod(final Calendar initialDate, final Calendar finalDate) {
        Query query = createQuery(
            "SELECT e FROM JobOpening e WHERE e.registeredOn BETWEEN :startDate AND :endDate",
            JobOpening.class);
        query.setParameter("startDate", initialDate, TemporalType.TIMESTAMP);
        query.setParameter("endDate", finalDate, TemporalType.TIMESTAMP);
        return query.getResultList();
    }

    public Optional<JobOpening> findJobOpeningByReference(final JobReference jobReference) {
        final Map<String, Object> params = new HashMap<>();
        params.put("jobReference", jobReference);
        return matchOne("e.jobReference=:jobReference", params);
    }

}
