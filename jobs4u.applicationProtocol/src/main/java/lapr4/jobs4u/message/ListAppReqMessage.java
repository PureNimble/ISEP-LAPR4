package lapr4.jobs4u.message;

import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import lapr4.jobs4u.EventListener;
import lapr4.jobs4u.application.ListCandidateApplicationsService;
import lapr4.jobs4u.applicationmanagement.dto.ApplicationDTO;
import lapr4.jobs4u.infrastructure.persistence.PersistenceContext;
import lapr4.jobs4u.protocol.MessageCode;
import lapr4.jobs4u.protocol.ProtocolMessage;
import lapr4.jobs4u.usermanagement.domain.BaseRoles;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 2DI2
 */
public class ListAppReqMessage extends Message {

    public ListAppReqMessage(final ProtocolMessage protocolMessage, final DataOutputStream output, final Socket socket,
                             final EventListener eventListener) {
        super(protocolMessage, output, socket, eventListener);
    }

    @Override
    public void handle() throws IOException {
        ListCandidateApplicationsService listCandidateApplicationsService = new ListCandidateApplicationsService(PersistenceContext.repositories().applications(), PersistenceContext.repositories().candidates());
        final SystemUser user = eventListener.user(socket);

        if (!user.hasAny(BaseRoles.CANDIDATE)){
            new ErrMessage(new ProtocolMessage((byte) 1, MessageCode.ERR, "Invalid Authentication"), output, socket,
                    eventListener).handle();
            return;
        }

        Iterable<ApplicationDTO> applications = listCandidateApplicationsService.findApplicationsFromCandidate(user.email());

        int size = 0;
        for (ApplicationDTO ignored : applications) {
            size++;
        }

        List<byte[]> dataChunks = new ArrayList<>();
        dataChunks.add(Integer.toString(size).getBytes());
        for (ApplicationDTO application : applications) {
            dataChunks.add(application.getApplicationCode().getBytes());
            dataChunks.add(application.getStatus().getBytes());
            dataChunks.add(listCandidateApplicationsService.numApplicants(application).toString().getBytes());
        }

        send(new ProtocolMessage((byte) 1, MessageCode.LISTAPPRES, dataChunks.toArray(new byte[dataChunks.size()][])));
    }
}
