package lapr4.jobs4u.interviewmanagement.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;

/**
 * @author 2DI2
 */
public class TimeTest {
    private final String VALID_TIME = "09:00";
    private final String INVALID_TIME = "10:00:00";

    @Test
    public void testTimeCreation() {
        Time time = Time.valueOf(VALID_TIME);
        assertEquals(time.toString(), VALID_TIME);
    }

    @Test
    public void testTimeCreationWithInvalidEmptyValue() {
        assertThrows(IllegalArgumentException.class, () -> {
            Time.valueOf(INVALID_TIME);
        });
    }

    @Test
    public void testTimeCreationWithNullValue() {
        assertThrows(IllegalArgumentException.class, () -> {
            Time.valueOf(null);
        });
    }

    @Test
    public void testTimeCreationWithInvalidFormat() {
        String invalidFormatTime = "25:00";
        assertThrows(IllegalArgumentException.class, () -> {
            Time.valueOf(invalidFormatTime);
        });
    }

    @Test
    public void testTimeCreationWithInvalidMinutes() {
        String invalidMinutesTime = "10:60";
        assertThrows(IllegalArgumentException.class, () -> {
            Time.valueOf(invalidMinutesTime);
        });
    }

    @Test
    public void testTimeCreationWithInvalidHours() {
        String invalidHoursTime = "24:00";
        assertThrows(IllegalArgumentException.class, () -> {
            Time.valueOf(invalidHoursTime);
        });
    }

    @Test
    public void testTimeCreationWithNegativeTime() {
        String negativeTime = "-01:00";
        assertThrows(IllegalArgumentException.class, () -> {
            Time.valueOf(negativeTime);
        });
    }

    @Test
    public void testTimeCreationWithLetters() {
        String timeWithLetters = "ab:cd";
        assertThrows(IllegalArgumentException.class, () -> {
            Time.valueOf(timeWithLetters);
        });
    }
}
