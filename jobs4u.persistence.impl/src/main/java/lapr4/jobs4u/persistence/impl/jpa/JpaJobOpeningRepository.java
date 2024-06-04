package lapr4.jobs4u.persistence.impl.jpa;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.domain.model.Username;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;
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
                Long count = createQuery(
                                "SELECT COUNT(jo) FROM JobOpening jo WHERE jo.customer.customerCode = :customerCode",
                                Long.class).setParameter("customerCode", customerCode).getSingleResult() + 1;
                return count.toString();
        }

        @Override
        public Iterable<JobOpening> hasRecruitmentProcess(final boolean hasRecruitmentProcess) {
                if (hasRecruitmentProcess) {
                        return createQuery(
                                        "SELECT e FROM JobOpening e, RecruitmentProcess RP WHERE e.jobReference = RP.jobOpening.jobReference",
                                        JobOpening.class).getResultList();
                }
                return createQuery(
                                "SELECT e FROM JobOpening e LEFT JOIN RecruitmentProcess RP ON e.jobReference = RP.jobOpening.jobReference WHERE RP.jobOpening.jobReference IS NULL",
                                JobOpening.class).getResultList();
        }

        @Override
        public Iterable<JobOpening> filterByPeriod(final Calendar initialDate, final Calendar finalDate) {
                return createQuery("SELECT e FROM JobOpening e WHERE e.registeredOn BETWEEN :startDate AND :endDate",
                                JobOpening.class).setParameter("startDate", initialDate, TemporalType.TIMESTAMP)
                                .setParameter("endDate", finalDate, TemporalType.TIMESTAMP).getResultList();
        }

        public Optional<JobOpening> findJobOpeningByReference(final JobReference jobReference) {
                final Map<String, Object> params = new HashMap<>();
                params.put("jobReference", jobReference);
                return matchOne("e.jobReference=:jobReference", params);
        }

        @Override
        public Iterable<JobOpening> filterWithInterview() {
                return createQuery(
                                "SELECT e FROM JobOpening e, RecruitmentProcess RP WHERE e.jobReference = RP.jobOpening.jobReference AND RP.interviewPhase IS NOT NULL",
                                JobOpening.class).getResultList();
        }

        @Override
        public Iterable<JobOpening> filterWithAvailablePhaseForInterviews(final Username username) {
                return createQuery(
                                "SELECT e FROM JobOpening e, RecruitmentProcess r WHERE e.customer.manager.username = :name AND e = r.jobOpening "
                                                + "AND (r.screeningPhase.state = :openPhase OR r.interviewPhase.state = :openPhase)",
                                JobOpening.class).setParameter("name", username)
                                .setParameter("openPhase", State.valueOf(ActivityState.OPEN.toString()))
                                .getResultList();
        }

        @Override
        public Iterable<JobOpening> filterWithAvailablePhaseForRequirements(final Username username) {
                return createQuery(
                                "SELECT e FROM JobOpening e, RecruitmentProcess r WHERE e.customer.manager.username = :name AND e = r.jobOpening "
                                                + "AND (r.screeningPhase.state = :openPhase OR r.applicationPhase.state = :openPhase)",
                                JobOpening.class).setParameter("name", username)
                                .setParameter("openPhase", State.valueOf(ActivityState.OPEN.toString()))
                                .getResultList();
        }

        @Override
        public Iterable<JobOpening> filterWithAvailablePhaseForInterviewEvaluation(final Username username) {
                return createQuery(
                                "SELECT DISTINCT e FROM JobOpening e, RecruitmentProcess r, Application a, Interview i WHERE e.customer.manager.username = :name "
                                                + "AND e = r.jobOpening AND (r.interviewPhase.state = :openPhase) AND a.jobOpening = e AND i.application = a",
                                JobOpening.class).setParameter("name", username)
                                .setParameter("openPhase", State.valueOf(ActivityState.OPEN.toString()))
                                .getResultList();
        }

        @Override
        public Iterable<JobOpening> filterWithAvailablePhaseForRequirementEvaluation(final Username username) {
                return createQuery(
                                "SELECT DISTINCT e FROM JobOpening e, RecruitmentProcess rp, Application a, Requirement r WHERE e.customer.manager.username = :name "
                                                + "AND e = rp.jobOpening AND (rp.screeningPhase.state = :openPhase OR rp.applicationPhase.state = :openPhase) AND a.jobOpening = e AND r.application = a",
                                JobOpening.class).setParameter("name", username)
                                .setParameter("openPhase", State.valueOf(ActivityState.OPEN.toString()))
                                .getResultList();
        }

        @Override
        public Iterable<JobOpening> filterWithEvaluatedInterviews(final Username username) {
                return createQuery(
                                "SELECT DISTINCT e FROM JobOpening e, Application a, Interview i WHERE e.customer.manager.username = :name "
                                                + "AND a.jobOpening = e AND i.application = a AND i.grade IS NOT NULL",
                                JobOpening.class).setParameter("name", username)
                                .getResultList();
        }

        @Override
        public Iterable<JobOpening> filterWithAvailablePhaseForRanking(final Username username) {
                return createQuery(
                                "SELECT e FROM JobOpening e, RecruitmentProcess r WHERE e.customer.manager.username = :name "
                                                + "AND e = r.jobOpening AND (r.analysisPhase.state = :openPhase)",
                                JobOpening.class).setParameter("name", username)
                                .setParameter("openPhase", State.valueOf(ActivityState.OPEN.toString()))
                                .getResultList();
        }

}
