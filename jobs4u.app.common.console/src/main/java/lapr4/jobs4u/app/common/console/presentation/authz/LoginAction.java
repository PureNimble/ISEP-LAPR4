package lapr4.jobs4u.app.common.console.presentation.authz;

import lapr4.jobs4u.infrastructure.authz.AuthenticationCredentialHandler;
import eapli.framework.actions.Action;
import eapli.framework.infrastructure.authz.domain.model.Role;

/**
 * @author 2DI2
 */
public class LoginAction implements Action {

    private final Role onlyWithThis;

    public LoginAction() {
        onlyWithThis = null;
    }

    /**
     *
     * @param onlyWithThis
     *            only if the user has this specific action right will be
     *            allowed to login
     */
    public LoginAction(final Role onlyWithThis) {
        this.onlyWithThis = onlyWithThis;
    }

    @Override
    public boolean execute() {
        return new LoginUI(new AuthenticationCredentialHandler(), onlyWithThis).show();
    }
}
