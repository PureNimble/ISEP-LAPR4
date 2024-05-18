package lapr4.jobs4u.message;

import java.io.DataOutputStream;
import java.net.Socket;

import lapr4.jobs4u.EventListener;
import lapr4.jobs4u.protocol.ProtocolMessage;

public class AckMessage extends Message {

  public AckMessage(ProtocolMessage protocolMessage, DataOutputStream output, Socket socket,
      EventListener eventListener) {
    super(protocolMessage, output, socket, eventListener);
  }

  @Override
  public void handle() {}
}
