package lapr4.jobs4u.integration.questions.export.application;

import java.io.IOException;

import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import lapr4.jobs4u.infrastructure.persistence.PersistenceContext;
import lapr4.jobs4u.questionmanagement.application.ListQuestionsService;
import lapr4.jobs4u.questionmanagement.domain.Question;
import lapr4.jobs4u.usermanagement.domain.BaseRoles;

public class QuestionExporterController {

    private final ListQuestionsService listSvc = new ListQuestionsService(PersistenceContext.repositories().question());
    private final QuestionExporterBuilder builder = new QuestionExporterBuilder();
    private final QuestionExporterService exportSvc = new QuestionExporterService();
    private final AuthorizationService authz = AuthzRegistry.authorizationService();

    public void export(final String filename, final FileFormat format, final String plugin) throws IOException {
        final QuestionExporter exporter = builder.build(format);
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.POWERUSER, BaseRoles.CUSTOMER_MANAGER, BaseRoles.LANGUAGE_ENGINEER);

        // Note that we are fetching all the data from the database. This of course will only work
        // for a small amount of data. To export a large volume of data we should be using some kind
        // of cursor-based iterable and not a pure in-memory collection.
        final Iterable<Question> questions = listSvc.findQuestionsByPlugin(plugin);
        exportSvc.export(questions, filename, exporter);
    }
}