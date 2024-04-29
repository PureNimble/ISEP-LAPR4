package lapr4.jobs4u.customerusermanagement.customer.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;

import lapr4.jobs4u.customerusermanagement.domain.Address;

public class AddressTest {

    @Test
    public void testAddressCreation() {
        String validAddress = "Rua do ISEP";
        Address address = Address.valueOf(validAddress);
        assertEquals(address.toString(), validAddress);
    }

    @Test
    public void testAddressCreationWithInvalidEmptyValue() {
        String invalidAddress = "";
        assertThrows(IllegalArgumentException.class, () -> {
            Address.valueOf(invalidAddress);
        });
    }

    @Test
    public void testAddressCreationWithNullValue() {
        String invalidAddress = null;
        assertThrows(IllegalArgumentException.class, () -> {
            Address.valueOf(invalidAddress);
        });
    }
}
