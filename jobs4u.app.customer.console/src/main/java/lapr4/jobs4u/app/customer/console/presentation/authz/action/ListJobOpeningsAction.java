package lapr4.jobs4u.app.customer.console.presentation.authz.action;

import eapli.framework.actions.Action;
import lapr4.jobs4u.app.customer.console.presentation.authz.ListJobOpeningsUI;

/**
 * @author 2DI2
 */
public class ListJobOpeningsAction implements Action {

    @Override
    public boolean execute() {
        return new ListJobOpeningsUI().show();
    }
}
