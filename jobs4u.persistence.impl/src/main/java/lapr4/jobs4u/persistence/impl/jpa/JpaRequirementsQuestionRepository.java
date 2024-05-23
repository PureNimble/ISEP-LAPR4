package lapr4.jobs4u.persistence.impl.jpa;

import lapr4.jobs4u.questionmanagement.domain.RequirementsQuestion;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;
import lapr4.jobs4u.Application;
import lapr4.jobs4u.questionmanagement.repositories.RequirementsQuestionRepository;

public class JpaRequirementsQuestionRepository extends JpaAutoTxRepository<RequirementsQuestion, Long, Long> implements RequirementsQuestionRepository {

    public JpaRequirementsQuestionRepository(final TransactionalContext autoTx) {
        super(autoTx, "question");
    }

    public JpaRequirementsQuestionRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(),
                "question");
    }

    @Override
    public Iterable<RequirementsQuestion> findAll() {
        return match("e.active=true");
    }
    
    @Override
    public Iterable<RequirementsQuestion> findQuestionsByPlugin(final String plugin) {
        return match("e.importerPlugin=:plugin", "plugin", plugin);
    }
}