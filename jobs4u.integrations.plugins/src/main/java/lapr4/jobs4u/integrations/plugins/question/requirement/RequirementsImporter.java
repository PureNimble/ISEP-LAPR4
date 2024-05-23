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
import lapr4.jobs4u.importer.xml.generated.RequirementsXmlLexer;
import lapr4.jobs4u.importer.xml.generated.RequirementsXmlParser;
import lapr4.jobs4u.integration.questions.importer.application.QuestionImporter;
import lapr4.jobs4u.integration.questions.importer.domain.QuestionImporterPlugin;
import lapr4.jobs4u.questionmanagement.dto.InterviewQuestionDTO;
import lapr4.jobs4u.questionmanagement.dto.RequirementsQuestionDTO;

public class RequirementsImporter implements QuestionImporter {

	@Override
	public Iterable<RequirementsQuestionDTO> importRequirementsFrom(final InputStream filename, final QuestionImporterPlugin plugin)
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

		for (RequirementsQuestionDTO question : questions) {
			question.setQuestionImporterPlugin(plugin.identity().toString());
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

		for (RequirementsQuestionDTO question : questions) {
			question.setQuestionImporterPlugin(plugin.identity().toString());
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

		for (RequirementsQuestionDTO question : questions) {
			question.setQuestionImporterPlugin(plugin.identity().toString());
		}

		return questions;
	}

	@Override
	public Iterable<InterviewQuestionDTO> importInterviewFrom(InputStream filename, QuestionImporterPlugin plugin)
			throws IOException {
		throw new UnsupportedOperationException("Unimplemented method 'importInterviewFrom'");
	}

}