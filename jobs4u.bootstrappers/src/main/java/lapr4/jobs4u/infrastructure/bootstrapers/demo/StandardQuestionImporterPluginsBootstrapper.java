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
package lapr4.jobs4u.infrastructure.bootstrapers.demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import eapli.framework.actions.Action;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import lapr4.jobs4u.integration.questions.importer.application.RegisterQuestionImporterPluginController;

/**
 * @author Paulo Gandra de Sousa 2024.04.30
 */
public class StandardQuestionImporterPluginsBootstrapper implements Action {

	private static final Logger LOGGER = LogManager.getLogger(StandardQuestionImporterPluginsBootstrapper.class);

	RegisterQuestionImporterPluginController registerQuestionImporterPluginController = new RegisterQuestionImporterPluginController();

	@Override
	public boolean execute() {

		// just to showcase two plugins

		register("Standard", "Standard question format", "csv",
				"lapr4.jobs4u.integrations.plugins.question.interview.InterviewImporter", "INTERVIEW");
		register("JsonFile", "JsonFile question format", "json",
				"lapr4.jobs4u.integrations.plugins.question.interview.InterviewImporter", "INTERVIEW");

		register("XmlFile", "XmlFile standard question format", "xml",
				"lapr4.jobs4u.integrations.plugins.question.requirement.RequirementImporter", "REQUIREMENT");
		register("Alternate", "Alternate standard question format", "csv",
				"lapr4.jobs4u.integrations.plugins.question.requirement.RequirementImporter", "REQUIREMENT");
		return true;
	}

	private void register(final String name, final String description, final String fileExtension,
			final String fqClassName, final String pluginType) {
		try {
			registerQuestionImporterPluginController.registerQuestionImporterPlugin(name, description, fileExtension,
					fqClassName, pluginType);
			LOGGER.info(name);
		} catch (final IntegrityViolationException | ConcurrencyException e) {
			// ignoring exception. assuming it is just a primary key violation
			// due to the tentative of inserting a duplicated plugin during bootstrap
			LOGGER.warn("Assuming {} already exists (activate trace log for details)", name);
			LOGGER.trace("Assuming existing record", e);
		}
	}
}
