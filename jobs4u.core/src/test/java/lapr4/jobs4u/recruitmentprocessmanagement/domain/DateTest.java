package lapr4.jobs4u.recruitmentprocessmanagement.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;

/**
 * @author 2DI2
 */
public class DateTest {

    @Test
    public void testDateCreation() {
        String validDate = "21-03-2023";
        Date date = Date.valueOf(validDate);
        assertEquals(date.toString(), validDate);
    }

    @Test
    public void testDateCreationWithInvalidFormatAlpha() {
        String invalidDate = "Invalid";
        assertThrows(IllegalArgumentException.class, () -> {
            Date.valueOf(invalidDate);
        });
    }

    @Test
    public void testDateCreationWithInvalidNonExistingDate() {
        String invalidDate = "80-02-2023";
        assertThrows(IllegalArgumentException.class, () -> {
            Date.valueOf(invalidDate);
        });
    }

    @Test
    public void testDateCreationWithInvalidEmptyValue() {
        String invalidDate = "";
        assertThrows(IllegalArgumentException.class, () -> {
            Date.valueOf(invalidDate);
        });
    }

    @Test
    public void testDateCreationWithNullValue() {
        String invalidDate = null;
        assertThrows(IllegalArgumentException.class, () -> {
            Date.valueOf(invalidDate);
        });
    }
}
