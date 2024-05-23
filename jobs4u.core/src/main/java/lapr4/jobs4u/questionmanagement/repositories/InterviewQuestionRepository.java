package lapr4.jobs4u.questionmanagement.repositories;

import eapli.framework.domain.repositories.DomainRepository;
import lapr4.jobs4u.questionmanagement.domain.InterviewQuestion;

public interface InterviewQuestionRepository extends DomainRepository<Long, InterviewQuestion>{

	Iterable<InterviewQuestion> findAll();
	Iterable<InterviewQuestion> findQuestionsByPlugin(final String plugin);
}