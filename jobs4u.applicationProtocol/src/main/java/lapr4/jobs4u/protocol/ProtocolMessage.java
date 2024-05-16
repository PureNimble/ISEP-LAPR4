package lapr4.jobs4u.protocol;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ProtocolMessage {

  private final byte protocolVersion;
  private final MessageCode code;
  private final byte[][] dataChunks;

  public ProtocolMessage(final byte protocolVersion, final MessageCode code) {
    this.protocolVersion = protocolVersion;
    this.code = code;
    this.dataChunks = new byte[0][0];
  }

  public ProtocolMessage(final byte protocolVersion, final MessageCode code, final String data) {
    this.protocolVersion = protocolVersion;
    this.code = code;
    this.dataChunks = new byte[][] { data.getBytes() };
  }

  public ProtocolMessage(final byte protocolVersion, final MessageCode code, final byte[]... dataChunk) {
    this.protocolVersion = protocolVersion;
    this.code = code;
    this.dataChunks = dataChunk;
  }

  public byte[] toByteStream() throws IOException {

    ByteArrayOutputStream result = new ByteArrayOutputStream();
    result.write(protocolVersion);
    result.write(code.toByte());

    for (byte[] data : dataChunks) {
      if (data != null) {
        result.write(data.length % 256);
        result.write(data.length / 256);
        result.write(data);
      } else {
        result.write(0);
        result.write(0);
      }
    }

    result.write(0);
    result.write(0);

    return result.toByteArray();
  }

  public byte[][] datachunks() {
    return this.dataChunks;
  }

}