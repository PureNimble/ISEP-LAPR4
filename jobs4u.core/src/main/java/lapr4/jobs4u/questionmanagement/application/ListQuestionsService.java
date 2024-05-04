package lapr4.jobs4u.questionmanagement.application;

import lapr4.jobs4u.questionmanagement.domain.Question;
import lapr4.jobs4u.questionmanagement.repositories.QuestionRepository;

public class ListQuestionsService {

    private final QuestionRepository questionRepository;

    public ListQuestionsService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public Iterable<Question> findQuestionsByPlugin(final String plugin) {
        return this.questionRepository.findQuestionsByPlugin(plugin);
    }
    
}
