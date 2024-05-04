package lapr4.jobs4u.app.backoffice.console.presentation.authz.action;

import eapli.framework.actions.Action;
import lapr4.jobs4u.app.backoffice.console.presentation.authz.SelectRequirementUI;

public class SelectRequirementAction implements Action {
    @Override
    public boolean execute() {
        return new SelectRequirementUI().show();
    }
}
