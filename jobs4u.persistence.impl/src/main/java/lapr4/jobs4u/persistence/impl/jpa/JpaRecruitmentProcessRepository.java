package lapr4.jobs4u.persistence.impl.jpa;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;
import jakarta.persistence.TypedQuery;
import lapr4.jobs4u.Application;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
import lapr4.jobs4u.recruitmentprocessmanagement.domain.ActivityState;
import lapr4.jobs4u.recruitmentprocessmanagement.domain.RecruitmentProcess;
import lapr4.jobs4u.recruitmentprocessmanagement.domain.State;
import lapr4.jobs4u.recruitmentprocessmanagement.repositories.RecruitmentProcessRepository;

/**
 * @author 2DI2
 */
class JpaRecruitmentProcessRepository extends JpaAutoTxRepository<RecruitmentProcess, Long, Long>
        implements RecruitmentProcessRepository {
    public JpaRecruitmentProcessRepository(final TransactionalContext autoTx) {
        super(autoTx, "pk");
    }

    public JpaRecruitmentProcessRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(),
                "pk");
    }

    @Override
    public Optional<String> currentPhase(final JobOpening jobOpening) {
        TypedQuery<String> phase = createQuery("SELECT 'AnalysisPhase' AS phase "
                + "FROM AnalysisPhase a "
                + "JOIN RecruitmentProcess r ON a.pk = r.analysisPhase.pk "
                + "WHERE r.jobOpening.jobReference = :jobReference "
                + "AND a.state = :openState "
                + "UNION ALL "
                + "SELECT 'ApplicationPhase' AS phase "
                + "FROM ApplicationPhase ap "
                + "JOIN RecruitmentProcess r ON ap.pk = r.applicationPhase.pk "
                + "WHERE r.jobOpening.jobReference = :jobReference "
                + "AND ap.state = :openState "
                + "UNION ALL "
                + "SELECT 'InterviewPhase' AS phase "
                + "FROM InterviewPhase ip "
                + "JOIN RecruitmentProcess r ON ip.pk = r.interviewPhase.pk "
                + "WHERE r.jobOpening.jobReference = :jobReference "
                + "AND ip.state = :openState "
                + "UNION ALL "
                + "SELECT 'ResultPhase' AS phase "
                + "FROM ResultPhase rp "
                + "JOIN RecruitmentProcess r ON rp.pk = r.resultPhase.pk "
                + "WHERE r.jobOpening.jobReference = :jobReference "
                + "AND rp.state = :openState "
                + "UNION ALL "
                + "SELECT 'ScreeningPhase' AS phase "
                + "FROM ScreeningPhase sp "
                + "JOIN RecruitmentProcess r ON sp.pk = r.screeningPhase.pk "
                + "WHERE r.jobOpening.jobReference = :jobReference "
                + "AND sp.state = :openState", String.class)
                .setParameter("jobReference", jobOpening.jobReference())
                .setParameter("openState", State.valueOf(ActivityState.OPEN.toString()));
        List<String> results = phase.getResultList();
        return results.isEmpty() ? Optional.empty() : Optional.ofNullable(results.get(0));
    }

    @Override
    public Optional<RecruitmentProcess> findByJobOpening(final JobOpening theJobOpening) {
        final Map<String, Object> params = new HashMap<>();
        params.put("jobOpening", theJobOpening);
        return matchOne("e.jobOpening=:jobOpening", params);
    }
}
