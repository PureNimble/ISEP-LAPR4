package lapr4.jobs4u.questionmanagement.repositories;

import eapli.framework.domain.repositories.DomainRepository;
import lapr4.jobs4u.questionmanagement.domain.Question;


public interface QuestionRepository extends DomainRepository<Long, Question>{

	Iterable<Question> findAll();
	Iterable<Question> findActiveQuestions();
}