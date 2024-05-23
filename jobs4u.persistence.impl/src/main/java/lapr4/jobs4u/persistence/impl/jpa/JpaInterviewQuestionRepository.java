package lapr4.jobs4u.persistence.impl.jpa;

import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;
import lapr4.jobs4u.Application;
import lapr4.jobs4u.questionmanagement.domain.InterviewQuestion;
import lapr4.jobs4u.questionmanagement.repositories.InterviewQuestionRepository;

class JpaInterviewQuestionRepository extends JpaAutoTxRepository<InterviewQuestion, Long, Long> implements InterviewQuestionRepository {

    public JpaInterviewQuestionRepository(final TransactionalContext autoTx) {
        super(autoTx, "question");
    }

    public JpaInterviewQuestionRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(),
                "question");
    }

    @Override
    public Iterable<InterviewQuestion> findAll() {
        return match("e.active=true");
    }

    @Override
    public Iterable<InterviewQuestion> findQuestionsByPlugin(final String plugin) {
        return match("e.importerPlugin=:plugin", "plugin", plugin);
    }
}
