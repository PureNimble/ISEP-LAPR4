package lapr4.jobs4u.rankmanagement.repositories;

import java.util.Optional;

import eapli.framework.domain.repositories.DomainRepository;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
import lapr4.jobs4u.rankmanagement.domain.Rank;

/**
 * @author 2DI2
 */
public interface RankRepository extends DomainRepository<Long, Rank> {
    Optional<String> findHighestSequence();

    Iterable<Rank> findTopNApplicationsByJobOpening(final JobOpening jobOpening);

    Boolean hasRank(final JobOpening jobOpening);

    Iterable<Rank> findByJobOpening(final JobOpening jobOpening);
}
