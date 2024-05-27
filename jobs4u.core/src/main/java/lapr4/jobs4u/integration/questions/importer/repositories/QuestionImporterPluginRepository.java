package lapr4.jobs4u.integration.questions.importer.repositories;

import java.util.Optional;

import eapli.framework.domain.repositories.DomainRepository;
import eapli.framework.general.domain.model.Designation;
import lapr4.jobs4u.integration.questions.importer.domain.FileExtension;
import lapr4.jobs4u.integration.questions.importer.domain.PluginType;
import lapr4.jobs4u.integration.questions.importer.domain.QuestionImporterPlugin;

/**
 * @author 2DI2
 */
public interface QuestionImporterPluginRepository extends DomainRepository<Designation, QuestionImporterPlugin> {

	Optional<QuestionImporterPlugin> findByFileExtension(final FileExtension fileExt);
	Optional<QuestionImporterPlugin> findByName(final Designation name);
	Iterable<QuestionImporterPlugin> findByPluginType(final PluginType pluginType);
}