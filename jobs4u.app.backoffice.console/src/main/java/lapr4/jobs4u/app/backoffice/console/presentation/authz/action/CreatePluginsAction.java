package lapr4.jobs4u.app.backoffice.console.presentation.authz.action;

import eapli.framework.actions.Action;
import lapr4.jobs4u.app.backoffice.console.presentation.authz.CreatePluginsUI;

public class CreatePluginsAction implements Action {

    @Override
    public boolean execute() {
        return new CreatePluginsUI().show();
    }
}