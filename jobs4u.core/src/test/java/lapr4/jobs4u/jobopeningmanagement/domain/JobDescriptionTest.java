package lapr4.jobs4u.jobopeningmanagement.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;

public class JobDescriptionTest {

    @Test
    public void testJobDescriptionCreation() {
        String validJobDescription = "Description";
        JobDescription contractType = JobDescription.valueOf(validJobDescription);
        assertEquals(contractType.toString(), validJobDescription);
    }

    @Test
    public void testJobDescriptionCreationWithInvalidEmptyValue() {
        String invalidJobDescription = "";
        assertThrows(IllegalArgumentException.class, () -> {
            JobDescription.valueOf(invalidJobDescription);
        });
    }

    @Test
    public void testJobDescriptionCreationWithNullValue() {
        String invalidJobDescription = null;
        assertThrows(IllegalArgumentException.class, () -> {
            JobDescription.valueOf(invalidJobDescription);
        });
    }
}