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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import lapr4.jobs4u.integration.questions.import_.application.QuestionImporter;
import lapr4.jobs4u.integration.questions.import_.domain.QuestionImporterPlugin;
import lapr4.jobs4u.questionmanagement.domain.Answer;
import lapr4.jobs4u.questionmanagement.dto.QuestionDTO;

public class InterviewImporter implements QuestionImporter {

	@Override
	public Iterable<QuestionDTO> importFrom(final InputStream filename, final QuestionImporterPlugin plugin)
			throws IOException {

		var result = new ArrayList<QuestionDTO>();
		try (BufferedReader br = new BufferedReader(new InputStreamReader(filename))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] values = line.replace("\"", "").split(";");
				String[] answerStrings = values[values.length - 1].split("/");
				List<Answer> answers = new ArrayList<>();
				for (String answerString : answerStrings) {
					Answer answer = Answer.valueOf(answerString);
					answers.add(answer);
				}
				result.add(new QuestionDTO(values[0], values[1], answers, plugin.identity().toString()));
			}
		}
		return result;
	}
}
