package lapr4.jobs4u.applicationmanagement.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;

public class OutComeTest {

    @Test
    public void testOutcome() {
        OutcomeValue outcome = OutcomeValue.APPROVED;
        Outcome x = Outcome.valueOf(outcome.toString());
        assertEquals(outcome.toString(), x.toString());
    }

    @Test
    public void testOutcomeCreationWithInvalidEmptyValue() {
        String invalidOutCome = "";
        assertThrows(IllegalArgumentException.class, () -> {
            Outcome.valueOf(invalidOutCome);
        });
    }

    @Test
    public void testOutcomeCreationWithNullValue() {
        String invalidJustification = null;
        assertThrows(IllegalArgumentException.class, () -> {
            Outcome.valueOf(invalidJustification);
        });
    }
}
