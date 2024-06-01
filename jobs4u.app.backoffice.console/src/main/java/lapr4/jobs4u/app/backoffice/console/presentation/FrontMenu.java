package lapr4.jobs4u.app.backoffice.console.presentation;

import lapr4.jobs4u.app.common.console.presentation.authz.LoginUI;
import lapr4.jobs4u.infrastructure.authz.AuthenticationCredentialHandler;
import eapli.framework.actions.ChainedAction;
import eapli.framework.actions.menu.Menu;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.ExitWithMessageAction;
import eapli.framework.presentation.console.menu.MenuItemRenderer;
import eapli.framework.presentation.console.menu.MenuRenderer;
import eapli.framework.presentation.console.menu.VerticalMenuRenderer;

/**
 * @author 2DI2
 */
public class FrontMenu extends AbstractUI {

    private static final int EXIT_OPTION = 0;

    private static final int LOGIN_OPTION = 1;

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
        final Menu menu = new Menu();
        menu.addItem(LOGIN_OPTION, "Login",
                new ChainedAction(new LoginUI(new AuthenticationCredentialHandler())::show, () -> {
                    new MainMenu().mainLoop();
                    return false;
                }));
        menu.addItem(EXIT_OPTION, "Exit", new ExitWithMessageAction("Goodbye!"));
    
        boolean loginSuccessful;
        do {
            final MenuRenderer renderer = new VerticalMenuRenderer(menu, MenuItemRenderer.DEFAULT);
            loginSuccessful = renderer.render();
        } while (!loginSuccessful);
        return loginSuccessful;
    }
    
    @Override
    public String headline() {
        return "Jobs4U - BackOffice App";
    }
}
