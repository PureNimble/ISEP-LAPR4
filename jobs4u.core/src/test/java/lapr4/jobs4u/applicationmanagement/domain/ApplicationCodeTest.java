package lapr4.jobs4u.applicationmanagement.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;

public class ApplicationCodeTest {

    @Test
    public void testApplicationCode() {
        String applicationCodeString = "100";
        ApplicationCode applicationNumber = ApplicationCode.valueOf(applicationCodeString);
        assertEquals(applicationNumber.toString(), applicationCodeString);
    }

    @Test
    public void testApplicationCodeCreationWithInvalidEmptyValue() {
        String invalidApplicationCode = "";
        assertThrows(IllegalArgumentException.class, () -> {
            ApplicationCode.valueOf(invalidApplicationCode);
        });
    }

    @Test
    public void testApplicationCodeCreationWithNullValue() {
        String invalidApplicationCode = null;
        assertThrows(IllegalArgumentException.class, () -> {
            ApplicationCode.valueOf(invalidApplicationCode);
        });
    }
}
