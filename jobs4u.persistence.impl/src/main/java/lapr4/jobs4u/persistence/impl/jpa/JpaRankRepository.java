package lapr4.jobs4u.persistence.impl.jpa;

import java.util.Optional;

import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;
import lapr4.jobs4u.Application;
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
}
