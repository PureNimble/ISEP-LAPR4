package lapr4.jobs4u.questionmanagement.application;

import lapr4.jobs4u.questionmanagement.domain.InterviewQuestion;
import lapr4.jobs4u.questionmanagement.domain.RequirementsQuestion;
import lapr4.jobs4u.questionmanagement.repositories.InterviewQuestionRepository;
import lapr4.jobs4u.questionmanagement.repositories.RequirementsQuestionRepository;

/**
 * @author 2DI2
 */
public class ListQuestionsService {

    private final InterviewQuestionRepository interviewQuestionRepository;
    private final RequirementsQuestionRepository requirementsQuestionRepository;

    public ListQuestionsService(InterviewQuestionRepository questionRepository, RequirementsQuestionRepository requirementsQuestionRepository) {
        this.interviewQuestionRepository = questionRepository;
        this.requirementsQuestionRepository = requirementsQuestionRepository;
    }

    public Iterable<InterviewQuestion> findInterviewQuestionsByPlugin(final String plugin) {
        return this.interviewQuestionRepository.findQuestionsByPlugin(plugin);
    }

    public Iterable<RequirementsQuestion> findRequirementsQuestionsByPlugin(final String plugin) {
        return this.requirementsQuestionRepository.findQuestionsByPlugin(plugin);
    }
    
}
