package lapr4.jobs4u.app.backoffice.console.presentation.authz.action;

import eapli.framework.actions.Action;
import lapr4.jobs4u.app.backoffice.console.presentation.authz.OpenOrClosePhaseUI;

public class OpenOrClosePhaseAction implements Action {

    @Override
    public boolean execute() {
        return new OpenOrClosePhaseUI().show();
    }
}

