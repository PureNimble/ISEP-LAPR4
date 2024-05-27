package lapr4.jobs4u.app.customer.console.presentation;

import lapr4.jobs4u.app.common.ChangePasswordAction;
import lapr4.jobs4u.app.common.LogoutAction;
import eapli.framework.actions.Actions;
import eapli.framework.actions.ChainedAction;
import eapli.framework.actions.menu.Menu;
import eapli.framework.actions.menu.MenuItem;
import eapli.framework.presentation.console.menu.MenuItemRenderer;
import eapli.framework.presentation.console.menu.MenuRenderer;
import eapli.framework.presentation.console.menu.VerticalMenuRenderer;

/**
 * @author 2DI2
 */
class MainMenu extends CustomerUI {

    private static final String SEPARATOR_LABEL = "--------------";
    private static final String RETURN_LABEL = "Return ";
    private static final int EXIT_OPTION = 0;
    private static final int MENU_OPTION = 1;
    private static final int CHANGE_PASSWORD_OPTION = 1;
    private static final int LOGOUT_OPTION = 2;

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
        final Menu menu = buildMainMenu();
        final MenuRenderer renderer = new VerticalMenuRenderer(menu, MenuItemRenderer.DEFAULT);
        return renderer.render();
    }

    private Menu buildMainMenu() {
        final Menu mainMenu = new Menu();
        final Menu usersMenu = optionsMenu();
        mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));
        mainMenu.addSubMenu(MENU_OPTION, usersMenu);

        return mainMenu;
    }

    private Menu optionsMenu() {
        final Menu optionsMenu = new Menu("Options Menu");
        optionsMenu.addItem(CHANGE_PASSWORD_OPTION, "Change Password", new ChangePasswordAction());
        optionsMenu.addItem(LOGOUT_OPTION, "Logout", new ChainedAction(new LogoutAction(), new FrontMenu()::show));
        optionsMenu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);
        return optionsMenu;
    }
}
