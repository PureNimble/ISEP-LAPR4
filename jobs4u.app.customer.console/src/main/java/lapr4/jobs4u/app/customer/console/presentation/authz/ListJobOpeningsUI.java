package lapr4.jobs4u.app.customer.console.presentation.authz;

import eapli.framework.presentation.console.AbstractUI;
import lapr4.jobs4u.app.common.ClientBackend;
import lapr4.jobs4u.protocol.MessageCode;
import lapr4.jobs4u.protocol.ProtocolMessage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author 2DI2
 */
public class ListJobOpeningsUI extends AbstractUI {

    private final Logger LOGGER = LogManager.getLogger(ListJobOpeningsUI.class);

    @Override
    public String headline() {
        return "My Applications";
    }

    @Override
    protected boolean doShow() {
        final ClientBackend client = ClientBackend.getInstance();
        final ProtocolMessage response;
        try {
            response = client.listener().sendRecv(new ProtocolMessage((byte) 1, MessageCode.LISTJOBREQ));
            if (response.code() == MessageCode.LISTJOBRES) {
                LOGGER.info("Received response from server: " + response.toString());
                String numJobOpenings = new String(response.datachunks()[0], StandardCharsets.US_ASCII);
                System.out.println("Number of Job Openings: " + numJobOpenings);
                System.out.printf("#  %-30s%-20s%-10s%-5s\n", "JOB REF.", "POSITION", "ACTIVE SINCE", "Nº APPLICANTS");
                for (int i = 1; i < response.datachunks().length; i += 4) {
                    final String jobRef = new String(response.datachunks()[i], StandardCharsets.US_ASCII);
                    final String position = new String(response.datachunks()[i + 1], StandardCharsets.US_ASCII);
                    final String activeSince = new String(response.datachunks()[i + 2], StandardCharsets.US_ASCII);
                    final String nApplicants = new String(response.datachunks()[i + 3], StandardCharsets.US_ASCII);
                    System.out.printf("#  %-30s%-20s%-10s%-5s\n", jobRef, position, activeSince, nApplicants);
                }
            }
        } catch (final ClassNotFoundException | IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return false;
    }
}
