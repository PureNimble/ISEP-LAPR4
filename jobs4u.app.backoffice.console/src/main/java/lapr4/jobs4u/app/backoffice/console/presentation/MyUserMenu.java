package lapr4.jobs4u.app.backoffice.console.presentation;

import lapr4.jobs4u.app.common.console.presentation.authz.ChangePasswordUI;
import lapr4.jobs4u.app.common.console.presentation.authz.LoginUI;
import lapr4.jobs4u.app.common.console.presentation.authz.LogoutUI;
import lapr4.jobs4u.infrastructure.authz.AuthenticationCredentialHandler;
import eapli.framework.actions.Actions;
import eapli.framework.actions.ChainedAction;
import eapli.framework.actions.menu.Menu;
import eapli.framework.actions.menu.MenuItem;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.Role;

/**
 * @author 2DI2
 */
public class MyUserMenu extends Menu {

    private static final String MENU_TITLE = "My account >";

    private static final int EXIT_OPTION = 0;

    // MY USER
    private static final int CHANGE_PASSWORD_OPTION = 1;
    private static final int LOGOUT_OPTION = 2;
    private static final int LOGIN_OPTION = 1;
    
    private final AuthorizationService authz = AuthzRegistry.authorizationService();

    public MyUserMenu() {
        super(MENU_TITLE);
        buildMyUserMenu(null);
    }

    public MyUserMenu(final Role onlyWithThis) {
        super(MENU_TITLE);
        buildMyUserMenu(onlyWithThis);
    }

    private void buildMyUserMenu(final Role onlyWithThis) {
        if (authz.hasSession()) {
            addItem(CHANGE_PASSWORD_OPTION, "Change password", new ChangePasswordUI()::show);
            addItem(LOGOUT_OPTION, "Logout", new LogoutUI()::show);
        } else {
            addItem(LOGIN_OPTION, "Login",
                    new LoginUI(new AuthenticationCredentialHandler(), onlyWithThis)::show);
        }

        addItem(MenuItem.of(EXIT_OPTION, "Return ", Actions.SUCCESS));
    }
}
