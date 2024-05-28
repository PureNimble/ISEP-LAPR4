package lapr4.jobs4u.persistence.impl.jpa;

import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;
import lapr4.jobs4u.Application;
import lapr4.jobs4u.questionmanagement.domain.QuestionType;
import lapr4.jobs4u.questionmanagement.repositories.QuestionTypeRepository;

/**
 * @author 2DI2
 */
class JpaQuestionTypeRepository extends JpaAutoTxRepository<QuestionType, String, String>
        implements QuestionTypeRepository {

    public JpaQuestionTypeRepository(final TransactionalContext autoTx) {
        super(autoTx, "type");
    }

    public JpaQuestionTypeRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(),
                "type");
    }

    @Override
    public Iterable<QuestionType> activeQuestionTypes() {
        return match("e.active=true");
    }
}