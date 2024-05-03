package lapr4.jobs4u.app.backoffice.console.presentation;

import eapli.framework.actions.Actions;
import eapli.framework.actions.menu.Menu;
import lapr4.jobs4u.app.backoffice.console.presentation.authz.action.ImportApplicationsAction;
import lapr4.jobs4u.app.backoffice.console.presentation.authz.action.ListCandidatesAction;
import lapr4.jobs4u.app.backoffice.console.presentation.authz.action.RegisterCandidateAction;

public class OperatorMenu extends Menu {

    private static final int REGISTER_CANDIDATE = 1;
    private static final int LIST_CANDIDATES = 2;
    private static final int IMPORT_APPLICATIONS_OPTION = 3;
    private static final int EXIT_OPTION = 0;
    private static final String RETURN_LABEL = "Return ";

    public OperatorMenu() {
        super("Candidate >");

        addItem(REGISTER_CANDIDATE, "Register Candidate", new RegisterCandidateAction());
        addItem(LIST_CANDIDATES, "List Candidates", new ListCandidatesAction());
        addItem(IMPORT_APPLICATIONS_OPTION, "Import Applications", new ImportApplicationsAction());
        addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);
    }
}
