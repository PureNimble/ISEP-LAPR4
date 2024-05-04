package lapr4.jobs4u.infrastructure.smoketests;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import eapli.framework.actions.Action;
import eapli.framework.io.util.Files;
import lapr4.jobs4u.integration.questions.export.application.FileFormat;
import lapr4.jobs4u.integration.questions.export.application.QuestionExporterController;

public class QuestionExportSmokeTester implements Action {

	private static final Logger LOGGER = LogManager.getLogger(QuestionExportSmokeTester.class);

	private final QuestionExporterController questionExporterController = new QuestionExporterController();

	@Override
	public boolean execute() {
		testExportTo(FileFormat.INTERVIEW, "Standard");
		testExportTo(FileFormat.REQUIREMENT, "Alternate");

		// nothing else to do
		return true;
	}

	private void testExportTo(final FileFormat format, final String plugin) {
		final var filename = "jobs4u.bootstrappers/target/" + plugin + ".txt";
		try {
			questionExporterController.export(filename, format, plugin);
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