package lapr4.jobs4u.persistence.impl.jpa;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import lapr4.jobs4u.applicationmanagement.domain.Application;
import lapr4.jobs4u.applicationmanagement.domain.ApplicationCode;
import lapr4.jobs4u.applicationmanagement.repositories.ApplicationRepository;
import lapr4.jobs4u.candidatemanagement.domain.Candidate;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
import lapr4.jobs4u.jobopeningmanagement.domain.JobReference;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

/**
 * @author 2DI2
 */
class JpaApplicationRepository extends JpaAutoTxRepository<Application, ApplicationCode, ApplicationCode>
        implements ApplicationRepository {

    public JpaApplicationRepository(final TransactionalContext autoTx) {
        super(autoTx, "applicationCode");
    }

    public JpaApplicationRepository(final String puname) {
        super(puname, lapr4.jobs4u.Application.settings().getExtendedPersistenceProperties(), "applicationCode");
    }

    @Override
    public Optional<Application> findByApplicationCode(final ApplicationCode number) {
        final Map<String, Object> params = new HashMap<>();
        params.put("number", number);
        return matchOne("e.applicationCode=:number", params);
    }

    @Override
    public String findHighestSequenceForCustomer(final JobReference jobReference) {

        final Long count = createQuery(
                "SELECT COUNT(a) FROM Application a WHERE a.jobOpening.jobReference = :jobReference", Long.class)
                .setParameter("jobReference", jobReference).getSingleResult()
                + 1;
        return count.toString();

    }

    @Override
    public Iterable<Application> filterByJobOpening(final JobOpening jobOpening) {
        final Map<String, Object> params = new HashMap<>();
        params.put("jobOpening", jobOpening);
        return match("e.jobOpening=:jobOpening", params);
    }

    @Override
    public Iterable<Application> findApplicationWithInterviewRecord(final JobOpening jobOpening) {
        return createQuery(
                "SELECT a FROM Application a, Interview i WHERE a.jobOpening = :jobOpening AND i.application = a",
                Application.class).setParameter("jobOpening", jobOpening).getResultList();
    }

    @Override
    public Iterable<Application> findApplicationsFromCandidate(final Candidate candidate) {
        final Map<String, Object> params = new HashMap<>();
        params.put("candidate", candidate);
        return match("e.candidate=:candidate", params);
    }

    @Override
    public Iterable<Application> findApplicationsWithResult(final JobOpening jobOpening) {
        return createQuery(
                "SELECT a FROM Application a WHERE a.jobOpening = :jobOpening AND a.result.outcome.outComeValue NOT LIKE 'PENDING'",
                Application.class).setParameter("jobOpening", jobOpening).getResultList();
    }

    @Override
    public Long numApplicationsForJobOpening(final JobOpening jobOpening) {
        return createQuery(
                "SELECT COUNT (a) FROM Application a WHERE a.jobOpening = :jobOpening",
                Long.class).setParameter("jobOpening", jobOpening).getSingleResult();
    }

    @Override
    public Iterable<Application> findApplicationsWithRanking(JobOpening theJobOpening) {
        return createQuery(
                "SELECT a FROM Application a, Rank r WHERE a.jobOpening = :theJobOpening AND a = r.application",
                Application.class).setParameter("theJobOpening", theJobOpening).getResultList();
    }
        
}
