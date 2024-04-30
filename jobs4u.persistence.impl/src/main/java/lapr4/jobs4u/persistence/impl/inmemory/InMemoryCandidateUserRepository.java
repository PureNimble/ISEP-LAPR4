package lapr4.jobs4u.persistence.impl.inmemory;

import java.util.Optional;

import eapli.framework.infrastructure.authz.domain.model.Username;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;
import lapr4.jobs4u.candidatemanagement.domain.CandidateUser;
import lapr4.jobs4u.candidatemanagement.repositories.CandidateUserRepository;

public class InMemoryCandidateUserRepository
        extends InMemoryDomainRepository<CandidateUser, Long>
        implements CandidateUserRepository {

    static {
        InMemoryInitializer.init();
    }

    @Override
    public Optional<CandidateUser> findByEmail(final Username email) {
        return matchOne(e -> e.user().username().equals(email));
    }
}
