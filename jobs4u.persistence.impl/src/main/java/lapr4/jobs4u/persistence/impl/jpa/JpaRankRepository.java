package lapr4.jobs4u.persistence.impl.jpa;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;
import lapr4.jobs4u.Application;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
import lapr4.jobs4u.rankmanagement.domain.Rank;
import lapr4.jobs4u.rankmanagement.repositories.RankRepository;

/**
 * @author 2DI2
 */
public class JpaRankRepository extends JpaAutoTxRepository<Rank, Long, Long>
        implements RankRepository {
    public JpaRankRepository(final TransactionalContext autoTx) {
        super(autoTx, "pk");
    }

    public JpaRankRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "pk");
    }

    @Override
    public Optional<Long> findHighestSequence() {
        final Long count = createQuery("SELECT COUNT(r) FROM Rank r",
                Long.class).getSingleResult() + 1;
        return Optional.of(count);
    }

    @Override
    public Boolean hasRank(final JobOpening jobOpening) {
        final Map<String, Object> params = new HashMap<>();
        params.put("jobOpening", jobOpening);
        return !match("e.application.jobOpening=:jobOpening", params).isEmpty();
    }

    @Override
    public Iterable<Rank> findByJobOpening(final JobOpening jobOpening) {
        return createQuery(
                "SELECT e FROM Rank e WHERE e.application.jobOpening = :jobOpening ORDER BY e.rankPlacement ASC",
                Rank.class).setParameter("jobOpening", jobOpening)
                .getResultList();
    }

    @Override
    public Iterable<Rank> findTopNApplicationsByJobOpening(final JobOpening jobOpening) {
        return createQuery(
                "SELECT e FROM Rank e, Application a WHERE e.application = a AND a.jobOpening = :jobOpening " +
                        "ORDER BY e.rankPlacement ASC",
                Rank.class)
                .setParameter("jobOpening", jobOpening)
                .setMaxResults(Integer.valueOf(jobOpening.numberOfVacancies().toString()))
                .getResultList();
    }
}
