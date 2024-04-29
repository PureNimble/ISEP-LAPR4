package lapr4.jobs4u.customerusermanagement.customer.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;

import lapr4.jobs4u.customerusermanagement.domain.CompanyName;

public class CompanyNameTest {
    
    @Test
    public void testCompanyNameCreation() {
        String validCompanyName = "ISEP";
        CompanyName companyName = CompanyName.valueOf(validCompanyName);
        assertEquals(companyName.toString(), validCompanyName);
    }

    @Test
    public void testCompanyNameCreationWithInvalidEmptyValue() {
        String invalidCompanyName = "";
        assertThrows(IllegalArgumentException.class, () -> {
            CompanyName.valueOf(invalidCompanyName);
        });
    }

    @Test
    public void testCompanyNameCreationWithNullValue() {
        String invalidCompanyName = null;
        assertThrows(IllegalArgumentException.class, () -> {
            CompanyName.valueOf(invalidCompanyName);
        });
    }
}
