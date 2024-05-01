package lapr4.jobs4u.applicationmanagement.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;

public class ResultTest {

    @Test
    public void testResult() {
        String justificationString = "100";
        final String outcome = OutcomeValue.REJECTED.toString();
        Result result = Result.valueOf();
        Result result1 = Result.valueOf();
        assertEquals(result1, result);
    }

    @Test
    public void testResultCreationWithInvalidValue() {
        assertThrows(IllegalArgumentException.class, () -> {
            Result result = Result.valueOf();
            result.addOutcome(OutcomeValue.REJECTED.toString());
        });
    }

    @Test
    public void testAddressCreationWithNullValue() {
        Result result = Result.valueOf();
        assertThrows(IllegalArgumentException.class, () -> {
            result.addOutcome("invalidOutcome");
        });
    }

}
