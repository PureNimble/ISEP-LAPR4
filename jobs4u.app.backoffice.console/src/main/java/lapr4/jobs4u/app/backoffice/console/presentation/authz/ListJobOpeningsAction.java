package lapr4.jobs4u.app.backoffice.console.presentation.authz;

import eapli.framework.actions.Action;

public class ListJobOpeningsAction implements Action {

    @Override
    public boolean execute() {
        return new ListJobOpeningsUI().show();
    }
}
