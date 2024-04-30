package lapr4.jobs4u.app.backoffice.console.presentation.authz;

import eapli.framework.actions.Action;

public class RegisterCustomerAction implements Action{
    @Override
    public boolean execute() {
        return new RegisterCustomerUI().show();
    }
}
