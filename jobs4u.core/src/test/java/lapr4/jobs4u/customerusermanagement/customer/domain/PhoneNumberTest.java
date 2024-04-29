package lapr4.jobs4u.customerusermanagement.customer.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;

import lapr4.jobs4u.customerusermanagement.domain.PhoneNumber;

public class PhoneNumberTest {
    
    @Test
    public void testPhoneNumberCreation() {
        String validPhoneNumber = "910000000";
        PhoneNumber phoneNumber = PhoneNumber.valueOf(validPhoneNumber);
        assertEquals(phoneNumber.toString(), validPhoneNumber);
    }

    @Test
    public void testPhoneNumberCreationWithInvalidNumberOfDigits() {
        String invalidPhoneNumber = "910";
        assertThrows(IllegalArgumentException.class, () -> {
            PhoneNumber.valueOf(invalidPhoneNumber);
        });
    }

    @Test
    public void testPhoneNumberCreationWithInvalidNumberPortugueseNumber() {
        String invalidPhoneNumber = "980000000";
        assertThrows(IllegalArgumentException.class, () -> {
            PhoneNumber.valueOf(invalidPhoneNumber);
        });
    }

    @Test
    public void testPhoneNumberCreationWithAlpha() {
        String invalidPhoneNumber = "910Errado0";
        assertThrows(IllegalArgumentException.class, () -> {
            PhoneNumber.valueOf(invalidPhoneNumber);
        });
    }

    @Test
    public void testPhoneNumberCreationWithInvalidEmptyValue() {
        String invalidPhoneNumber = "";
        assertThrows(IllegalArgumentException.class, () -> {
            PhoneNumber.valueOf(invalidPhoneNumber);
        });
    }

    @Test
    public void testPhoneNumberCreationWithNullValue() {
        String invalidPhoneNumber = null;
        assertThrows(IllegalArgumentException.class, () -> {
            PhoneNumber.valueOf(invalidPhoneNumber);
        });
    }
}
