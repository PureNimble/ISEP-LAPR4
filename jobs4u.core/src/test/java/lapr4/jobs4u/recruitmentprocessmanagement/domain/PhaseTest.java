package lapr4.jobs4u.recruitmentprocessmanagement.domain;

import static org.junit.Assert.assertTrue;
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

    @Test
    public void testOpeningPhase() throws Exception {
        Phase phase = getNewPhase(aInitialDate, aFinalDate);
        phase.open();
        assertTrue(phase.state().equals(State.valueOf(ActivityState.OPEN.toString())));
    }

    @Test
    public void testClosingPhase() throws Exception {
        Phase phase = getNewPhase(aInitialDate, aFinalDate);
        phase.open();
        phase.close();
        assertTrue(phase.state().equals(State.valueOf(ActivityState.CLOSED.toString())));
    }

    @Test
    public void testOpeningPhaseAlreadyOpened() throws Exception {
        Phase phase = getNewPhase(aInitialDate, aFinalDate);
        phase.open();
        assertThrows(IllegalStateException.class, () -> {
            phase.open();
        });
    }

    @Test
    public void testClosingPhaseAlreadyClosed() throws Exception {
        Phase phase = getNewPhase(aInitialDate, aFinalDate);
        assertThrows(IllegalStateException.class, () -> {
            phase.close();
        });
    }
}