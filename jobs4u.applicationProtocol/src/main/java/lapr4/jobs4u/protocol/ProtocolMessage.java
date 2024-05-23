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

    public static ProtocolMessage fromDataStream(DataInputStream input) throws IOException {

        byte protocolVersion = input.readByte();
        MessageCode code = MessageCode.valueOf(input.readByte());

        List<byte[]> dataChunks = new ArrayList<>();
        while (true) {
            int length = input.readUnsignedByte() + input.readUnsignedByte() * 256;
            if (length == 0) {
                break;
            }

            byte[] data = new byte[length];
            input.readFully(data);
            dataChunks.add(data);
        }

        int totalLength = dataChunks.stream().mapToInt(chunk -> chunk.length).sum();
        byte[] allData = new byte[totalLength];
        int currentIndex = 0;
        for (byte[] chunk : dataChunks) {
            System.arraycopy(chunk, 0, allData, currentIndex, chunk.length);
            currentIndex += chunk.length;
        }

        return new ProtocolMessage(protocolVersion, code, allData);
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