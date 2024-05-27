package lapr4.jobs4u.app.common;

import java.io.IOException;

import eapli.framework.actions.Action;
import lapr4.jobs4u.protocol.MessageCode;
import lapr4.jobs4u.protocol.ProtocolMessage;

/**
 * @author 2DI2
 */
public class LogoutAction implements Action {

    @Override
    public boolean execute() {
        try {
            final ClientBackend client = ClientBackend.getInstance();
            final ProtocolMessage response = client.listener()
                    .sendRecv(new ProtocolMessage((byte) 1, MessageCode.LOGOUT));
            System.out.println(response.toString());
            client.credentialAuth().clear();
            return true;
        } catch (final IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }
}
