package lapr4.jobs4u.persistence.impl.jpa;

import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;
import lapr4.jobs4u.Application;
import lapr4.jobs4u.questionmanagement.domain.Question;
import lapr4.jobs4u.questionmanagement.repositories.QuestionRepository;

class JpaQuestionRepository extends JpaAutoTxRepository<Question, Long, Long> implements QuestionRepository {

    public JpaQuestionRepository(final TransactionalContext autoTx) {
        super(autoTx, "question");
    }

    public JpaQuestionRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(),
                "question");
    }

    @Override
    public Iterable<Question> findAll() {
        return match("e.active=true");
    }

    @Override
    public Iterable<Question> findActiveQuestions() {
        return match("e.active=true");
    }
}
