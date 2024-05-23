/*
 * Copyright (c) 2013-2024 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and
 * associated documentation files (the "Software"), to deal in the Software
 * without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish,
 * distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom
 * the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR
 * PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE
 * FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR
 * OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package lapr4.jobs4u.infrastructure.smoketests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import eapli.framework.actions.Action;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import lapr4.jobs4u.infrastructure.persistence.PersistenceContext;
import lapr4.jobs4u.integration.questions.importer.application.ImportQuestionsController;
import lapr4.jobs4u.integration.questions.importer.application.RegisterQuestionImporterPluginController;
import lapr4.jobs4u.integration.questions.importer.domain.QuestionImporterPlugin;

/**
 *
 * @author Paulo Gandra de Sousa 30/04/2024
 *
 */
public class QuestionImportThruPluginSmokeTester implements Action {

	private static final String INTERVIEW_IMPORTER = "lapr4.jobs4u.integrations.plugins.question.interview.InterviewImporter";
	private static final String REQUIREMENTS_IMPORTER = "lapr4.jobs4u.integrations.plugins.question.requirement.RequirementsImporter";
	private static final Logger LOGGER = LogManager.getLogger(QuestionImportThruPluginSmokeTester.class);

	private final TransactionalContext txCtx = PersistenceContext.repositories().newTransactionalContext();
	private final ImportQuestionsController importQuestionsController = new ImportQuestionsController(
			PersistenceContext.repositories().questionImporterPlugins(),
			PersistenceContext.repositories().interviewQuestion(),
			PersistenceContext.repositories().requirementsQuestion(),
			PersistenceContext.repositories().questionType(), AuthzRegistry.authorizationService());

	private final RegisterQuestionImporterPluginController registerQuestionImporterPluginController = new RegisterQuestionImporterPluginController(
			PersistenceContext.repositories().questionImporterPlugins(txCtx), AuthzRegistry.authorizationService());

	@Override
	public boolean execute() {
		// just to showcase two plugins
		try {
			txCtx.beginTransaction();
			QuestionImporterPlugin plugin = register("InterviewCSV", "Interview question csv format", "csv",
					INTERVIEW_IMPORTER,
					"INTERVIEW");
			testImportInterviewFrom("jobs4u.ANTLR/src/main/resources/input/InterviewCSV.csv", plugin);

			plugin = register("InterviewJSON", "Interview question json format", "json", INTERVIEW_IMPORTER,
					"INTERVIEW");
			testImportInterviewFrom("jobs4u.ANTLR/src/main/resources/input/InterviewJSON.json", plugin);

			plugin = register("InterviewXML", "Interview question xml format", "xml", INTERVIEW_IMPORTER, "INTERVIEW");
			testImportInterviewFrom("jobs4u.ANTLR/src/main/resources/input/InterviewXML.xml", plugin);

			plugin = register("RequirementsCSV", "Requirements question csv format", "csv", REQUIREMENTS_IMPORTER,
					"REQUIREMENT");
			testImportRequirementsFrom("jobs4u.ANTLR/src/main/resources/input/RequirementsCSV.csv", plugin);

			plugin = register("RequirementsJSON", "Requirements question json format", "json", REQUIREMENTS_IMPORTER,
					"REQUIREMENT");
			testImportRequirementsFrom("jobs4u.ANTLR/src/main/resources/input/RequirementsJSON.json", plugin);

			plugin = register("RequirementsXML", "Requirements question xml format", "xml", REQUIREMENTS_IMPORTER,
					"REQUIREMENT");
			testImportRequirementsFrom("jobs4u.ANTLR/src/main/resources/input/RequirementsXML.xml", plugin);
			txCtx.commit();
		} catch (final IOException e) {
			txCtx.rollback();
			LOGGER.error("Error while importing plugins");
		} finally {
			txCtx.close();
		}

		// nothing else to do
		return true;
	}

	private QuestionImporterPlugin register(final String name, final String description, final String fileExtension,
			final String fqClassName, final String pluginType) {

		return registerQuestionImporterPluginController.registerQuestionImporterPlugin(name, description, fileExtension,
				fqClassName, pluginType);
	}

	private void testImportInterviewFrom(final String file, final QuestionImporterPlugin plugin) throws IOException {
		importQuestionsController.importInterviewQuestions(file, plugin);
	}

	private void testImportRequirementsFrom(final String file, final QuestionImporterPlugin plugin) throws IOException {
		importQuestionsController.importRequirementsQuestions(file, plugin);
	}
}
