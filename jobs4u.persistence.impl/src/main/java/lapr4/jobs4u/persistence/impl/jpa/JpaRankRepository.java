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
    public Optional<String> findHighestSequence() {
        final long count = createQuery("SELECT COUNT(r) FROM Rank r",
                Long.class).getSingleResult() + 1;
        return Optional.of(Long.toString(count));
    }

    @Override
    public Boolean hasRank(final JobOpening jobOpening) {
        final Map<String, Object> params = new HashMap<>();
        params.put("jobOpening", jobOpening);
        return matchOne("e.application.jobOpening=:jobOpening", params).isPresent();
    }

    @Override
    public Iterable<Rank> findByJobOpening(final JobOpening jobOpening) {
        return createQuery(
                "SELECT e FROM Rank e WHERE e.application.jobOpening = :jobOpening ORDER BY e.rankPlacement ASC",
                Rank.class).setParameter("jobOpening", jobOpening)
                .getResultList();
    }
}
