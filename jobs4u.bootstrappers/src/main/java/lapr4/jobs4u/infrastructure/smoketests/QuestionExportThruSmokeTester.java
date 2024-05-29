package lapr4.jobs4u.infrastructure.smoketests;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import eapli.framework.actions.Action;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.io.util.Files;
import lapr4.jobs4u.infrastructure.persistence.PersistenceContext;
import lapr4.jobs4u.integration.questions.exporter.application.FileFormat;
import lapr4.jobs4u.integration.questions.exporter.application.QuestionExporterController;
import lapr4.jobs4u.integration.questions.importer.application.ListQuestionPluginController;
import lapr4.jobs4u.integration.questions.importer.domain.QuestionImporterPlugin;

/**
 * @author 2DI2
 */
public class QuestionExportThruSmokeTester implements Action {

	private static final Logger LOGGER = LogManager.getLogger(QuestionExportThruSmokeTester.class);

	private final QuestionExporterController questionExporterController = new QuestionExporterController();
	private final ListQuestionPluginController listQuestionPluginController = new ListQuestionPluginController(
			PersistenceContext.repositories().questionImporterPlugins(), AuthzRegistry.authorizationService());

	@Override
	public boolean execute() {
		testExportInterviewTo(FileFormat.INTERVIEW, "InterviewCSV");
		testExportInterviewTo(FileFormat.INTERVIEW, "InterviewJSON");
		testExportInterviewTo(FileFormat.INTERVIEW, "InterviewXML");
		testExportRequirementsTo(FileFormat.REQUIREMENT, "RequirementsCSV");
		testExportRequirementsTo(FileFormat.REQUIREMENT, "RequirementsJSON");
		testExportRequirementsTo(FileFormat.REQUIREMENT, "RequirementsXML");

		// nothing else to do
		return true;
	}

	private void testExportInterviewTo(final FileFormat format, final String plugin) {
		final var filename = "jobs4u.ANTLR/src/main/resources/output/" + plugin + ".txt";
		try {
			final Optional<QuestionImporterPlugin> questionPlugin = listQuestionPluginController.filterByDesignation(plugin);
			final QuestionImporterPlugin questionImporterPlugin = questionPlugin.get();
			questionExporterController.exportInterview(filename, format, questionImporterPlugin);
			outputExportedContent(format, filename, plugin);
		} catch (final IOException e) {
			LOGGER.error(e);
		}
	}

	private void testExportRequirementsTo(final FileFormat format, final String plugin) {
		final var filename = "jobs4u.ANTLR/src/main/resources/output/" + plugin + ".txt";
		try {
			final Optional<QuestionImporterPlugin> questionPlugin = listQuestionPluginController.filterByDesignation(plugin);
			final QuestionImporterPlugin questionImporterPlugin = questionPlugin.get();
			questionExporterController.exportInterview(filename, format, questionImporterPlugin);
			outputExportedContent(format, filename, plugin);
		} catch (final IOException e) {
			LOGGER.error(e);
		}
	}

	private void outputExportedContent(final FileFormat format, final String filename, final String plugin)
			throws IOException {
		// output the exported content
		Files.textFrom(new FileInputStream(filename));
		if (LOGGER.isInfoEnabled()) {
			LOGGER.info("-- EXPORT QUESTIONS TO {} --", format);

			try (var reader = new BufferedReader(
					new InputStreamReader(new FileInputStream(filename), StandardCharsets.UTF_8))) {
				String line;
				while ((line = reader.readLine()) != null) {
					LOGGER.info(line);
				}
			}

			LOGGER.info("----");
		}
	}
}