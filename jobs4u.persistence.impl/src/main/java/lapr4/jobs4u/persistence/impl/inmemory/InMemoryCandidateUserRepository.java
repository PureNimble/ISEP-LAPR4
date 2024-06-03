package lapr4.jobs4u.persistence.impl.inmemory;

import java.util.Optional;

import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;
import lapr4.jobs4u.candidatemanagement.domain.Candidate;
import lapr4.jobs4u.candidatemanagement.domain.CandidateUser;
import lapr4.jobs4u.candidatemanagement.repositories.CandidateUserRepository;

/**
 * @author 2DI2
 */
public class InMemoryCandidateUserRepository
        extends InMemoryDomainRepository<CandidateUser, Long>
        implements CandidateUserRepository {

    static {
        InMemoryInitializer.init();
    }

    @Override
    public Optional<CandidateUser> findByCandidate(final Candidate candidate) {
        return matchOne(e -> e.candidate().equals(candidate));
    }

    @Override
    public Optional<CandidateUser> findBySystemUser(final SystemUser user) {
        return matchOne(e -> e.systemUser().equals(user));
    }
}
