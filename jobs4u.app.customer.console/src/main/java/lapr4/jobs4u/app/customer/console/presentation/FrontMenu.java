package lapr4.jobs4u.app.customer.console.presentation;

import lapr4.jobs4u.app.common.ClientBackend;
import lapr4.jobs4u.app.common.DisconnectAction;
import lapr4.jobs4u.app.common.console.presentation.authz.LoginUI;
import lapr4.jobs4u.usermanagement.domain.BaseRoles;
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
        final ClientBackend clientBackend = ClientBackend.getInstance();
        menu.addItem(LOGIN_OPTION, "Login", new ChainedAction(new LoginUI(clientBackend.credentialAuth().AUTHENTICATE,
                BaseRoles.CANDIDATE)::show, () -> {
                    new MainMenu().mainLoop();
                    return true;
                }));
        menu.addItem(EXIT_OPTION, "Exit",
                new ChainedAction(new DisconnectAction(), new ExitWithMessageAction("Goodbye!")));

        final MenuRenderer renderer = new VerticalMenuRenderer(menu, MenuItemRenderer.DEFAULT);
        return renderer.render();
    }

    @Override
    public String headline() {
        return "Jobs4U - Customer App";
    }
}
