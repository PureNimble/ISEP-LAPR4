package lapr4.jobs4u.persistence.impl.inmemory;

import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;
import lapr4.jobs4u.questionmanagement.domain.QuestionType;
import lapr4.jobs4u.questionmanagement.repositories.QuestionTypeRepository;

public class InMemoryQuestionTypeRepository
        extends InMemoryDomainRepository<QuestionType, String>
        implements QuestionTypeRepository {

    static {
        InMemoryInitializer.init();
    }

    @Override
    public Iterable<QuestionType> activeQuestionTypes() {
        return match(e -> e.isActive());
    }
}