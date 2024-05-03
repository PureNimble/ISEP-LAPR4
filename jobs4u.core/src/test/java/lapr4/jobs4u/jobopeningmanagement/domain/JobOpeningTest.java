package lapr4.jobs4u.jobopeningmanagement.domain;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.authz.domain.model.SystemUserBuilder;
import eapli.framework.time.util.CurrentTimeCalendars;
import lapr4.jobs4u.customermanagement.domain.Customer;
import lapr4.jobs4u.customermanagement.domain.CustomerBuilder;
import lapr4.jobs4u.usermanagement.domain.BaseRoles;
import lapr4.jobs4u.usermanagement.domain.UserBuilderHelper;

public class JobOpeningTest {
    private final String aJobReference = "abcdefghij";
    private final String anotherJobReference = "qrstuvwxyz";

    public static JobOpening dummyJobOpening(final String jobReference) {
        // should we load from spring context?
        final JobOpeningBuilder jobOpeningBuilder = new JobOpeningBuilder();
        final CustomerBuilder customerBuilder = new CustomerBuilder();
        final SystemUserBuilder userBuilder = UserBuilderHelper.builder();
        final SystemUser aSu = userBuilder
                .with("username@email.local", "Pass123", "firstName", "lastName", "email@email.local").build();
        final Customer aCustomer = customerBuilder
                .with("Fnac", "R. Sara Afonso 105, 4460-841 Sra. da Hora", "ABC123",
                        "fnac@email.local", "910000000", aSu)
                .build();
        ;

        return jobOpeningBuilder.with(jobReference, "titleOrFunction", "VOLUNTEER",
                "HYBRID", "address", aCustomer, "jobDescription", CurrentTimeCalendars.now()).build();
    }

    private JobOpening getNewDummyJobOpening(final String jobReference) {
        return dummyJobOpening(jobReference);
    }

    @Test
    public void ensureJobOpeningEqualsPassesForTheSameJobOpeningCode() throws Exception {

        final JobOpening aJobOpening = getNewDummyJobOpening(aJobReference);

        final JobOpening anotherJobOpening = getNewDummyJobOpening(aJobReference);

        final boolean expected = aJobOpening.equals(anotherJobOpening);

        assertTrue(expected);
    }

    @Test
    public void ensureJobOpeningEqualsFailsForDifferenteJobOpeningCode() throws Exception {
        final Set<Role> roles = new HashSet<>();
        roles.add(BaseRoles.ADMIN);

        final JobOpening aJobOpening = getNewDummyJobOpening(aJobReference);

        final JobOpening anotherJobOpening = getNewDummyJobOpening(anotherJobReference);

        final boolean expected = aJobOpening.equals(anotherJobOpening);

        assertFalse(expected);
    }

    @Test
    public void ensureJobOpeningEqualsAreTheSameForTheSameInstance() throws Exception {
        final JobOpening aJobOpening = getNewDummyJobOpening(aJobReference);

        final boolean expected = aJobOpening.equals(aJobOpening);

        assertTrue(expected);
    }

    @Test
    public void ensureJobOpeningEqualsFailsForDifferenteObjectTypes() throws Exception {
        final JobOpening aJobOpening = getNewDummyJobOpening(aJobReference);

        final boolean expected = aJobOpening.equals(getNewDummyJobOpening(anotherJobReference));

        assertFalse(expected);
    }

    @Test
    public void ensureJobOpeningIsTheSameAsItsInstance() throws Exception {
        final JobOpening aJobOpening = getNewDummyJobOpening(aJobReference);

        final boolean expected = aJobOpening.sameAs(aJobOpening);

        assertTrue(expected);
    }

    @Test
    public void ensureTwoJobOpeningWithDifferentJobOpeningCodesAreNotTheSame() throws Exception {
        final JobOpening aJobOpening = dummyJobOpening(aJobReference);
        final JobOpening anotherJobOpening = dummyJobOpening(anotherJobReference);

        final boolean expected = aJobOpening.sameAs(anotherJobOpening);

        assertFalse(expected);
    }
}
