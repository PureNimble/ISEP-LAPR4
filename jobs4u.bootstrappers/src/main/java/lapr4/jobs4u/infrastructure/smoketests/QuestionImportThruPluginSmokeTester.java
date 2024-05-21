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

import lapr4.jobs4u.integration.questions.import_.application.ImportQuestionsController;
import lapr4.jobs4u.questionmanagement.domain.Question;

/**
 *
 * @author Paulo Gandra de Sousa 30/04/2024
 *
 */
public class QuestionImportThruPluginSmokeTester implements Action {
	private static final Logger LOGGER = LogManager.getLogger(QuestionImportThruPluginSmokeTester.class);

	private final ImportQuestionsController importQuestionsController = new ImportQuestionsController();

	@Override
	public boolean execute() {
		// import one file in standard format
		testImportFrom("jobs4u.ANTLR/src/main/resources/input/Standard.csv");
		testImportFrom("jobs4u.ANTLR/src/main/resources/input/JsonFile.json");
		// import one file in alternate format
		testImportFrom("jobs4u.ANTLR/src/main/resources/input/Alternate.csv");
		testImportFrom("jobs4u.ANTLR/src/main/resources/input/XmlFile.xml");

		// nothing else to do
		return true;
	}

	private void testImportFrom(final String file) {
		try {
			final var r = importQuestionsController.importQuestions(file);
			outputImportedContent(file, r);
		} catch (final IOException e) {
			LOGGER.error("Error while importing questions from {}", file, e);
		}
	}

	private void outputImportedContent(final String filename, final Iterable<Question> questions) {
		// output the imported content
		if (LOGGER.isInfoEnabled()) {
			LOGGER.info("-- IMPORT QUESTIONS FROM {} USING A PLUGIN --", filename);

			for (final var d : questions) {
				LOGGER.info(d.identity());
			}
			LOGGER.info("-- END IMPORT --");
		}
	}
}
