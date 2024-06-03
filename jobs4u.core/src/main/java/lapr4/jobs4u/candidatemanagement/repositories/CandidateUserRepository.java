package lapr4.jobs4u.candidatemanagement.repositories;

import java.util.Optional;

import eapli.framework.domain.repositories.DomainRepository;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import lapr4.jobs4u.candidatemanagement.domain.Candidate;
import lapr4.jobs4u.candidatemanagement.domain.CandidateUser;

/**
 * @author 2DI2
 */
public interface CandidateUserRepository extends DomainRepository<Long, CandidateUser> {
    Optional<CandidateUser> findBySystemUser(final SystemUser user);
    Optional<CandidateUser> findByCandidate(final Candidate candidate);
}
