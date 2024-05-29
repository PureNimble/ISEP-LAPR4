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
import lapr4.jobs4u.recruitmentprocessmanagement.domain.ActivityState;
import lapr4.jobs4u.recruitmentprocessmanagement.domain.State;

/**
 * @author 2DI2
 */
public class JpaJobOpeningRepository extends JpaAutoTxRepository<JobOpening, JobReference, JobReference>
        implements JobOpeningRepository {

    public JpaJobOpeningRepository(final TransactionalContext autoTx) {
        super(autoTx, "jobReference");
    }

    public JpaJobOpeningRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "jobReference");
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
        Long count = createQuery("SELECT COUNT(jo) FROM JobOpening jo WHERE jo.customer.customerCode = :customerCode",
                Long.class).setParameter("customerCode", customerCode).getSingleResult() + 1;
        return count.toString();
    }

    @SuppressWarnings("unchecked")
    @Override
    public Iterable<JobOpening> hasRecruitmentProcess(final boolean hasRecruitmentProcess) {
        Query query = null;
        if (hasRecruitmentProcess) {
            query = createQuery(
                    "SELECT e FROM JobOpening e, RecruitmentProcess RP WHERE e.jobReference = RP.jobOpening.jobReference",
                    JobOpening.class);
        } else {
            query = createQuery(
                    "SELECT e FROM JobOpening e LEFT JOIN RecruitmentProcess RP ON e.jobReference = RP.jobOpening.jobReference WHERE RP.jobOpening.jobReference IS NULL",
                    JobOpening.class);
        }
        return query.getResultList();
    }

    @SuppressWarnings("unchecked")
    @Override
    public Iterable<JobOpening> filterByPeriod(final Calendar initialDate, final Calendar finalDate) {
        Query query = createQuery("SELECT e FROM JobOpening e WHERE e.registeredOn BETWEEN :startDate AND :endDate",
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

    @SuppressWarnings("unchecked")
    @Override
    public Iterable<JobOpening> filterWithInterview() {
        Query query = createQuery(
                "SELECT e FROM JobOpening e, RecruitmentProcess RP WHERE e.jobReference = RP.jobOpening.jobReference AND RP.interviewPhase IS NOT NULL",
                JobOpening.class);
        return query.getResultList();
    }

    @SuppressWarnings("unchecked")
    @Override
    public Iterable<JobOpening> filterWithAvailablePhaseForInterviews(final Username username) {
        Query query = createQuery(
                "SELECT e FROM JobOpening e, RecruitmentProcess r WHERE e.customer.manager.username = :name AND e = r.jobOpening "
                        + "AND (r.screeningPhase.state = :openPhase OR r.interviewPhase.state = :openPhase)",
                JobOpening.class);
        query.setParameter("name", username);
        query.setParameter("openPhase", State.valueOf(ActivityState.OPEN.toString()));
        return query.getResultList();
    }

    @SuppressWarnings("unchecked")
    @Override
    public Iterable<JobOpening> filterWithAvailablePhaseForRequirements(final Username username) {
        Query query = createQuery(
                "SELECT e FROM JobOpening e, RecruitmentProcess r WHERE e.customer.manager.username = :name AND e = r.jobOpening "
                        + "AND (r.screeningPhase.state = :openPhase OR r.applicationPhase.state = :openPhase)",
                JobOpening.class);
        query.setParameter("name", username);
        query.setParameter("openPhase", State.valueOf(ActivityState.OPEN.toString()));
        return query.getResultList();
    }

    @SuppressWarnings("unchecked")
    @Override
    public Iterable<JobOpening> filterWithAvailablePhaseForInterviewEvaluation(final Username username) {
        Query query = createQuery(
                "SELECT DISTINCT e FROM JobOpening e, RecruitmentProcess r, Application a, Interview i WHERE e.customer.manager.username = :name "
                        + "AND e = r.jobOpening AND (r.analysisPhase.state = :openPhase) AND a.jobOpening = e AND i.application = a",
                JobOpening.class);
        query.setParameter("name", username);
        query.setParameter("openPhase", State.valueOf(ActivityState.OPEN.toString()));
        return query.getResultList();
    }

    @SuppressWarnings("unchecked")
    @Override
    public Iterable<JobOpening> filterWithAvailablePhaseForRequirementEvaluation(final Username username) {
        Query query = createQuery(
                "SELECT DISTINCT e FROM JobOpening e, RecruitmentProcess rp, Application a, Requirement r WHERE e.customer.manager.username = :name "
                        + "AND e = rp.jobOpening AND (rp.analysisPhase.state = :openPhase) AND a.jobOpening = e AND r.application = a",
                JobOpening.class);
        query.setParameter("name", username);
        query.setParameter("openPhase", State.valueOf(ActivityState.OPEN.toString()));
        return query.getResultList();
    }

}
