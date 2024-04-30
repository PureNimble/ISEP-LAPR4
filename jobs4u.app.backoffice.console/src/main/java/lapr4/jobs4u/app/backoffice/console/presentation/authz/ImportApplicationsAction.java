
package lapr4.jobs4u.app.backoffice.console.presentation.authz;

import eapli.framework.actions.Action;

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
