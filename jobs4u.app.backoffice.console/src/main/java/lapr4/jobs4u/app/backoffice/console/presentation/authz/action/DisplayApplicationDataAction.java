package lapr4.jobs4u.app.backoffice.console.presentation.authz.action;

import eapli.framework.actions.Action;
import lapr4.jobs4u.app.backoffice.console.presentation.authz.DisplayApplicationDataUI;

/**
 * @author 2DI2
 */
public class DisplayApplicationDataAction implements Action {

    @Override
    public boolean execute() {
        return new DisplayApplicationDataUI().show();
    }
}
