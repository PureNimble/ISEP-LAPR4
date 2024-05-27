package lapr4.jobs4u.protocol;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 2DI2
 */
public enum MessageCode {

    COMMTEST((byte) 0),
    DISCONN((byte) 1),
    ACK((byte) 2),
    ERR((byte) 3),
    AUTH((byte) 4),
    LOGOUT((byte) 5),
    CHANGEPASS((byte) 6);

    private static final Map<Byte, MessageCode> CODES = new HashMap<>();

    public final byte code;

    private MessageCode(final byte code) {
        this.code = code;
    }

    public byte toByte() {
        return this.code;
    }

    static {
        for (MessageCode c : values()) {
            CODES.put(c.code, c);
        }
    }

    public static MessageCode valueOf(final byte code) {
        return CODES.get(code);
    }

    public static MessageCode valueOf(final int code) {
        return CODES.get((byte) code);
    }
}
