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

import lapr4.jobs4u.importer.csv.parser.CsvLexer;
import lapr4.jobs4u.importer.csv.parser.CsvParser;
import lapr4.jobs4u.importer.json.parser.JsonLexer;
import lapr4.jobs4u.importer.json.parser.JsonParser;
import lapr4.jobs4u.importer.xml.parser.XmlLexer;
import lapr4.jobs4u.importer.xml.parser.XmlParser;
import lapr4.jobs4u.integration.questions.importer.application.QuestionImporter;
import lapr4.jobs4u.integration.questions.importer.domain.QuestionImporterPlugin;
import lapr4.jobs4u.integrations.plugins.question.CsvListener;
import lapr4.jobs4u.integrations.plugins.question.JsonListener;
import lapr4.jobs4u.integrations.plugins.question.XmlListener;
import lapr4.jobs4u.questionmanagement.dto.QuestionDTO;

public class RequirementImporter implements QuestionImporter {

	@Override
	public Iterable<QuestionDTO> importFrom(final InputStream filename, final QuestionImporterPlugin plugin)
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

	private Iterable<QuestionDTO> importFromCSV(final InputStream filename, final QuestionImporterPlugin plugin)
			throws IOException {

		// parse
		final CharStream charStream = CharStreams.fromStream(filename);
		final CsvLexer lexer = new CsvLexer(charStream);
		final CommonTokenStream tokens = new CommonTokenStream(lexer);
		final CsvParser parser = new CsvParser(tokens);
		final ParseTree tree = parser.questions();
		final CsvListener listener = new CsvListener();

		if (parser.getNumberOfSyntaxErrors() > 0) {
			throw new IOException("Syntax error in CSV file");
		}

		ParseTreeWalker.DEFAULT.walk(listener, tree);

		Iterable<QuestionDTO> questions = listener.questions();

		for (QuestionDTO question : questions) {
			question.setQuestionImporterPlugin(plugin.identity().toString());
		}

		return questions;
	}

	private Iterable<QuestionDTO> importFromJSON(final InputStream filename, final QuestionImporterPlugin plugin)
			throws IOException {
		// parse
		final CharStream charStream = CharStreams.fromStream(filename);
		final JsonLexer lexer = new JsonLexer(charStream);
		final CommonTokenStream tokens = new CommonTokenStream(lexer);
		final JsonParser parser = new JsonParser(tokens);
		final ParseTree tree = parser.questions();
		final JsonListener listener = new JsonListener();

		if (parser.getNumberOfSyntaxErrors() > 0) {
			throw new IOException("Syntax error in JSON file");
		}

		ParseTreeWalker.DEFAULT.walk(listener, tree);

		Iterable<QuestionDTO> questions = listener.questions();

		for (QuestionDTO question : questions) {
			question.setQuestionImporterPlugin(plugin.identity().toString());
		}

		return questions;
	}

	private Iterable<QuestionDTO> importFromXML(final InputStream filename, final QuestionImporterPlugin plugin)
			throws IOException {
		// parse
		final CharStream charStream = CharStreams.fromStream(filename);
		final XmlLexer lexer = new XmlLexer(charStream);
		final CommonTokenStream tokens = new CommonTokenStream(lexer);
		final XmlParser parser = new XmlParser(tokens);
		final ParseTree tree = parser.questions();
		final XmlListener listener = new XmlListener();

		if (parser.getNumberOfSyntaxErrors() > 0) {
			throw new IOException("Syntax error in XML file");
		}

		ParseTreeWalker.DEFAULT.walk(listener, tree);

		Iterable<QuestionDTO> questions = listener.questions();

		for (QuestionDTO question : questions) {
			question.setQuestionImporterPlugin(plugin.identity().toString());
		}

		return questions;
	}

}