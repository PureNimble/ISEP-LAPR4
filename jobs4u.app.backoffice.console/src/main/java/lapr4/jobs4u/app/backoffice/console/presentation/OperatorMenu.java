package lapr4.jobs4u.app.backoffice.console.presentation;

import eapli.framework.actions.Actions;
import eapli.framework.actions.menu.Menu;
import lapr4.jobs4u.app.backoffice.console.presentation.authz.action.*;

/**
 * @author 2DI2
 */
public class OperatorMenu extends Menu {

    private static final int REGISTER_CANDIDATE = 1;
    private static final int LIST_CANDIDATES = 2;
    private static final int IMPORT_APPLICATIONS_OPTION = 3;
    private static final int GENERATE_REQUIREMENT = 4;
    private static final int ENABLE_DISABLE_CANDIDATE = 5;
    private static final int UPLOAD_REQUIREMENTS = 6;
    private static final int EXIT_OPTION = 0;
    private static final String RETURN_LABEL = "Return ";

    public OperatorMenu() {
        super("Operator Menu >");

        addItem(REGISTER_CANDIDATE, "Register Candidate", new RegisterCandidateAction());
        addItem(LIST_CANDIDATES, "List Candidates", new ListCandidatesAction());
        addItem(IMPORT_APPLICATIONS_OPTION, "Import Applications", new ImportApplicationsAction());
        addItem(GENERATE_REQUIREMENT, "Generate Requirement Template", new ExportRequirementAction());
        addItem(ENABLE_DISABLE_CANDIDATE, "Enable/Disable Candidate", new EnableOrDisableCandidateUserAction());
        addItem(UPLOAD_REQUIREMENTS, "Upload Requirements", new UploadRequirementAction());
        addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);
    }
}
