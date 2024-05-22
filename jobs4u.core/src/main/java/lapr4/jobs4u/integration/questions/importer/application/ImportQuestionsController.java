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
package lapr4.jobs4u.integration.questions.importer.application;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import eapli.framework.application.UseCaseController;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import lapr4.jobs4u.infrastructure.persistence.PersistenceContext;
import lapr4.jobs4u.integration.questions.importer.domain.QuestionImporterPlugin;
import lapr4.jobs4u.integration.questions.importer.repositories.QuestionImporterPluginRepository;
import lapr4.jobs4u.questionmanagement.application.viadto.QuestionDTOParser;
import lapr4.jobs4u.questionmanagement.domain.Question;
import lapr4.jobs4u.questionmanagement.dto.QuestionDTO;
import lapr4.jobs4u.questionmanagement.repositories.QuestionRepository;
import lapr4.jobs4u.questionmanagement.repositories.QuestionTypeRepository;
import lapr4.jobs4u.usermanagement.domain.BaseRoles;

/**
 * @author Paulo Gandra de Sousa 2024.04.30
 */
@UseCaseController
public class ImportQuestionsController {
	private static final Logger LOGGER = LogManager.getLogger(ImportQuestionsController.class);

	private final AuthorizationService authz = AuthzRegistry.authorizationService();
	private final QuestionImporterPluginRepository pluginRepo = PersistenceContext.repositories()
			.questionImporterPlugins();
	private final QuestionRepository questionRepository = PersistenceContext.repositories().question();
	private final QuestionTypeRepository questionTypeRepository = PersistenceContext.repositories().questionType();

	/**
	 * Import questions from a file. It uses the file extension to determine which
	 * import plugin to activate.
	 * <p>
	 * If there is an error parsing the file no dish will be imported.
	 * 
	 * @param filename
	 * @return the list of imported questions
	 * @throws IOException
	 */
	public List<Question> importQuestions(final String filename) throws IOException {
		authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.LANGUAGE_ENGINEER, BaseRoles.POWERUSER);

		// TODO refactor this method to move logic from the controller into a service
		// class

		// prepare the result variable
		List<Question> questions = new ArrayList<>();

		// get the content of the file to import
		InputStream content = null;
		try {
			// get the content of the file to import
			content = new FileInputStream(filename);


			// get the right plugin for the file
			//final var fileExt = FilenameUtils.getExtension(filename);

			final String fileName = FilenameUtils.getBaseName(filename);

			final QuestionImporterPlugin plugin = pluginRepo.findByName(Designation.valueOf(fileName)).orElseThrow(
					() -> new IllegalStateException("There is no plugin associated with that name"));

			/* final var plugin = pluginRepo.findByFileExtension(FileExtension.valueOf(fileExt)).orElseThrow(
					() -> new IllegalStateException("There is no plugin associated with that file extension")); */

			// load the plugin
			final QuestionImporter importer = plugin.buildImporter();
			// parse the content
			final Iterable<QuestionDTO> questionsToRegister = importer.importFrom(content, plugin);

			// do the import
			questions = doTheImport(questionsToRegister);
		} finally {
			if (content != null) {
				try {
					content.close();
				} catch (final IOException e) {
					LOGGER.error("Error closing the file {}", filename);
				}
			}
		}

		return questions;
	}

	private List<Question> doTheImport(final Iterable<QuestionDTO> questionsToRegister) {
		// TODO begin transaction
		final List<Question> questions = new ArrayList<>();
		for (final QuestionDTO dto : questionsToRegister) {
			final Question newQuestion = new QuestionDTOParser(questionTypeRepository).valueOf(dto);
			// TODO check what should be done if we are trying to import a question that
			// already
			// exists
			final Question savedQuestion = questionRepository.save(newQuestion);
			questions.add(savedQuestion);
		}
		// TODO commit transaction
		return questions;
	}
}