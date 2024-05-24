package lapr4.jobs4u.protocol;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProtocolMessage {

    private final byte protocolVersion;
    private final MessageCode code;
    private final byte[][] dataChunks;

    public ProtocolMessage(final byte protocolVersion, final MessageCode code) {
        this.protocolVersion = protocolVersion;
        this.code = code;
        this.dataChunks = new byte[0][];
    }
    
    public ProtocolMessage(final byte protocolVersion, final MessageCode code, final String... data) {
        this.protocolVersion = protocolVersion;
        this.code = code;
        this.dataChunks = new byte[data.length][];
        for (int i = 0; i < data.length; i++) {
            this.dataChunks[i] = data[i].getBytes();
        }
    }
    
    public ProtocolMessage(final byte protocolVersion, final MessageCode code, final byte[]... dataChunk) {
        this.protocolVersion = protocolVersion;
        this.code = code;
        this.dataChunks = new byte[dataChunk.length][];
        for (int i = 0; i < dataChunk.length; i++) {
            this.dataChunks[i] = new byte[dataChunk[i].length];
            System.arraycopy(dataChunk[i], 0, this.dataChunks[i], 0, dataChunk[i].length);
        }
    }

    public static ProtocolMessage fromDataStream(final DataInputStream input) throws IOException {
        final byte protocolVersion = input.readByte();
        final MessageCode code = MessageCode.valueOf(input.readByte());
    
        List<byte[]> dataChunks = new ArrayList<>();
        while (true) {
            final int length = input.readUnsignedByte() + input.readUnsignedByte() * 256;
            if (length == 0) {
                break;
            }
    
            byte[] data = new byte[length];
            input.readFully(data);
            dataChunks.add(data);
        }
    
        return new ProtocolMessage(protocolVersion, code, dataChunks.toArray(new byte[0][]));
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

    public MessageCode code() {
        return this.code;
    }

}