package lapr4.jobs4u.app.common;

import java.io.IOException;

import eapli.framework.actions.Action;
import eapli.framework.io.util.Console;
import lapr4.jobs4u.protocol.MessageCode;
import lapr4.jobs4u.protocol.ProtocolMessage;

/**
 * @author 2DI2
 */
public class ChangePasswordAction implements Action {

    @Override
    public boolean execute() {
        try {
            final String oldPassword = Console.readLine("Old Password:");
            final String newPassword = Console.readLine("New Password:");
            final ClientBackend client = ClientBackend.getInstance();
            final ProtocolMessage response = client.listener()
                    .sendRecv(new ProtocolMessage((byte) 1, MessageCode.CHANGEPASS, oldPassword, newPassword));
            System.out.println(response.toString());
            if (response.code() == MessageCode.ACK)
                System.out.println("Password changed successfully");
            return true;
        } catch (final IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }
}
