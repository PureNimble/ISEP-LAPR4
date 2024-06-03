package lapr4.jobs4u.rankmanagement.application;

import lapr4.jobs4u.rankmanagement.repositories.RankRepository;

public class RegisterRankService {
    private final RankRepository repository;

    public RegisterRankService(RankRepository repository) {
        this.repository = repository;
    }

    public String nextRankReference(){
        return repository.findHighestSequence();
    }
}
