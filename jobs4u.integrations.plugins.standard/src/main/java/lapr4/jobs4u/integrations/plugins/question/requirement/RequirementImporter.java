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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import lapr4.jobs4u.integration.questions.import_.application.QuestionImporter;
import lapr4.jobs4u.integration.questions.import_.domain.QuestionImporterPlugin;
import lapr4.jobs4u.questionmanagement.domain.Answer;
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
			throw new IllegalArgumentException("Unsupported file extension: " + plugin.fileExtension());
		}
	}

	private Iterable<QuestionDTO> importFromCSV(final InputStream filename, final QuestionImporterPlugin plugin)
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
				result.add(new QuestionDTO(values[0], null,values[1], answers, plugin.identity().toString()));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	private Iterable<QuestionDTO> importFromJSON(final InputStream filename, final QuestionImporterPlugin plugin)
			throws IOException {
		var result = new ArrayList<QuestionDTO>();
		ObjectMapper objectMapper = new ObjectMapper();
		try (BufferedReader br = new BufferedReader(new InputStreamReader(filename))) {
			String content = br.lines().collect(Collectors.joining());
			List<QuestionDTO> questionDTOs = objectMapper.readValue(content,
					new TypeReference<List<QuestionDTO>>() {
					});
			for (QuestionDTO questionDTO : questionDTOs) {
				QuestionDTO newQuestionDTO = new QuestionDTO(
						questionDTO.getType(),
						null,
						questionDTO.getBody(),
						questionDTO.getPossibleAnswers(),
						plugin.identity().toString());
				result.add(newQuestionDTO);
			}
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return result;
	}

	private Iterable<QuestionDTO> importFromXML(final InputStream filename, final QuestionImporterPlugin plugin)
			throws IOException {
		var result = new ArrayList<QuestionDTO>();
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(filename);
			NodeList questionNodes = doc.getElementsByTagName("Question");
			for (int i = 0; i < questionNodes.getLength(); i++) {
				Element questionElement = (Element) questionNodes.item(i);
				String type = questionElement.getElementsByTagName("type").item(0).getTextContent();
				String body = questionElement.getElementsByTagName("body").item(0).getTextContent();
				Element possibleAnswersElement = (Element) questionElement.getElementsByTagName("possibleAnswersList")
						.item(0);
				NodeList answerNodes = possibleAnswersElement.getElementsByTagName("possibleAnswers");
				List<Answer> possibleAnswers = new ArrayList<>();
				for (int j = 0; j < answerNodes.getLength(); j++) {
					Element answerElement = (Element) answerNodes.item(j);
					Answer answer = Answer.valueOf(answerElement.getTextContent());
					possibleAnswers.add(answer);
				}
				QuestionDTO newQuestionDTO = new QuestionDTO(type, null,body, possibleAnswers, plugin.identity().toString());
				result.add(newQuestionDTO);
			}
		} catch (IOException | SAXException | ParserConfigurationException e) {
			e.printStackTrace();
		}
		return result;
	}
}