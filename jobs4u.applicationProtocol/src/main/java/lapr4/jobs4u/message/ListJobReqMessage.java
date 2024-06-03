package lapr4.jobs4u.message;

import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import lapr4.jobs4u.EventListener;
import lapr4.jobs4u.application.ListJobOpeningsService;
import lapr4.jobs4u.infrastructure.persistence.PersistenceContext;
import lapr4.jobs4u.jobopeningmanagement.dto.JobOpeningDTO;
import lapr4.jobs4u.protocol.MessageCode;
import lapr4.jobs4u.protocol.ProtocolMessage;
import lapr4.jobs4u.usermanagement.domain.BaseRoles;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

/**
 * @author 2DI2
 */
public class ListJobReqMessage extends Message {

    public ListJobReqMessage(final ProtocolMessage protocolMessage, final DataOutputStream output, final Socket socket,
            final EventListener eventListener) {
        super(protocolMessage, output, socket, eventListener);
    }

    @Override
    public void handle() throws IOException {

        final ListJobOpeningsService listJobOpeningsService = new ListJobOpeningsService(
                PersistenceContext.repositories().jobOpenings(), PersistenceContext.repositories().customers(),
                PersistenceContext.repositories().applications());

        final Optional<SystemUser> userOpt = eventListener.user(socket);
        if (userOpt.isEmpty()) {
            new ErrMessage(new ProtocolMessage((byte) 1, MessageCode.ERR, "Something went wrong"), output, socket,
                    eventListener).handle();
            return;
        }
        final SystemUser user = userOpt.get();

        if (!user.hasAny(BaseRoles.CUSTOMER)) {
            new ErrMessage(new ProtocolMessage((byte) 1, MessageCode.ERR, "Invalid Authentication"), output, socket,
                    eventListener).handle();
            return;
        }

        final Iterable<JobOpeningDTO> jobOpenings = listJobOpeningsService
                .findJobOpeningsFromCustomer(user.email());

        final int size = (int) StreamSupport.stream(jobOpenings.spliterator(), false).count();

        List<String> data = new ArrayList<>();
        data.add(Integer.toString(size));
        for (final JobOpeningDTO jobOpeningDTO : jobOpenings) {
            data.add(jobOpeningDTO.getJobReference());
            data.add(jobOpeningDTO.getTitleOrFunction());
            data.add(jobOpeningDTO.getActiveSince());
            data.add(listJobOpeningsService.numApplicants(jobOpeningDTO).toString());
        }

        send(new ProtocolMessage((byte) 1, MessageCode.LISTJOBRES, data.toArray(new String[0])));
    }
}
