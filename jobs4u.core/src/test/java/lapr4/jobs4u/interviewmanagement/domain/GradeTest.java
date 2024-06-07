package lapr4.jobs4u.interviewmanagement.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;

/**
 * @author 2DI2
 */
public class GradeTest {

    private final String VALID_GRADE = "75.0";
    private final String INVALID_GRADE = "-75.0";
    private final String ANOTHER_INVALID_GRADE = "BOAS";

    @Test
    public void testGradeCreation() {
        Grade grade = Grade.valueOf(VALID_GRADE);
        assertEquals(grade.toString(), VALID_GRADE);
    }

    @Test
    public void testGradeCreationWithInvalidEmptyValue() {
        assertThrows(IllegalArgumentException.class, () -> {
            Grade.valueOf(INVALID_GRADE);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            Grade.valueOf(ANOTHER_INVALID_GRADE);
        });
    }

    @Test
    public void testGradeCreationWithNullValue() {
        assertThrows(IllegalArgumentException.class, () -> {
            Grade.valueOf(null);
        });
    }
}
