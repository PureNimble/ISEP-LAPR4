package lapr4.jobs4u.questionmanagement.repositories;

import eapli.framework.domain.repositories.DomainRepository;
import lapr4.jobs4u.integration.questions.importer.domain.QuestionImporterPlugin;
import lapr4.jobs4u.questionmanagement.domain.RequirementsQuestion;

/**
 * @author 2DI2
 */
public interface RequirementsQuestionRepository extends DomainRepository<Long, RequirementsQuestion>{

	Iterable<RequirementsQuestion> findAll();
	Iterable<RequirementsQuestion> findQuestionsByPlugin(final QuestionImporterPlugin plugin);
}
