package lapr4.jobs4u.app.backoffice.console.presentation.authz.action;

import eapli.framework.actions.Action;
import lapr4.jobs4u.app.backoffice.console.presentation.authz.EditJobOpeningUI;

public class EditJobOpeningAction implements Action {

    @Override
    public boolean execute() {
        return new EditJobOpeningUI().show();
    }
}
