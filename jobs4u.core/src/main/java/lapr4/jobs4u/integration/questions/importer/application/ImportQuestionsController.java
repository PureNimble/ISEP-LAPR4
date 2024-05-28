package lapr4.jobs4u.integration.questions.importer.application;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import lapr4.jobs4u.integration.questions.importer.domain.QuestionImporterPlugin;
import lapr4.jobs4u.integration.questions.importer.repositories.QuestionImporterPluginRepository;
import lapr4.jobs4u.questionmanagement.application.viadto.InterviewQuestionDTOParser;
import lapr4.jobs4u.questionmanagement.application.viadto.RequirementsQuestionDTOParser;
import lapr4.jobs4u.questionmanagement.domain.InterviewQuestion;
import lapr4.jobs4u.questionmanagement.domain.RequirementsQuestion;
import lapr4.jobs4u.questionmanagement.dto.InterviewQuestionDTO;
import lapr4.jobs4u.questionmanagement.dto.RequirementsQuestionDTO;
import lapr4.jobs4u.questionmanagement.repositories.InterviewQuestionRepository;
import lapr4.jobs4u.questionmanagement.repositories.QuestionTypeRepository;
import lapr4.jobs4u.questionmanagement.repositories.RequirementsQuestionRepository;
import lapr4.jobs4u.usermanagement.domain.BaseRoles;

/**
 * @author 2DI2
 */
@UseCaseController
public class ImportQuestionsController {
	private static final Logger LOGGER = LogManager.getLogger(ImportQuestionsController.class);

	private final AuthorizationService authz;
	private final InterviewQuestionRepository interviewQuestionRepository;
	private final RequirementsQuestionRepository requirementsQuestionRepository;
	private final QuestionTypeRepository questionTypeRepository;

	public ImportQuestionsController(final QuestionImporterPluginRepository pluginRepo,
			final InterviewQuestionRepository interviewQuestionRepository,
			final RequirementsQuestionRepository requirementsQuestionRepository,
			final QuestionTypeRepository questionTypeRepository,
			final AuthorizationService authz) {
		this.interviewQuestionRepository = interviewQuestionRepository;
		this.requirementsQuestionRepository = requirementsQuestionRepository;
		this.questionTypeRepository = questionTypeRepository;
		this.authz = authz;

	}

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
	public List<InterviewQuestion> importInterviewQuestions(final String filename, final QuestionImporterPlugin plugin) throws IOException {
		authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.LANGUAGE_ENGINEER, BaseRoles.POWERUSER);

		List<InterviewQuestion> questions = new ArrayList<>();

		InputStream content = null;
		try {
			content = new FileInputStream(filename);

			final QuestionImporter importer = plugin.buildImporter();

			final Iterable<InterviewQuestionDTO> questionsToRegister = importer.importQuestionsFrom(content, plugin);
			questions = doTheInterviewImport(questionsToRegister);

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
	public List<RequirementsQuestion> importRequirementsQuestions(final String filename, final QuestionImporterPlugin plugin) throws IOException {
		authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.LANGUAGE_ENGINEER, BaseRoles.POWERUSER);

		List<RequirementsQuestion> questions = new ArrayList<>();

		InputStream content = null;
		try {
			content = new FileInputStream(filename);

			final QuestionImporter importer = plugin.buildImporter();

			final Iterable<RequirementsQuestionDTO> questionsToRegister = importer.importQuestionsFrom(content, plugin);
			questions = doTheRequirementsImport(questionsToRegister);

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

	private List<InterviewQuestion> doTheInterviewImport(final Iterable<InterviewQuestionDTO> questionsToRegister) {
		final List<InterviewQuestion> questions = new ArrayList<>();
		for (final InterviewQuestionDTO dto : questionsToRegister) {
			final InterviewQuestion newQuestion = new InterviewQuestionDTOParser(questionTypeRepository).valueOf(dto);
			final InterviewQuestion savedQuestion = interviewQuestionRepository.save(newQuestion);
			questions.add(savedQuestion);
		}
		return questions;
	}

	private List<RequirementsQuestion> doTheRequirementsImport(
			final Iterable<RequirementsQuestionDTO> questionsToRegister) {
		final List<RequirementsQuestion> questions = new ArrayList<>();
		for (final RequirementsQuestionDTO dto : questionsToRegister) {
			final RequirementsQuestion newQuestion = new RequirementsQuestionDTOParser().valueOf(dto);
			final RequirementsQuestion savedQuestion = requirementsQuestionRepository.save(newQuestion);
			questions.add(savedQuestion);
		}
		return questions;
	}
}