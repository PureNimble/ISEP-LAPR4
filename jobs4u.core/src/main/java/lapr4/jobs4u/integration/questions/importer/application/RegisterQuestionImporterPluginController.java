/*
 * Copyright (c) 2013-2024 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package lapr4.jobs4u.integration.questions.importer.application;

import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import lapr4.jobs4u.integration.questions.importer.domain.QuestionImporterPlugin;
import lapr4.jobs4u.integration.questions.importer.domain.QuestionImporterPluginBuilder;
import lapr4.jobs4u.integration.questions.importer.repositories.QuestionImporterPluginRepository;
import lapr4.jobs4u.usermanagement.domain.BaseRoles;

/**
 * @author Paulo Gandra de Sousa 2024.04.30
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