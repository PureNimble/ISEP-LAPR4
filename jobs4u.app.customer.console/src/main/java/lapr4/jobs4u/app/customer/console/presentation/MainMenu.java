package lapr4.jobs4u.app.customer.console.presentation;

import lapr4.jobs4u.Application;
import lapr4.jobs4u.app.common.ChangePasswordAction;
import lapr4.jobs4u.app.common.ClientBackend;
import lapr4.jobs4u.app.common.LogoutAction;
import eapli.framework.actions.Actions;
import eapli.framework.actions.ChainedAction;
import eapli.framework.actions.menu.Menu;
import eapli.framework.actions.menu.MenuItem;
import eapli.framework.presentation.console.menu.HorizontalMenuRenderer;
import eapli.framework.presentation.console.menu.MenuItemRenderer;
import eapli.framework.presentation.console.menu.MenuRenderer;
import eapli.framework.presentation.console.menu.VerticalMenuRenderer;
import lapr4.jobs4u.app.customer.console.presentation.authz.action.ListJobOpeningsAction;

/**
 * @author 2DI2
 */
class MainMenu extends CustomerUI {

    private static final String SEPARATOR_LABEL = "--------------";
    private static final String RETURN_LABEL = "Return ";
    private static final int EXIT_OPTION = 0;
    private static final int MENU_OPTION = 0;
    private static final int CHANGE_PASSWORD_OPTION = 1;
    private static final int LOGOUT_OPTION = 2;
    private static final int LIST_JOB_REQ = 1;
    private Menu mainMenu;
    private final ClientBackend backend = ClientBackend.getInstance();

    @Override
    public boolean show() {
        drawFormTitle();
        return doShow();
    }

    /**
     * @return true if the user selected the exit option
     */
    @Override
    public boolean doShow() {
        final boolean show = buildMainMenu();
        if (show) {
            final MenuRenderer renderer;
            if (Application.settings().isMenuLayoutHorizontal()) {
                renderer = new HorizontalMenuRenderer(mainMenu, MenuItemRenderer.DEFAULT);
            } else {
                renderer = new VerticalMenuRenderer(mainMenu, MenuItemRenderer.DEFAULT);
            }
            return renderer.render();
        }
        return true;
    }

    private boolean buildMainMenu() {
        if (backend.credentialAuth().email() == null)
            return false;
        mainMenu = new Menu();
        final Menu usersMenu = optionsMenu();
        mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));
        mainMenu.addItem(LIST_JOB_REQ, "List my JobOpenings", new ListJobOpeningsAction());
        mainMenu.addSubMenu(MENU_OPTION, usersMenu);

        return true;
    }

    private Menu optionsMenu() {
        final Menu optionsMenu = new Menu("Options Menu");
        optionsMenu.addItem(CHANGE_PASSWORD_OPTION, "Change Password", new ChangePasswordAction());
        optionsMenu.addItem(LOGOUT_OPTION, "Logout", new ChainedAction(new LogoutAction(), new FrontMenu()::show));
        optionsMenu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);
        return optionsMenu;
    }
}
