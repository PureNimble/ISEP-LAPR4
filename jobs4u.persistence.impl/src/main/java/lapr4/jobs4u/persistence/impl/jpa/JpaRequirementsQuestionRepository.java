package lapr4.jobs4u.persistence.impl.jpa;

import lapr4.jobs4u.questionmanagement.domain.QuestionBody;
import lapr4.jobs4u.questionmanagement.domain.RequirementsQuestion;

import java.util.Optional;

import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;
import lapr4.jobs4u.Application;
import lapr4.jobs4u.integration.questions.importer.domain.QuestionImporterPlugin;
import lapr4.jobs4u.questionmanagement.repositories.RequirementsQuestionRepository;

/**
 * @author 2DI2
 */
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
    public Iterable<RequirementsQuestion> findQuestionsByPlugin(final QuestionImporterPlugin plugin) {
        return match("e.importerPlugin=:plugin", "plugin", plugin);
    }

    @Override
    public Optional<RequirementsQuestion> findQuestionByBody(QuestionBody questionBody) {
        RequirementsQuestion question = createQuery("SELECT e FROM RequirementsQuestion e WHERE e.body=:questionBody", RequirementsQuestion.class)
                .setParameter("questionBody", questionBody)
                .getSingleResult();
        return Optional.ofNullable(question);
    }
}