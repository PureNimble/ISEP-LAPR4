package lapr4.jobs4u.integration.questions.importer.application;

import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import lapr4.jobs4u.integration.questions.importer.domain.QuestionImporterPlugin;
import lapr4.jobs4u.integration.questions.importer.domain.QuestionImporterPluginBuilder;
import lapr4.jobs4u.integration.questions.importer.repositories.QuestionImporterPluginRepository;
import lapr4.jobs4u.usermanagement.domain.BaseRoles;

/**
 * @author 2DI2
 */
@UseCaseController
public class RegisterQuestionImporterPluginController {
	private final AuthorizationService authorizationService;
	private final QuestionImporterPluginRepository repository;

	public RegisterQuestionImporterPluginController(final QuestionImporterPluginRepository repository, final AuthorizationService authorizationService) {
		this.repository = repository;
		this.authorizationService = authorizationService;
	}

	/**
	 * Registers a plugin.
	 *
	 * @param name
	 * @param description
	 *
	 * @return
	 */
	public QuestionImporterPlugin registerQuestionImporterPlugin(final String name, final String description,
			final String fileExtension, final String fqClassName, final String pluginType) {
		authorizationService.ensureAuthenticatedUserHasAnyOf(BaseRoles.LANGUAGE_ENGINEER, BaseRoles.POWERUSER);

		final QuestionImporterPlugin plugin = new QuestionImporterPluginBuilder().with(name, description, fileExtension, fqClassName, pluginType).build();
		return repository.save(plugin);
	}
}