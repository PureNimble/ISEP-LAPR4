package lapr4.jobs4u.candidatemanagement.domain;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import eapli.framework.infrastructure.authz.domain.model.Role;
import lapr4.jobs4u.usermanagement.domain.BaseRoles;

public class CandidateTest {

    private final String aEmail = "candidate@email.local";
    private final String anotherEmail = "another@email.local";

    public static Candidate dummyCandidate(final String email) {
        // should we load from spring context?
        final CandidateBuilder candidateBuilder = new CandidateBuilder();
        return candidateBuilder.with("Candidate", "Candidate", email, "910000000").build();
    }

    private Candidate getNewDummyCandidate(final String email) {
        return dummyCandidate(email);
    }

    @Test
    public void ensureCandidateEqualsPassesForTheSameEmail() throws Exception {

        final Candidate aCustomer = getNewDummyCandidate(aEmail);

        final Candidate anotherCustomer = getNewDummyCandidate(aEmail);

        final boolean expected = aCustomer.equals(anotherCustomer);

        assertTrue(expected);
    }

    @Test
    public void ensureCandidateEqualsFailsForDifferenteEmail() throws Exception {
        final Set<Role> roles = new HashSet<>();
        roles.add(BaseRoles.ADMIN);

        final Candidate aCustomer = getNewDummyCandidate(aEmail);

        final Candidate anotherCustomer = getNewDummyCandidate(anotherEmail);

        final boolean expected = aCustomer.equals(anotherCustomer);

        assertFalse(expected);
    }

    @Test
    public void ensureCandidateEqualsAreTheSameForTheSameInstance() throws Exception {
        final Candidate aCustomer = getNewDummyCandidate(aEmail);

        final boolean expected = aCustomer.equals(aCustomer);

        assertTrue(expected);
    }

    @Test
    public void ensureCandidateEqualsFailsForDifferenteObjectTypes() throws Exception {
        final Candidate aCustomer = getNewDummyCandidate(aEmail);

        final boolean expected = aCustomer.equals(getNewDummyCandidate(anotherEmail));

        assertFalse(expected);
    }

    @Test
    public void ensureCandidateIsTheSameAsItsInstance() throws Exception {
        final Candidate aCustomer = getNewDummyCandidate(aEmail);

        final boolean expected = aCustomer.sameAs(aCustomer);

        assertTrue(expected);
    }

    @Test
    public void ensureTwoCandidatesWithDifferentEmailAreNotTheSame() throws Exception {
        final Candidate aCustomer = dummyCandidate(aEmail);
        final Candidate anotherCustomer = dummyCandidate(anotherEmail);

        final boolean expected = aCustomer.sameAs(anotherCustomer);

        assertFalse(expected);
    }
}
