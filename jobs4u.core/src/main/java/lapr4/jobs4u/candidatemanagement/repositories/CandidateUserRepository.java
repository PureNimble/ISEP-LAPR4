package lapr4.jobs4u.candidatemanagement.repositories;

import java.util.Optional;

import eapli.framework.domain.repositories.DomainRepository;
import eapli.framework.infrastructure.authz.domain.model.Username;
import lapr4.jobs4u.candidatemanagement.domain.CandidateUser;

public interface CandidateUserRepository extends DomainRepository<Long, CandidateUser> {
    Optional<CandidateUser> findByEmail(final Username identity);
}
