package lapr4.jobs4u.candidatemanagement.repositories;

import java.util.Optional;

import eapli.framework.domain.repositories.DomainRepository;
import eapli.framework.general.domain.model.EmailAddress;
import lapr4.jobs4u.candidatemanagement.domain.Candidate;

public interface CandidateRepository extends DomainRepository<EmailAddress, Candidate> {
    Optional<Candidate> findByEmail(final EmailAddress identity);
}
