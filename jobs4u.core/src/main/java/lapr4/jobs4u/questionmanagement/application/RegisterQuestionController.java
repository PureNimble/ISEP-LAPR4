package lapr4.jobs4u.questionmanagement.application;

import java.util.List;

import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import lapr4.jobs4u.questionmanagement.domain.Question;
import lapr4.jobs4u.questionmanagement.domain.QuestionBuilder;
import lapr4.jobs4u.questionmanagement.domain.QuestionType;
import lapr4.jobs4u.questionmanagement.repositories.QuestionRepository;
import lapr4.jobs4u.usermanagement.domain.BaseRoles;
import lapr4.jobs4u.questionmanagement.domain.Answer;

@UseCaseController
public class RegisterQuestionController {
    private final AuthorizationService authz;
    private final QuestionRepository questionRepository;

    public RegisterQuestionController(final QuestionRepository questionRepository,
            final AuthorizationService authz) {
        this.questionRepository = questionRepository;
        this.authz = authz;
    }

    public Question SetUpQuestion(final QuestionType questionType, final String questionBody,
            final List<Answer> possibleAnswers) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.LANGUAGE_ENGINEER);
        return registerQuestion(questionType, questionBody, possibleAnswers);
    }

    private Question registerQuestion(final QuestionType questionType, final String questionBody,
        final List<Answer> possibleAnswers) {
        final Question question = doSetUpQuestion(questionType, questionBody, possibleAnswers);
        return questionRepository.save(question);
    }

    private Question doSetUpQuestion(final QuestionType questionType, final String questionBody,
        final List<Answer> possibleAnswers) {
        return new QuestionBuilder().with(questionType, questionBody, possibleAnswers).build();
    }
}
