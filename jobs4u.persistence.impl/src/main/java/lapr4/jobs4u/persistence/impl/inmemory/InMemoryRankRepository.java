package lapr4.jobs4u.persistence.impl.inmemory;

import java.util.Optional;

import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
import lapr4.jobs4u.rankmanagement.domain.Rank;
import lapr4.jobs4u.rankmanagement.repositories.RankRepository;

/**
 * @author 2DI2
 */
public class InMemoryRankRepository extends InMemoryDomainRepository<Rank, Long>
        implements RankRepository {

    static {
        InMemoryInitializer.init();
    }

    @Override
    public Optional<String> findHighestSequence() {
        return findHighestSequence();
    }

    @Override
    public Boolean hasRank(final JobOpening jobOpening) {
        return match(e -> e.application().jobOpening().equals(jobOpening)).iterator().hasNext();
    }

    @Override
    public Iterable<Rank> findByJobOpening(final JobOpening jobOpening) {
        return findByJobOpening(jobOpening);
    }

}