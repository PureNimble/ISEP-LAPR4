package lapr4.jobs4u.app.backoffice.console.presentation;

import lapr4.jobs4u.Application;
import lapr4.jobs4u.app.common.console.presentation.authz.MyUserMenu;
import lapr4.jobs4u.usermanagement.domain.BaseRoles;
import eapli.framework.actions.menu.Menu;
import eapli.framework.actions.menu.MenuItem;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.ExitWithMessageAction;
import eapli.framework.presentation.console.menu.HorizontalMenuRenderer;
import eapli.framework.presentation.console.menu.MenuItemRenderer;
import eapli.framework.presentation.console.menu.MenuRenderer;
import eapli.framework.presentation.console.menu.VerticalMenuRenderer;

/**
 * @author 2DI2
 */
public class MainMenu extends AbstractUI {

    // MAIN MENU
    private static final int MY_USER_OPTION = 1;
    private static final int USERS_OPTION = 2;
    private static final int ADMIN_OPTION = 2;
    private static final int CUSTOMER_MANAGER_OPTION = 3;
    private static final int OPERATOR_OPTION = 4;
    private static final int LANGUAGE_ENGINEER_OPTION = 5;
    private static final int EXIT_OPTION = 0;
    private static final String SEPARATOR_LABEL = "--------------";
    private final AuthorizationService authz = AuthzRegistry.authorizationService();

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
        final MenuRenderer renderer;
        if (Application.settings().isMenuLayoutHorizontal()) {
            renderer = new HorizontalMenuRenderer(menu, MenuItemRenderer.DEFAULT);
        } else {
            renderer = new VerticalMenuRenderer(menu, MenuItemRenderer.DEFAULT);
        }
        return renderer.render();
    }

    @Override
    public String headline() {

        return authz.session().map(s -> "BackOffice App [ @" + s.authenticatedUser().identity() + " ]")
                .orElse("Backoffice App [ ==Anonymous== ]");
    }

    private Menu buildMainMenu() {
        final Menu mainMenu = new Menu();

        if (authz.isAuthenticatedUserAuthorizedTo(BaseRoles.ADMIN, BaseRoles.CUSTOMER_MANAGER, BaseRoles.OPERATOR,
                BaseRoles.LANGUAGE_ENGINEER, BaseRoles.POWERUSER)) {

            final Menu myUserMenu = new MyUserMenu();
            mainMenu.addSubMenu(MY_USER_OPTION, myUserMenu);

            if (!Application.settings().isMenuLayoutHorizontal()) {
                mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));
            }

            if (authz.isAuthenticatedUserAuthorizedTo(BaseRoles.ADMIN)) {
                final AdminMenu usersMenu = new AdminMenu();
                mainMenu.addSubMenu(USERS_OPTION, usersMenu);
            }

            if (authz.isAuthenticatedUserAuthorizedTo(BaseRoles.CUSTOMER_MANAGER)) {
                final Menu usersMenu = new CustomerManagerMenu();
                mainMenu.addSubMenu(USERS_OPTION, usersMenu);
            }

            if (authz.isAuthenticatedUserAuthorizedTo(BaseRoles.OPERATOR)) {
                final Menu usersMenu = new OperatorMenu();
                mainMenu.addSubMenu(USERS_OPTION, usersMenu);
            }

            if (authz.isAuthenticatedUserAuthorizedTo(BaseRoles.LANGUAGE_ENGINEER)) {
                final Menu usersMenu = new LanguageEngineerMenu();
                mainMenu.addSubMenu(USERS_OPTION, usersMenu);
            }

            if (authz.isAuthenticatedUserAuthorizedTo(BaseRoles.POWERUSER)) {
                mainMenu.addSubMenu(ADMIN_OPTION, new AdminMenu());
                mainMenu.addSubMenu(CUSTOMER_MANAGER_OPTION, new CustomerManagerMenu());
                mainMenu.addSubMenu(OPERATOR_OPTION, new OperatorMenu());
                mainMenu.addSubMenu(LANGUAGE_ENGINEER_OPTION, new LanguageEngineerMenu());
            }

            if (!Application.settings().isMenuLayoutHorizontal()) {
                mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));
            }

        } else {
            System.out.println(
                    "You don't have permission to access this Application. Please contact the Administrator.\n");
        }
        mainMenu.addItem(EXIT_OPTION, "Exit", new ExitWithMessageAction(""));
        return mainMenu;
    }

}
