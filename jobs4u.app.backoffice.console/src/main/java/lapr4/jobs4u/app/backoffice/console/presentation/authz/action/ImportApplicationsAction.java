
package lapr4.jobs4u.app.backoffice.console.presentation.authz.action;

import eapli.framework.actions.Action;
import lapr4.jobs4u.app.backoffice.console.presentation.authz.ImportApplicationsUI;

/**
 *
 * @author Fernando
 */
public class ImportApplicationsAction implements Action {

    @Override
    public boolean execute() {
        return new ImportApplicationsUI().show();
    }
}
