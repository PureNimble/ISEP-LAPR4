package lapr4.jobs4u.recruitmentprocessmanagement.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;

public class StateTest {
    
    @Test
    public void testStateCreation() {
        String validState = "OPEN";
        State date = State.valueOf(validState);
        assertEquals(date.toString(), validState);
    }

    @Test
    public void testStateCreationWithInvalidNonExistingState() {
        String invalidState = "INVALID";
        assertThrows(IllegalArgumentException.class, () -> {
            State.valueOf(invalidState);
        });
    }

    @Test
    public void testStateCreationWithInvalidEmptyValue() {
        String invalidState = "";
        assertThrows(IllegalArgumentException.class, () -> {
            State.valueOf(invalidState);
        });
    }

    @Test
    public void testStateCreationWithNullValue() {
        String invalidState = null;
        assertThrows(IllegalArgumentException.class, () -> {
            State.valueOf(invalidState);
        });
    }
}
