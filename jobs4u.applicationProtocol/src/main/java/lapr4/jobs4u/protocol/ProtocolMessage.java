package lapr4.jobs4u.protocol;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 2DI2
 */
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

    public ProtocolMessage(final byte protocolVersion, final MessageCode code, final Object... dataChunk)
            throws IOException {
        this.protocolVersion = protocolVersion;
        this.code = code;
        this.dataChunks = new byte[dataChunk.length][];
        for (int i = 0; i < dataChunk.length; i++) {
            final ByteArrayOutputStream bos = new ByteArrayOutputStream();
            final ObjectOutputStream out = new ObjectOutputStream(bos);
            out.writeObject(dataChunk[i]);
            out.flush();
            this.dataChunks[i] = bos.toByteArray();
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

    public Object[] dataAsObjects() throws IOException, ClassNotFoundException {
        Object[] objects = new Object[dataChunks.length];
        for (int i = 0; i < dataChunks.length; i++) {
            final ByteArrayInputStream bis = new ByteArrayInputStream(dataChunks[i]);
            final ObjectInputStream in = new ObjectInputStream(bis);
            objects[i] = in.readObject();
            in.close();
        }
        return objects;
    }

    public byte protocolVersion() {
        return this.protocolVersion;
    }

    public byte[][] datachunks() {
        return this.dataChunks;
    }

    public MessageCode code() {
        return this.code;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Protocol Version: ").append(protocolVersion).append("\n");
        sb.append("Message Code: ").append(code).append("\n");
        sb.append("Data Chunks: ").append(dataChunks.length).append("\n");
        for (byte[] data : dataChunks) {
            sb.append("Data: ").append(new String(data)).append("\n");
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + protocolVersion;
        result = prime * result + ((code == null) ? 0 : code.hashCode());
        result = prime * result + Arrays.deepHashCode(dataChunks);
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final ProtocolMessage other = (ProtocolMessage) obj;
        if (protocolVersion != other.protocolVersion)
            return false;
        if (code != other.code)
            return false;
        if (!Arrays.deepEquals(dataChunks, other.dataChunks))
            return false;
        return true;
    }

}