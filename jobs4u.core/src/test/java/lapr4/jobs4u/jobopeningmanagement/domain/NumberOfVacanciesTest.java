package lapr4.jobs4u.jobopeningmanagement.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;

public class NumberOfVacanciesTest {

    @Test
    public void testNumberOfVacanciesCreation() {
        String validNumberOfVacancies = "30";
        NumberOfVacancies contractType = NumberOfVacancies.valueOf(validNumberOfVacancies);
        assertEquals(contractType.toString(), validNumberOfVacancies);
    }

    @Test
    public void testNumberOfVacanciesCreationWithInvalidaType() {
        String invalidNumberOfVacancies = "INVALID";
        assertThrows(IllegalArgumentException.class, () -> {
            NumberOfVacancies.valueOf(invalidNumberOfVacancies);
        });
    }

    @Test
    public void testNumberOfVacanciesCreationWithInvalidaAlphaNumericType() {
        String invalidNumberOfVacancies = "30INVALID";
        assertThrows(IllegalArgumentException.class, () -> {
            NumberOfVacancies.valueOf(invalidNumberOfVacancies);
        });
    }

    @Test
    public void testNumberOfVacanciesCreationWithInvalidEmptyValue() {
        String invalidNumberOfVacancies = "";
        assertThrows(IllegalArgumentException.class, () -> {
            NumberOfVacancies.valueOf(invalidNumberOfVacancies);
        });
    }

    @Test
    public void testNumberOfVacanciesCreationWithNullValue() {
        String invalidNumberOfVacancies = null;
        assertThrows(IllegalArgumentException.class, () -> {
            NumberOfVacancies.valueOf(invalidNumberOfVacancies);
        });
    }
}