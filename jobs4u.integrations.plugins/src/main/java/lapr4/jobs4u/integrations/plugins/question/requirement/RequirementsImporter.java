package lapr4.jobs4u.integrations.plugins.question.requirement;

import java.io.IOException;
import java.io.InputStream;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import lapr4.jobs4u.importer.csv.generated.requirement.RequirementsCsvLexer;
import lapr4.jobs4u.importer.csv.generated.requirement.RequirementsCsvParser;
import lapr4.jobs4u.importer.json.generated.requirement.RequirementsJsonLexer;
import lapr4.jobs4u.importer.json.generated.requirement.RequirementsJsonParser;
import lapr4.jobs4u.importer.xml.generated.requirement.RequirementsXmlLexer;
import lapr4.jobs4u.importer.xml.generated.requirement.RequirementsXmlParser;
import lapr4.jobs4u.integration.questions.importer.application.QuestionImporter;
import lapr4.jobs4u.integration.questions.importer.domain.QuestionImporterPlugin;
import lapr4.jobs4u.questionmanagement.dto.RequirementsQuestionDTO;

/**
 * @author 2DI2
 */
public class RequirementsImporter implements QuestionImporter {

	@SuppressWarnings("unchecked")
	@Override
	public Iterable<RequirementsQuestionDTO> importQuestionsFrom(final InputStream filename, final QuestionImporterPlugin plugin)
			throws IOException {

		if (plugin.fileExtension().toString().equals("csv")) {

			return importFromCSV(filename, plugin);

		} else if (plugin.fileExtension().toString().equals("json")) {

			return importFromJSON(filename, plugin);

		} else if (plugin.fileExtension().toString().equals("xml")) {

			return importFromXML(filename, plugin);

		} else {
			throw new IOException("Unsupported file extension: " + plugin.fileExtension());
		}
	}

	private Iterable<RequirementsQuestionDTO> importFromCSV(final InputStream filename, final QuestionImporterPlugin plugin)
			throws IOException {

		// parse
		final CharStream charStream = CharStreams.fromStream(filename);
		final RequirementsCsvLexer lexer = new RequirementsCsvLexer(charStream);
		final CommonTokenStream tokens = new CommonTokenStream(lexer);
		final RequirementsCsvParser parser = new RequirementsCsvParser(tokens);
		final ParseTree tree = parser.questions();
		final RequirementsCsvListener listener = new RequirementsCsvListener();

		if (parser.getNumberOfSyntaxErrors() > 0) {
			throw new IOException("Syntax error in CSV file");
		}

		ParseTreeWalker.DEFAULT.walk(listener, tree);

		Iterable<RequirementsQuestionDTO> questions = listener.questions();

		for (final RequirementsQuestionDTO question : questions) {
			question.setQuestionImporterPlugin(plugin);
		}

		return questions;
	}

	private Iterable<RequirementsQuestionDTO> importFromJSON(final InputStream filename, final QuestionImporterPlugin plugin)
			throws IOException {
		// parse
		final CharStream charStream = CharStreams.fromStream(filename);
		final RequirementsJsonLexer lexer = new RequirementsJsonLexer(charStream);
		final CommonTokenStream tokens = new CommonTokenStream(lexer);
		final RequirementsJsonParser parser = new RequirementsJsonParser(tokens);
		final ParseTree tree = parser.questions();
		final RequirementsJsonListener listener = new RequirementsJsonListener();

		if (parser.getNumberOfSyntaxErrors() > 0) {
			throw new IOException("Syntax error in JSON file");
		}

		ParseTreeWalker.DEFAULT.walk(listener, tree);

		Iterable<RequirementsQuestionDTO> questions = listener.questions();

		for (final RequirementsQuestionDTO question : questions) {
			question.setQuestionImporterPlugin(plugin);
		}

		return questions;
	}

	private Iterable<RequirementsQuestionDTO> importFromXML(final InputStream filename, final QuestionImporterPlugin plugin)
			throws IOException {
		// parse
		final CharStream charStream = CharStreams.fromStream(filename);
		final RequirementsXmlLexer lexer = new RequirementsXmlLexer(charStream);
		final CommonTokenStream tokens = new CommonTokenStream(lexer);
		final RequirementsXmlParser parser = new RequirementsXmlParser(tokens);
		final ParseTree tree = parser.questions();
		final RequirementsXmlListener listener = new RequirementsXmlListener();

		if (parser.getNumberOfSyntaxErrors() > 0) {
			throw new IOException("Syntax error in XML file");
		}

		ParseTreeWalker.DEFAULT.walk(listener, tree);

		Iterable<RequirementsQuestionDTO> questions = listener.questions();

		for (final RequirementsQuestionDTO question : questions) {
			question.setQuestionImporterPlugin(plugin);
		}

		return questions;
	}

}