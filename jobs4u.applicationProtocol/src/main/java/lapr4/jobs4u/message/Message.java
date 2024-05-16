package lapr4.jobs4u.message;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import lapr4.jobs4u.EventListener;
import lapr4.jobs4u.protocol.ProtocolMessage;

public abstract class Message {

  protected final ProtocolMessage request;
  protected final EventListener eventListener;
  protected final Socket socket;
  private final DataOutputStream output;

  public Message(final ProtocolMessage message, final DataOutputStream output, final Socket socket,
      final EventListener eventListener) {
    this.request = message;
    this.output = output;
    this.socket = socket;
    this.eventListener = eventListener;
  }

  public abstract void handle() throws IOException;

  public void send(ProtocolMessage response) throws IOException {
    synchronized (output) {
      output.write(response.toByteStream());
    }
  }

  public void close() throws IOException {
    output.close();
    socket.close();
  }
}