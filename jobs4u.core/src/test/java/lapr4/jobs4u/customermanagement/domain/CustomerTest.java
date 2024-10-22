package lapr4.jobs4u.customermanagement.domain;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.authz.domain.model.SystemUserBuilder;
import lapr4.jobs4u.usermanagement.domain.BaseRoles;
import lapr4.jobs4u.usermanagement.domain.UserBuilderHelper;

/**
 * @author 2DI2
 */
public class CustomerTest {
    private final String aCustomerCode = "ABC123";
    private final String anotherCustomerCode = "ZYX123";

    public static Customer dummyCustomer(final String code) {
        // should we load from spring context?
        final CustomerBuilder customerBuilder = new CustomerBuilder();
        final SystemUserBuilder userBuilder = UserBuilderHelper.builder();
        final SystemUser aSu = userBuilder.with("username@email.local", "Pass123", "firstName", "lastName", "email@email.local").build();
        return customerBuilder.with("Fnac", "R. Sara Afonso 105, 4460-841 Sra. da Hora", code,
            "fnac@email.local", "910000000", aSu).build();
    }

    private Customer getNewDummyCustomer(final String code) {
        return dummyCustomer(code);
    }

    @Test
    public void ensureCustomerEqualsPassesForTheSameCustomerCode() throws Exception {

        final Customer aCustomer = getNewDummyCustomer(aCustomerCode);

        final Customer anotherCustomer = getNewDummyCustomer(aCustomerCode);

        final boolean expected = aCustomer.equals(anotherCustomer);

        assertTrue(expected);
    }

    @Test
    public void ensureCustomerEqualsFailsForDifferenteCustomerCode() throws Exception {
        final Set<Role> roles = new HashSet<>();
        roles.add(BaseRoles.ADMIN);

        final Customer aCustomer = getNewDummyCustomer(aCustomerCode);

        final Customer anotherCustomer = getNewDummyCustomer(anotherCustomerCode);

        final boolean expected = aCustomer.equals(anotherCustomer);

        assertFalse(expected);
    }

    @Test
    public void ensureCustomerEqualsAreTheSameForTheSameInstance() throws Exception {
        final Customer aCustomer = getNewDummyCustomer(aCustomerCode);

        final boolean expected = aCustomer.equals(aCustomer);

        assertTrue(expected);
    }

    @Test
    public void ensureCustomerEqualsFailsForDifferenteObjectTypes() throws Exception {
        final Customer aCustomer = getNewDummyCustomer(aCustomerCode);

        final boolean expected = aCustomer.equals(getNewDummyCustomer(anotherCustomerCode));

        assertFalse(expected);
    }

    @Test
    public void ensureCustomerIsTheSameAsItsInstance() throws Exception {
        final Customer aCustomer = getNewDummyCustomer(aCustomerCode);

        final boolean expected = aCustomer.sameAs(aCustomer);

        assertTrue(expected);
    }

    @Test
    public void ensureTwoCustomerWithDifferentCustomerCodesAreNotTheSame() throws Exception {
        final Customer aCustomer = dummyCustomer(aCustomerCode);
        final Customer anotherCustomer = dummyCustomer(anotherCustomerCode);

        final boolean expected = aCustomer.sameAs(anotherCustomer);

        assertFalse(expected);
    }
}
