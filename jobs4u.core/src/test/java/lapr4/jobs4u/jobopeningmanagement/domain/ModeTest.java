package lapr4.jobs4u.jobopeningmanagement.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;

/**
 * @author 2DI2
 */
public class ModeTest {

    @Test
    public void testModeCreation() {
        String validMode = "HYBRID";
        Mode mode = Mode.valueOf(validMode);
        assertEquals(mode.toString(), validMode);
    }

    @Test
    public void testModeCreationWithInvalidaType() {
        String invalidMode = "INVALID";
        assertThrows(IllegalArgumentException.class, () -> {
            Mode.valueOf(invalidMode);
        });
    }

    @Test
    public void testModeCreationWithInvalidEmptyValue() {
        String invalidMode = "";
        assertThrows(IllegalArgumentException.class, () -> {
            Mode.valueOf(invalidMode);
        });
    }

    @Test
    public void testModeCreationWithNullValue() {
        String invalidMode = null;
        assertThrows(IllegalArgumentException.class, () -> {
            Mode.valueOf(invalidMode);
        });
    }
}
