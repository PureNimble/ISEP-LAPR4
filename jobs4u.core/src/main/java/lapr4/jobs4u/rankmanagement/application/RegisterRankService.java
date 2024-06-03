package lapr4.jobs4u.rankmanagement.application;

import java.util.Optional;

import lapr4.jobs4u.rankmanagement.repositories.RankRepository;

/**
 * @author 2DI2
 */
public class RegisterRankService {
    private final RankRepository rankRepository;

    public RegisterRankService(RankRepository rankRepository) {
        this.rankRepository = rankRepository;
    }

    public Optional<String> nextRankReference() {
        return rankRepository.findHighestSequence();
    }
}
