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
package lapr4.jobs4u.integrations.plugins.question.interview;

import java.io.IOException;
import java.io.InputStream;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import lapr4.jobs4u.importer.csv.generated.interview.InterviewCsvLexer;
import lapr4.jobs4u.importer.csv.generated.interview.InterviewCsvParser;
import lapr4.jobs4u.importer.json.generated.interview.InterviewJsonLexer;
import lapr4.jobs4u.importer.json.generated.interview.InterviewJsonParser;
import lapr4.jobs4u.importer.xml.generated.InterviewXmlLexer;
import lapr4.jobs4u.importer.xml.generated.InterviewXmlParser;
import lapr4.jobs4u.integration.questions.importer.application.QuestionImporter;
import lapr4.jobs4u.integration.questions.importer.domain.QuestionImporterPlugin;
import lapr4.jobs4u.questionmanagement.dto.InterviewQuestionDTO;
import lapr4.jobs4u.questionmanagement.dto.RequirementsQuestionDTO;

public class InterviewImporter implements QuestionImporter {

	@Override
	public Iterable<InterviewQuestionDTO> importInterviewFrom(final InputStream filename, final QuestionImporterPlugin plugin)
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

	private Iterable<InterviewQuestionDTO> importFromCSV(final InputStream filename, final QuestionImporterPlugin plugin)
			throws IOException {

		// parse
		final CharStream charStream = CharStreams.fromStream(filename);
		final InterviewCsvLexer lexer = new InterviewCsvLexer(charStream);
		final CommonTokenStream tokens = new CommonTokenStream(lexer);
		final InterviewCsvParser parser = new InterviewCsvParser(tokens);
		final ParseTree tree = parser.questions();
		final InterviewCsvListener listener = new InterviewCsvListener();

		if (parser.getNumberOfSyntaxErrors() > 0) {
			throw new IOException("Syntax error in CSV file");
		}

		ParseTreeWalker.DEFAULT.walk(listener, tree);

		Iterable<InterviewQuestionDTO> questions = listener.questions();

		for (InterviewQuestionDTO question : questions) {
			question.setQuestionImporterPlugin(plugin.identity().toString());
		}

		return questions;
	}

	private Iterable<InterviewQuestionDTO> importFromJSON(final InputStream filename, final QuestionImporterPlugin plugin)
			throws IOException {
		// parse
		final CharStream charStream = CharStreams.fromStream(filename);
		final InterviewJsonLexer lexer = new InterviewJsonLexer(charStream);
		final CommonTokenStream tokens = new CommonTokenStream(lexer);
		final InterviewJsonParser parser = new InterviewJsonParser(tokens);
		final ParseTree tree = parser.questions();
		final InterviewJsonListener listener = new InterviewJsonListener();

		if (parser.getNumberOfSyntaxErrors() > 0) {
			throw new IOException("Syntax error in JSON file");
		}

		ParseTreeWalker.DEFAULT.walk(listener, tree);

		Iterable<InterviewQuestionDTO> questions = listener.questions();

		for (InterviewQuestionDTO question : questions) {
			question.setQuestionImporterPlugin(plugin.identity().toString());
		}

		return questions;
	}

	private Iterable<InterviewQuestionDTO> importFromXML(final InputStream filename, final QuestionImporterPlugin plugin)
			throws IOException {
		// parse
		final CharStream charStream = CharStreams.fromStream(filename);
		final InterviewXmlLexer lexer = new InterviewXmlLexer(charStream);
		final CommonTokenStream tokens = new CommonTokenStream(lexer);
		final InterviewXmlParser parser = new InterviewXmlParser(tokens);
		final ParseTree tree = parser.questions();
		final InterviewXmlListener listener = new InterviewXmlListener();

		if (parser.getNumberOfSyntaxErrors() > 0) {
			throw new IOException("Syntax error in XML file");
		}

		ParseTreeWalker.DEFAULT.walk(listener, tree);

		Iterable<InterviewQuestionDTO> questions = listener.questions();

		for (InterviewQuestionDTO question : questions) {
			question.setQuestionImporterPlugin(plugin.identity().toString());
		}

		return questions;
	}

	@Override
	public Iterable<RequirementsQuestionDTO> importRequirementsFrom(InputStream filename, QuestionImporterPlugin plugin)
			throws IOException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'importRequirementsFrom'");
	}

}