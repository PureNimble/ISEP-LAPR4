package lapr4.jobs4u.interviewmanagement.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;

public class TimeTest {
    private final String VALID_TIME = "09:00";
    private final String INVALID_TIME = "10:00:00";

    @Test
    public void testAddressCreation() {
        Time time = Time.valueOf(VALID_TIME);
        assertEquals(time.toString(), VALID_TIME);
    }

    @Test
    public void testAddressCreationWithInvalidEmptyValue() {
        assertThrows(IllegalArgumentException.class, () -> {
            Time.valueOf(INVALID_TIME);
        });
    }

    @Test
    public void testAddressCreationWithNullValue() {
        assertThrows(IllegalArgumentException.class, () -> {
            Time.valueOf(null);
        });
    }
}
