package lapr4.jobs4u.app.common;

import java.io.IOException;

import eapli.framework.actions.Action;

/**
 * @author 2DI2
 */
public class DisconnectAction implements Action {

    @Override
    public boolean execute() {
        try {
            ClientBackend.getInstance().disconnect();
            return true;
        } catch (final IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

}
