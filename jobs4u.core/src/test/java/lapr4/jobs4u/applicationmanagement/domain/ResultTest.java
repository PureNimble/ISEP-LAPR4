package lapr4.jobs4u.applicationmanagement.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;

/**
 * @author 2DI2
 */
public class ResultTest {

    @Test
    public void testResultWhenBuildingApplication() {

        Result result = Result.valueOf(OutcomeValue.PENDING.toString());
        Result result1 = Result.valueOf(OutcomeValue.PENDING.toString());
        assertEquals(result1, result);
    }

    @Test
    public void testResultCreationWithInvalidValue() {
        assertThrows(IllegalArgumentException.class, () -> {
            Result.valueOf("boas");
        });
    }

    @Test
    public void testResultCreationUpdate() {
        Result result = Result.valueOf(OutcomeValue.PENDING.toString());
        Result result1 = Result.valueOf(OutcomeValue.APPROVED.toString());

        result.addOutcome(OutcomeValue.APPROVED.toString());
        assertEquals(result1, result);
    }

    @Test
    public void testResultCreationWithNullValue() {
        Result result = Result.valueOf(OutcomeValue.PENDING.toString());
        assertThrows(IllegalArgumentException.class, () -> {
            result.addOutcome(null);
        });
    }

    @Test
    public void testResultCreationWithoutJustification() {
        Result result = Result.valueOf(OutcomeValue.PENDING.toString());
        assertThrows(IllegalArgumentException.class, () -> {
            result.addOutcome(OutcomeValue.REJECTED.toString());
        });
    }

    @Test
    public void testResultCreationWithJustification() {
        Result result = Result.valueOf(OutcomeValue.PENDING.toString());
        Result result1 = Result.valueOf(OutcomeValue.REJECTED.toString());
        result.addOutcome(OutcomeValue.REJECTED.toString(), "This is a justification");
        assertEquals(result1, result);
    }

}
