package lapr4.jobs4u.rankmanagement.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;

/**
 * @author 2DI2
 */
public class RankPlacementTest {

    private final String VALID_PLACEMENT = "1";
    private final String INVALID_PLACEMENT = "-1";
    private final String ANOTHER_INVALID_PLACEMENT = "BOAS";

    @Test
    public void testPlacementCreation() {
        RankPlacement placement = RankPlacement.valueOf(VALID_PLACEMENT);
        assertEquals(placement.toString(), VALID_PLACEMENT);
    }

    @Test
    public void testPlacementCreationWithInvalidEmptyValue() {
        assertThrows(IllegalArgumentException.class, () -> {
            RankPlacement.valueOf(INVALID_PLACEMENT);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            RankPlacement.valueOf(ANOTHER_INVALID_PLACEMENT);
        });
    }

    @Test
    public void testPlacementCreationWithNullValue() {
        assertThrows(IllegalArgumentException.class, () -> {
            RankPlacement.valueOf(null);
        });
    }
}
