package lapr4.jobs4u.questionmanagement.repositories;

import eapli.framework.domain.repositories.DomainRepository;
import lapr4.jobs4u.questionmanagement.domain.RequirementsQuestion;

public interface RequirementsQuestionRepository extends DomainRepository<Long, RequirementsQuestion>{

	Iterable<RequirementsQuestion> findAll();
	Iterable<RequirementsQuestion> findQuestionsByPlugin(final String plugin);
}
