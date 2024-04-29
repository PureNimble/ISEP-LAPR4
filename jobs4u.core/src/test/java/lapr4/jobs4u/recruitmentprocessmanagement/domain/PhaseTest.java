package lapr4.jobs4u.recruitmentprocessmanagement.domain;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.Test;

public class PhaseTest {

    private final String aInitialDate = "21-03-2021";
    private final String aFinalDate = "24-03-2021";

    // Concrete subclass of Phase for testing
    private class TestPhase extends Phase {
        public TestPhase(String initialDate, String finalDate) {
            super(initialDate, finalDate);
        }
    }

    private Phase getNewPhase(final String initialDate, final String finalDate) {
        return new TestPhase(initialDate, finalDate);
    }

    @Test
    public void testPhaseCreationWithInvalidDatesOrder() throws Exception {
    
        assertThrows(IllegalArgumentException.class, () -> {
            getNewPhase(aFinalDate, aInitialDate);
        });
    }

}
