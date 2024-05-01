package lapr4.jobs4u.applicationmanagement.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;

public class JustificationTest {

    @Test
    public void testJustification() {
        String justificationString = "100";
        Justification justification = Justification.valueOf(justificationString);
        assertEquals(justification.toString(), justificationString);
    }

    @Test
    public void testAddressCreationWithInvalidEmptyValue() {
        String invalidJustification = "";
        assertThrows(IllegalArgumentException.class, () -> {
            Justification.valueOf(invalidJustification);
        });
    }

    @Test
    public void testAddressCreationWithNullValue() {
        String invalidJustification = null;
        assertThrows(IllegalArgumentException.class, () -> {
            Justification.valueOf(invalidJustification);
        });
    }
}
