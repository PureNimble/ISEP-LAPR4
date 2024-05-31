package lapr4.jobs4u.app.candidate.console.presentation.authz;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import eapli.framework.presentation.console.AbstractUI;
import lapr4.jobs4u.app.common.ClientBackend;
import lapr4.jobs4u.protocol.MessageCode;
import lapr4.jobs4u.protocol.ProtocolMessage;

/**
 * @author 2DI2
 */
public class ListCandidateApplicationsUI extends AbstractUI {

    private final Logger LOGGER = LogManager.getLogger(ListCandidateApplicationsUI.class);

    @Override
    public String headline() {
        return "My Applications";
    }

    @Override
    protected boolean doShow() {
        final ClientBackend client = ClientBackend.getInstance();
        final ProtocolMessage response;
        try {
            response = client.listener().sendRecv(new ProtocolMessage((byte) 1, MessageCode.LISTAPPREQ));
            if (response.code() == MessageCode.LISTAPPRES) {
                LOGGER.info("Received response from server: " + response.toString());
                final String numApplications = new String(response.datachunks()[0], StandardCharsets.US_ASCII);
                System.out.println("Number of Applications: " + numApplications);
                System.out.printf("#  %-20s%-10s%-5s\n", "APP. CODE", "STATUS", "NUM. APPLICANTS");
                int line = 1;
                for (int i = 1; i < response.datachunks().length; i += 3) {
                    final String appCode = new String(response.datachunks()[i], StandardCharsets.US_ASCII);
                    final String status = new String(response.datachunks()[i + 1], StandardCharsets.US_ASCII);
                    final String numApplicants = new String(response.datachunks()[i + 2], StandardCharsets.US_ASCII);
                    System.out.printf("%d  %-20s%-10s%-5s\n", line, appCode, status, numApplicants);
                    line++;
                }
            }
        } catch (final ClassNotFoundException | IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return false;
    }
}
