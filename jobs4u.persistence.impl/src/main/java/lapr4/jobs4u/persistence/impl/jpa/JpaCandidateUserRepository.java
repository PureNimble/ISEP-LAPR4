package lapr4.jobs4u.persistence.impl.jpa;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;
import lapr4.jobs4u.Application;
import lapr4.jobs4u.candidatemanagement.domain.Candidate;
import lapr4.jobs4u.candidatemanagement.domain.CandidateUser;
import lapr4.jobs4u.candidatemanagement.repositories.CandidateUserRepository;

/**
 * @author 2DI2
 */
class JpaCandidateUserRepository extends JpaAutoTxRepository<CandidateUser, Long, Long>
        implements CandidateUserRepository {

    public JpaCandidateUserRepository(final TransactionalContext autoTx) {
        super(autoTx, "pk");
    }

    public JpaCandidateUserRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(),
                "pk");
    }

    @Override
    public Optional<CandidateUser> findByCandidate(final Candidate candidate) {
        final Map<String, Object> params = new HashMap<>();
        params.put("candidate", candidate);
        return matchOne("e.Candidate=:candidate", params);
    }

    @Override
    public Optional<CandidateUser> findBySystemUser(final SystemUser user) {
        final Map<String, Object> params = new HashMap<>();
        params.put("user", user);
        return matchOne("e.SystemUser=:user", params);
    }

}