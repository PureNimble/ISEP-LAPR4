package lapr4.jobs4u.rankmanagement.repositories;

import eapli.framework.domain.repositories.DomainRepository;
import lapr4.jobs4u.rankmanagement.domain.Rank;
import lapr4.jobs4u.rankmanagement.domain.RankReference;

public interface RankRepository extends DomainRepository<RankReference, Rank> {
    String findHighestSequence();
}
