package lapr4.jobs4u.persistence.impl.inmemory;

import java.util.Optional;

import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;
import lapr4.jobs4u.candidatemanagement.domain.Candidate;
import lapr4.jobs4u.candidatemanagement.repositories.CandidateRepository;

public class InMemoryCandidateRepository
        extends InMemoryDomainRepository<Candidate, EmailAddress>
        implements CandidateRepository {

    static {
        InMemoryInitializer.init();
    }

    @Override
    public Optional<Candidate> findByEmail(final EmailAddress email) {
        return Optional.of(data().get(email));
    }

    @Override
    public Iterable<Candidate> sortedAsc() {
        return sortedAsc();
    }
}
