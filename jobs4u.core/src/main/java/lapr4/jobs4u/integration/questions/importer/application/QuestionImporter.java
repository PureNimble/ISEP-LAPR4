package lapr4.jobs4u.integration.questions.importer.application;

import java.io.IOException;
import java.io.InputStream;

import lapr4.jobs4u.integration.questions.importer.domain.QuestionImporterPlugin;

/**
 * @author 2DI2
 */
public interface QuestionImporter {
	<T> Iterable<T> importQuestionsFrom(final InputStream filename, final QuestionImporterPlugin plugin) throws IOException;
}