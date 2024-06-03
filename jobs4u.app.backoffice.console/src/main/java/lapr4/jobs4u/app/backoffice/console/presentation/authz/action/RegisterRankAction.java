package lapr4.jobs4u.app.backoffice.console.presentation.authz.action;

import eapli.framework.actions.Action;
import lapr4.jobs4u.app.backoffice.console.presentation.authz.RegisterRankUI;

/**
 * @author 2DI2
 */
public class RegisterRankAction implements Action {
    @Override
    public boolean execute() {
        return new RegisterRankUI().show();
    }
}
