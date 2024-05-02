package lapr4.jobs4u.persistence.impl.inmemory;

import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;
import lapr4.jobs4u.questionmanagement.domain.Question;
import lapr4.jobs4u.questionmanagement.repositories.QuestionRepository;

public class InMemoryQuestionRepository
        extends InMemoryDomainRepository<Question, Long>
        implements QuestionRepository {

    static {
        InMemoryInitializer.init();
    }

    @Override
    public Iterable<Question> findAll() {
        return match(e -> true);
    }

    @Override
    public Iterable<Question> findActiveQuestions() {
        return match(e -> e.isActive());
    }
}