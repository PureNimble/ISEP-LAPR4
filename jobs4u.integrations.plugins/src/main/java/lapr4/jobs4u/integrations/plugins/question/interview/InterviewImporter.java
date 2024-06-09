package lapr4.jobs4u.integrations.plugins.question.interview;

import java.io.IOException;
import java.io.InputStream;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import lapr4.jobs4u.errors.CustomErrorListener;
import lapr4.jobs4u.errors.CustomErrorStrategy;
import lapr4.jobs4u.importer.interview.template.csv.generated.InterviewCsvLexer;
import lapr4.jobs4u.importer.interview.template.csv.generated.InterviewCsvParser;
import lapr4.jobs4u.importer.interview.template.json.generated.InterviewJsonLexer;
import lapr4.jobs4u.importer.interview.template.json.generated.InterviewJsonParser;
import lapr4.jobs4u.importer.interview.template.xml.generated.InterviewXmlLexer;
import lapr4.jobs4u.importer.interview.template.xml.generated.InterviewXmlParser;
import lapr4.jobs4u.integration.questions.importer.application.QuestionImporter;
import lapr4.jobs4u.integration.questions.importer.domain.QuestionImporterPlugin;
import lapr4.jobs4u.questionmanagement.dto.InterviewQuestionDTO;

/**
 * @author 2DI2
 */
public class InterviewImporter implements QuestionImporter {

	@SuppressWarnings("unchecked")
	@Override
	public Iterable<InterviewQuestionDTO> importQuestionsFrom(final InputStream filename,
			final QuestionImporterPlugin plugin)
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

	private Iterable<InterviewQuestionDTO> importFromCSV(final InputStream filename,
			final QuestionImporterPlugin plugin)
			throws IOException {

		// parse
		final CharStream charStream = CharStreams.fromStream(filename);
		final InterviewCsvLexer lexer = new InterviewCsvLexer(charStream);
		final CommonTokenStream tokens = new CommonTokenStream(lexer);
		final InterviewCsvParser parser = new InterviewCsvParser(tokens);
		parser.setErrorHandler(new CustomErrorStrategy());
        parser.removeErrorListeners();
        parser.addErrorListener(CustomErrorListener.INSTANCE);
		final ParseTree tree = parser.questions();
		final InterviewCsvListener listener = new InterviewCsvListener();

		if (parser.getNumberOfSyntaxErrors() > 0) {
			throw new IOException("Syntax error in CSV file");
		}

		ParseTreeWalker.DEFAULT.walk(listener, tree);

		Iterable<InterviewQuestionDTO> questions = listener.questions();

		for (final InterviewQuestionDTO question : questions) {
			question.setQuestionImporterPlugin(plugin);
		}

		return questions;
	}

	private Iterable<InterviewQuestionDTO> importFromJSON(final InputStream filename,
			final QuestionImporterPlugin plugin)
			throws IOException {
		// parse
		final CharStream charStream = CharStreams.fromStream(filename);
		final InterviewJsonLexer lexer = new InterviewJsonLexer(charStream);
		final CommonTokenStream tokens = new CommonTokenStream(lexer);
		final InterviewJsonParser parser = new InterviewJsonParser(tokens);
		parser.setErrorHandler(new CustomErrorStrategy());
		final ParseTree tree = parser.questions();
		final InterviewJsonListener listener = new InterviewJsonListener();

		if (parser.getNumberOfSyntaxErrors() > 0) {
			throw new IOException("Syntax error in JSON file");
		}

		ParseTreeWalker.DEFAULT.walk(listener, tree);

		Iterable<InterviewQuestionDTO> questions = listener.questions();
		for (final InterviewQuestionDTO question : questions) {
			question.setQuestionImporterPlugin(plugin);
		}

		return questions;
	}

	private Iterable<InterviewQuestionDTO> importFromXML(final InputStream filename,
			final QuestionImporterPlugin plugin)
			throws IOException {
		// parse
		final CharStream charStream = CharStreams.fromStream(filename);
		final InterviewXmlLexer lexer = new InterviewXmlLexer(charStream);
		final CommonTokenStream tokens = new CommonTokenStream(lexer);
		final InterviewXmlParser parser = new InterviewXmlParser(tokens);
		parser.setErrorHandler(new CustomErrorStrategy());
		final ParseTree tree = parser.questions();
		final InterviewXmlListener listener = new InterviewXmlListener();

		if (parser.getNumberOfSyntaxErrors() > 0) {
			throw new IOException("Syntax error in XML file");
		}

		ParseTreeWalker.DEFAULT.walk(listener, tree);

		Iterable<InterviewQuestionDTO> questions = listener.questions();

		for (final InterviewQuestionDTO question : questions) {
			question.setQuestionImporterPlugin(plugin);
		}

		return questions;
	}

}