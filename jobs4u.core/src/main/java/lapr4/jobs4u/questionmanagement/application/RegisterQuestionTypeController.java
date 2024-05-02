package lapr4.jobs4u.questionmanagement.application;

import eapli.framework.infrastructure.authz.application.AuthorizationService;
import lapr4.jobs4u.questionmanagement.domain.QuestionType;
import lapr4.jobs4u.questionmanagement.repositories.QuestionTypeRepository;
import lapr4.jobs4u.usermanagement.domain.BaseRoles;

public class RegisterQuestionTypeController {

    private final AuthorizationService authz;
    private final QuestionTypeRepository repository;

    public RegisterQuestionTypeController(final AuthorizationService authz, final QuestionTypeRepository repository) {
        // dependency injection - to make this object more testable we don't create the
        // infrastructure objects to avoid coupling to the implementation. This way, the controller
        // can be used in different scenarios with different implementations of the repository. for
        // instance, unit testing.
        this.authz = authz;
        this.repository = repository;
    }

    public QuestionType registerDishType(final String type) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.LANGUAGE_ENGINEER);
        final QuestionType newQuestionType = new QuestionType(type);
        return repository.save(newQuestionType);
    }
}