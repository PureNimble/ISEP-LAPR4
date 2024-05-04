package lapr4.jobs4u.integration.questions.import_.application;

import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import lapr4.jobs4u.integration.questions.import_.domain.PluginType;
import lapr4.jobs4u.integration.questions.import_.domain.QuestionImporterPlugin;
import lapr4.jobs4u.integration.questions.import_.repositories.QuestionImporterPluginRepository;
import lapr4.jobs4u.usermanagement.domain.BaseRoles;

@UseCaseController
public class ListQuestionPluginController  {

    private final ListQuestionPluginService listQuestionPluginService;
    private final AuthorizationService authz;

    public ListQuestionPluginController(QuestionImporterPluginRepository questionImporterPluginRepository, AuthorizationService authz) {
        this.listQuestionPluginService = new ListQuestionPluginService(questionImporterPluginRepository);
        this.authz = authz;
    }

    public Iterable<QuestionImporterPlugin> filterByType(final String plugin) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER, BaseRoles.LANGUAGE_ENGINEER, BaseRoles.POWERUSER);
        return listQuestionPluginService.filterByType(PluginType.valueOf(plugin));
    }
}
