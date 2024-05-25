package lapr4.jobs4u.integration.questions.importer.application;

import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import lapr4.jobs4u.integration.questions.importer.domain.PluginType;
import lapr4.jobs4u.integration.questions.importer.domain.QuestionImporterPlugin;
import lapr4.jobs4u.integration.questions.importer.repositories.QuestionImporterPluginRepository;
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
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER, BaseRoles.POWERUSER, BaseRoles.OPERATOR);
        return listQuestionPluginService.filterByType(PluginType.valueOf(plugin));
    }
}