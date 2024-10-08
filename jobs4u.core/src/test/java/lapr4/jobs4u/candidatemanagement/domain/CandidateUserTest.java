package lapr4.jobs4u.candidatemanagement.domain;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Calendar;

import org.junit.Test;

import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.authz.domain.model.SystemUserBuilder;
import lapr4.jobs4u.usermanagement.domain.UserBuilderHelper;

/**
 * @author 2DI2
 */
public class CandidateUserTest {

    private final String aEmail = "candidate@email.local";

    public static CandidateUser dummyCustomerUser(final String email) {
        // should we load from spring context?
        final SystemUserBuilder userBuilder = UserBuilderHelper.builder();
        final SystemUser aSu = userBuilder
                .with("username@email.local", "Pass123", "firstName", "lastName", "email@email.local").build();
        final SystemUser creator = userBuilder
                .with("manager@email.local", "Pass123", "firstName", "lastName", "manager@email.local").build();

        final Candidate candidate = new CandidateBuilder()
                .with("Pedro", "Cadndiate", email, "910000000", creator).build();
        return new CandidateUserBuilder().with(candidate, aSu).build();
    }

    @Test
    public void ensureCustomerEqualsPassesForTheSameCustomerCode() throws Exception {

        final CandidateUser aCandidate = dummyCustomerUser(aEmail);

        final CandidateUser anotherCandidate = dummyCustomerUser(aEmail);

        final boolean expected = aCandidate.equals(anotherCandidate);

        assertTrue(expected);
    }

    @Test
    public void ensureCustomerEqualsAreTheSameForTheSameInstance() throws Exception {
        final CandidateUser aCandidate = dummyCustomerUser(aEmail);

        final boolean expected = aCandidate.equals(aCandidate);

        assertTrue(expected);
    }

    @Test
    public void ensureCustomerIsTheSameAsItsInstance() throws Exception {
        final CandidateUser aCandidate = dummyCustomerUser(aEmail);

        final boolean expected = aCandidate.sameAs(aCandidate);

        assertTrue(expected);
    }

    @Test
    public void ensureCandidateIsActivated() throws Exception {
        final CandidateUser aCandidate = dummyCustomerUser(aEmail);

        aCandidate.user().activate();

        assertTrue(aCandidate.user().isActive());
    }

    @Test
    public void ensureCandidateIsDeactivated() throws Exception {
        final CandidateUser aCandidate = dummyCustomerUser(aEmail);

        aCandidate.user().deactivate(Calendar.getInstance());
        assertTrue(!aCandidate.user().isActive());
    }

    @Test
    public void ensureCandidateIsDeactivatedAndActivated() throws Exception {
        final CandidateUser aCandidate = dummyCustomerUser(aEmail);

        aCandidate.user().deactivate(Calendar.getInstance());
        assertTrue(!aCandidate.user().isActive());

        aCandidate.user().activate();
        assertTrue(aCandidate.user().isActive());
    }

    @Test
    public void ensureCanNotDeactivateAnAlreadyDeactivatedCandidate() throws Exception {
        final CandidateUser aCandidate = dummyCustomerUser(aEmail);

        aCandidate.user().deactivate(Calendar.getInstance());
        assertTrue(!aCandidate.user().isActive());

        assertThrows(IllegalStateException.class, () -> {
            aCandidate.user().deactivate(Calendar.getInstance());
        });

    }
}
