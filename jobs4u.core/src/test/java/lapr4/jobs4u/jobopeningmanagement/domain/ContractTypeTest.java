package lapr4.jobs4u.jobopeningmanagement.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;

/**
 * @author 2DI2
 */
public class ContractTypeTest {

    @Test
    public void testContractTypeCreation() {
        String validContractType = "VOLUNTEER";
        ContractType contractType = ContractType.valueOf(validContractType);
        assertEquals(contractType.toString(), validContractType);
    }

    @Test
    public void testContractTypeCreationWithInvalidaType() {
        String invalidContractType = "INVALID";
        assertThrows(IllegalArgumentException.class, () -> {
            ContractType.valueOf(invalidContractType);
        });
    }

    @Test
    public void testContractTypeCreationWithInvalidEmptyValue() {
        String invalidContractType = "";
        assertThrows(IllegalArgumentException.class, () -> {
            ContractType.valueOf(invalidContractType);
        });
    }

    @Test
    public void testContractTypeCreationWithNullValue() {
        String invalidContractType = null;
        assertThrows(IllegalArgumentException.class, () -> {
            ContractType.valueOf(invalidContractType);
        });
    }
}