package lapr4.jobs4u.app.backoffice.console.presentation.authz.action;

import eapli.framework.actions.Action;
import lapr4.jobs4u.app.backoffice.console.presentation.authz.RegisterJobOpeningUI;

public class RegisterJobOpeningAction implements Action {
    @Override
    public boolean execute() {
        return new RegisterJobOpeningUI().show();
    }
}
