package lapr4.jobs4u.persistence.impl.jpa;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import lapr4.jobs4u.Application;
import lapr4.jobs4u.candidatemanagement.domain.Candidate;
import lapr4.jobs4u.candidatemanagement.repositories.CandidateRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

class JpaCandidateRepository
        extends JpaAutoTxRepository<Candidate, EmailAddress, EmailAddress>
        implements CandidateRepository {

    public JpaCandidateRepository(final TransactionalContext autoTx) {
        super(autoTx, "emailAddress");
    }

    public JpaCandidateRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(),
                "emailAddress");
    }

    @Override
    public Optional<Candidate> findByEmail(final EmailAddress email) {
        final Map<String, Object> params = new HashMap<>();
        params.put("email", email);
        return matchOne("e.emailAddress=:email", params);
    }

    @Override
    public Iterable<Candidate> sortedAsc() {
        return createQuery("SELECT c FROM Candidate c ORDER BY c.name", Candidate.class).getResultList();
    }
}
