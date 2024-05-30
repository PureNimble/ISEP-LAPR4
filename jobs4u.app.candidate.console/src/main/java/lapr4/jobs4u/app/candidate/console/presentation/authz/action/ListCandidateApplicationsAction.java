package lapr4.jobs4u.app.candidate.console.presentation.authz.action;

import eapli.framework.actions.Action;
import lapr4.jobs4u.app.candidate.console.presentation.authz.ListCandidateApplicationsUI;

/**
 * @author 2DI2
 */
public class ListCandidateApplicationsAction implements Action {

    @Override
    public boolean execute() {
        return new ListCandidateApplicationsUI().show();
    }
}
