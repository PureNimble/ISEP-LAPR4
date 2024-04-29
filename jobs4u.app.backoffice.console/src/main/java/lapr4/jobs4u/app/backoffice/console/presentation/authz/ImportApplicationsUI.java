package lapr4.jobs4u.app.backoffice.console.presentation.authz;

import java.util.HashSet;
import java.util.Set;

import lapr4.jobs4u.applicationmanagement.application.ImportApplicationsController;
import eapli.framework.actions.menu.Menu;
import eapli.framework.actions.menu.MenuItem;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.menu.MenuItemRenderer;
import eapli.framework.presentation.console.menu.MenuRenderer;
import eapli.framework.presentation.console.menu.VerticalMenuRenderer;

/**
 * UI for adding a user to the application.
 *
 * Created by nuno on 22/03/16.
 */
public class ImportApplicationsUI extends AbstractUI {

    private final ImportApplicationsController theController = new ImportApplicationsController();

    @Override
    protected boolean doShow() {
        // FIXME avoid duplication with SignUpUI. reuse UserDataWidget from
        // UtenteApp
        String folder;
        do {
            folder = Console.readLine("Shared Folder Path");
        } while (!Console.readLine("Do you want to import applications? (Y/N)").equalsIgnoreCase("Y"));

        // this.theController.importApplications(folder);

        return false;
    }

    @Override
    public String headline() {
        return "Import Applications";
    }
}
