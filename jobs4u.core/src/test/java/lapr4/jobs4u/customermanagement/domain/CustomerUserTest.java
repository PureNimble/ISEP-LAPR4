package lapr4.jobs4u.customermanagement.domain;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;

import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.authz.domain.model.SystemUserBuilder;
import lapr4.jobs4u.usermanagement.domain.UserBuilderHelper;

public class CustomerUserTest {

    private final String aCustomerCode = "abcdefghij";

    public static CustomerUser dummyCustomerUser(final String code) {
        // should we load from spring context?
        final SystemUserBuilder userBuilder = UserBuilderHelper.builder();
        final SystemUser aSu = userBuilder.with("username@email.local", "Pass123", "firstName", "lastName", "email@email.local").build();
        final SystemUser anotherSu = userBuilder.with("manager@email.local", "Pass123", "firstName", "lastName", "manager@email.local").build();
        final Customer customer = new CustomerBuilder()
                .with("Fnac", "R. Sara Afonso 105, 4460-841 Sra. da Hora", code, "fnac@email.com", "910000000").build();
        return new CustomerUserBuilder().with(customer, aSu, anotherSu).build();
    }

    @Test
    public void ensureCustomerEqualsPassesForTheSameCustomerCode() throws Exception {

        final CustomerUser aCustomer = dummyCustomerUser(aCustomerCode);

        final CustomerUser anotherCustomer = dummyCustomerUser(aCustomerCode);

        final boolean expected = aCustomer.equals(anotherCustomer);

        assertTrue(expected);
    }

    @Test
    public void ensureCustomerEqualsAreTheSameForTheSameInstance() throws Exception {
        final CustomerUser aCustomer = dummyCustomerUser(aCustomerCode);

        final boolean expected = aCustomer.equals(aCustomer);

        assertTrue(expected);
    }

    @Test
    public void ensureCustomerIsTheSameAsItsInstance() throws Exception {
        final CustomerUser aCustomer = dummyCustomerUser(aCustomerCode);

        final boolean expected = aCustomer.sameAs(aCustomer);

        assertTrue(expected);
    }

}
