package lapr4.jobs4u.integration.questions.exporter.application;

import java.io.IOException;

import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import lapr4.jobs4u.infrastructure.persistence.PersistenceContext;
import lapr4.jobs4u.questionmanagement.application.ListQuestionsService;
import lapr4.jobs4u.questionmanagement.domain.InterviewQuestion;
import lapr4.jobs4u.questionmanagement.domain.RequirementsQuestion;
import lapr4.jobs4u.usermanagement.domain.BaseRoles;

/**
 * @author 2DI2
 */
public class QuestionExporterController {

    private final ListQuestionsService listSvc = new ListQuestionsService(PersistenceContext.repositories().interviewQuestion(), PersistenceContext.repositories().requirementsQuestion());
    private final QuestionExporterBuilder builder = new QuestionExporterBuilder();
    private final QuestionExporterService exportSvc = new QuestionExporterService();
    private final AuthorizationService authz = AuthzRegistry.authorizationService();

    public void exportInterview(final String filename, final FileFormat format, final String plugin) throws IOException {
        final QuestionExporter exporter = builder.build(format);
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.POWERUSER, BaseRoles.CUSTOMER_MANAGER, BaseRoles.OPERATOR);

        // Note that we are fetching all the data from the database. This of course will only work
        // for a small amount of data. To export a large volume of data we should be using some kind
        // of cursor-based iterable and not a pure in-memory collection.
        final Iterable<InterviewQuestion> questions = listSvc.findInterviewQuestionsByPlugin(plugin);
        exportSvc.exportInterviewQuestion(questions, filename, exporter, plugin);
    }

    public void exportRequirements(final String filename, final FileFormat format, final String plugin) throws IOException {
        final QuestionExporter exporter = builder.build(format);
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.POWERUSER, BaseRoles.CUSTOMER_MANAGER, BaseRoles.OPERATOR);

        // Note that we are fetching all the data from the database. This of course will only work
        // for a small amount of data. To export a large volume of data we should be using some kind
        // of cursor-based iterable and not a pure in-memory collection.
        final Iterable<RequirementsQuestion> questions = listSvc.findRequirementsQuestionsByPlugin(plugin);
        exportSvc.exportRequirementsQuestion(questions, filename, exporter, plugin);
    }
}