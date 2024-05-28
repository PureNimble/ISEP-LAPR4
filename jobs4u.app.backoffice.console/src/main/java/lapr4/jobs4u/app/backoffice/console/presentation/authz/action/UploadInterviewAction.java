package lapr4.jobs4u.app.backoffice.console.presentation.authz.action;

import eapli.framework.actions.Action;
import lapr4.jobs4u.app.backoffice.console.presentation.authz.UploadInterviewUI;

/**
 * @author 2DI2
 */
public class UploadInterviewAction implements Action {
    @Override
    public boolean execute() {
        return new UploadInterviewUI().show();
    }
}
