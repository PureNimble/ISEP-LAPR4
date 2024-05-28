package lapr4.jobs4u.app.common.console.presentation.authz;

import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.presentation.console.AbstractUI;

/**
 * @author 2DI2
 */
public class LogoutUI extends AbstractUI {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();

    @Override
    public String headline() {
        return "Logout sucessful!!\n Make a new Login";
    }

    @Override
    protected boolean doShow() {
        authz.clearSession();
        return true;
    }
}
