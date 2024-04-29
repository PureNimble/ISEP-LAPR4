package lapr4.jobs4u.customerusermanagement.customer.domain;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import eapli.framework.infrastructure.authz.domain.model.NilPasswordPolicy;
import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;
import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.authz.domain.model.SystemUserBuilder;
import lapr4.jobs4u.customerusermanagement.domain.Customer;
import lapr4.jobs4u.customerusermanagement.domain.CustomerBuilder;
import lapr4.jobs4u.usermanagement.domain.BaseRoles;

public class CustomerTest {
    private final String aCustomerCode = "abcdefghij";
    private final String anotherCustomerCode = "qrstuvwxyz";

    public static Customer dummyCustomer(final String code) {
        // should we load from spring context?
        final CustomerBuilder customerBuilder = new CustomerBuilder();
        final SystemUserBuilder userBuilder = new SystemUserBuilder(new NilPasswordPolicy(), new PlainTextEncoder());
        SystemUser user = userBuilder.with("fnac@email.local","DummyPass", "Dummy", "Dummy", "fnac@email.local").build();
        return customerBuilder.with(user, "Fnac", "R. Sara Afonso 105, 4460-841 Sra. da Hora", code,
            "fnac@email.local", "910000000").build();
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
