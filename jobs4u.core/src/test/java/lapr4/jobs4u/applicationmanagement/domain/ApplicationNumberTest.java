package lapr4.jobs4u.applicationmanagement.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;

public class ApplicationNumberTest {

    @Test
    public void testApplicationNumber() {
        String applicationNumberString = "100";
        ApplicationNumber applicationNumber = ApplicationNumber.valueOf(applicationNumberString);
        assertEquals(applicationNumber.toString(), applicationNumberString);
    }

    @Test
    public void testAddressCreationWithInvalidEmptyValue() {
        String invalidApplicationNumber = "";
        assertThrows(IllegalArgumentException.class, () -> {
            ApplicationNumber.valueOf(invalidApplicationNumber);
        });
    }

    @Test
    public void testAddressCreationWithNullValue() {
        String invalidApplicationNumber = null;
        assertThrows(IllegalArgumentException.class, () -> {
            ApplicationNumber.valueOf(invalidApplicationNumber);
        });
    }
}
