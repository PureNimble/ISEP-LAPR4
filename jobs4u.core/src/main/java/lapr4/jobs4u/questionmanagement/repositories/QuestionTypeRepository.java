package lapr4.jobs4u.questionmanagement.repositories;

import eapli.framework.domain.repositories.DomainRepository;
import lapr4.jobs4u.questionmanagement.domain.QuestionType;


public interface QuestionTypeRepository extends DomainRepository<String, QuestionType>{

	Iterable<QuestionType> activeQuestionTypes();
}