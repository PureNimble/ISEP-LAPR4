package lapr4.jobs4u.app.backoffice.console.presentation;

import eapli.framework.actions.Actions;
import eapli.framework.actions.menu.Menu;
import lapr4.jobs4u.app.backoffice.console.presentation.authz.action.AddBackofficeUserAction;
import lapr4.jobs4u.app.backoffice.console.presentation.authz.action.EnableOrDisableBackofficeUserAction;
import lapr4.jobs4u.app.backoffice.console.presentation.authz.action.ListBackofficeUsersAction;

/**
 * @author 2DI2
 */
public class AdminMenu  extends Menu {

    private static final int ADD_USER_OPTION = 1;
    private static final int LIST_USERS_OPTION = 2;
    private static final int ENABLE_DISABLE_USER_OPTION = 3;
    private static final String RETURN_LABEL = "Return ";
    private static final int EXIT_OPTION = 0;

    public AdminMenu() {
        super("Admin Menu >");

        addItem(ADD_USER_OPTION, "Add User", new AddBackofficeUserAction());
        addItem(LIST_USERS_OPTION, "List all Users", new ListBackofficeUsersAction());
        addItem(ENABLE_DISABLE_USER_OPTION, "Enable/Disable User", new EnableOrDisableBackofficeUserAction());
        addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);
    }

    
}
