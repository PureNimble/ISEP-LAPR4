package lapr4.jobs4u.customermanagement.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.Test;

public class CustomerCodeTest {

    @Test
    public void testCustomerCodeCreation() {
        String validCustomerCode = "ISEPFEUP";
        CustomerCode customerCode = CustomerCode.valueOf(validCustomerCode);
        assertEquals(customerCode.toString(), validCustomerCode);
    }

    @Test
    public void testCustomerCodeCreationWithInvalidNumberOfDigits() {
        String invalidCustomerCode = "123";
        assertThrows(IllegalArgumentException.class, () -> {
            CustomerCode.valueOf(invalidCustomerCode);
        });
    }

    @Test
    public void testCustomerCodeCreationWithEmptyValue() {
        String invalidCustomerCode = "";
        assertThrows(IllegalArgumentException.class, () -> {
            CustomerCode.valueOf(invalidCustomerCode);
        });
    }

    @Test
    public void testCustomerCodeCreationWithNullValue() {
        String invalidCustomerCode = null;
        assertThrows(IllegalArgumentException.class, () -> {
            CustomerCode.valueOf(invalidCustomerCode);
        });
    }
}
