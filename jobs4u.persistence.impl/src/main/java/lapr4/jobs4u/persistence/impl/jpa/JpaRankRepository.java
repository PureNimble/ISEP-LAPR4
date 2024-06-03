package lapr4.jobs4u.persistence.impl.jpa;

import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;
import lapr4.jobs4u.Application;
import lapr4.jobs4u.rankmanagement.domain.Rank;
import lapr4.jobs4u.rankmanagement.domain.RankReference;
import lapr4.jobs4u.rankmanagement.repositories.RankRepository;

public class JpaRankRepository extends JpaAutoTxRepository<Rank, RankReference,RankReference> implements RankRepository {
    public JpaRankRepository(final TransactionalContext autoTx) {super(autoTx, "rankReference");}

    public JpaRankRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "rankReference");
    }

    @Override
    public String findHighestSequence() {
        long count = createQuery("SELECT COUNT(jo) FROM JobOpening jo",
                Long.class).getSingleResult() + 1;
        return Long.toString(count);
    }
}
