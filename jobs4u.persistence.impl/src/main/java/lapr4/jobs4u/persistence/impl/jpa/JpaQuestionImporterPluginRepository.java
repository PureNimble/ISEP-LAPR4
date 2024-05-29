package lapr4.jobs4u.persistence.impl.jpa;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;
import lapr4.jobs4u.Application;
import lapr4.jobs4u.integration.questions.importer.domain.FileExtension;
import lapr4.jobs4u.integration.questions.importer.domain.PluginType;
import lapr4.jobs4u.integration.questions.importer.domain.QuestionImporterPlugin;
import lapr4.jobs4u.integration.questions.importer.repositories.QuestionImporterPluginRepository;

/**
 * @author 2DI2
 */
public class JpaQuestionImporterPluginRepository extends JpaAutoTxRepository<QuestionImporterPlugin, Long, Designation>
		implements QuestionImporterPluginRepository {

	public JpaQuestionImporterPluginRepository(final TransactionalContext autoTx) {
		super(autoTx, "name");
	}

	public JpaQuestionImporterPluginRepository(final String puname) {
		super(puname, Application.settings().getExtendedPersistenceProperties(),
				"name");
	}

	@Override
	public Optional<QuestionImporterPlugin> findByFileExtension(final FileExtension fileExt) {
		final Map<String, Object> params = new HashMap<>();
		params.put("fileExt", fileExt);
		return matchOne("e.fileExtension=:fileExt", params);
	}

	@Override
    public Iterable<QuestionImporterPlugin> findByPluginType(final PluginType pluginType) {
        final Map<String, Object> params = new HashMap<>();
		params.put("pluginType", pluginType);
		return match("e.pluginType=:pluginType", params);
    }

	@Override
	public Optional<QuestionImporterPlugin> findByName(final Designation name) {
		final Map<String, Object> params = new HashMap<>();
		params.put("name", name);
		return matchOne("e.name=:name", params);
	}
}