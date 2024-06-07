package lapr4.jobs4u.rankmanagement.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
import lapr4.jobs4u.rankmanagement.domain.Rank;
import lapr4.jobs4u.rankmanagement.dto.RankDTO;
import lapr4.jobs4u.rankmanagement.repositories.RankRepository;

/**
 * @author 2DI2
 */
public class RegisterRankService {
    private final RankRepository rankRepository;

    public RegisterRankService(RankRepository rankRepository) {
        this.rankRepository = rankRepository;
    }

    public Boolean hasRank(final JobOpening jobOpening) {
        return rankRepository.hasRank(jobOpening);
    }

    public Iterable<RankDTO> findByJobOpening(final JobOpening jobOpening) {
        List<RankDTO> RankDTOs = new ArrayList<>();
        final Iterable<Rank> ranks = rankRepository.findByJobOpening(jobOpening);
        ranks.forEach(rank -> RankDTOs.add(rank.toDTO()));
        return RankDTOs;
    }

    public Rank selectedRank(final RankDTO rankDTO) {
        Rank selectedRank = rankRepository.ofIdentity(Long.valueOf(rankDTO.getId()))
                .orElseThrow(IllegalArgumentException::new);
        return selectedRank;
    }

    public Optional<Long> lastPlacement() {
        return rankRepository.findHighestSequence();
    }
}
