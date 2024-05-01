package lapr4.jobs4u.applicationmanagement.domain;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.authz.domain.model.SystemUserBuilder;
import lapr4.jobs4u.candidatemanagement.domain.Candidate;
import lapr4.jobs4u.candidatemanagement.domain.CandidateBuilder;
import lapr4.jobs4u.customermanagement.domain.Customer;
import lapr4.jobs4u.customermanagement.domain.CustomerBuilder;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpeningBuilder;
import lapr4.jobs4u.recruitmentprocessmanagement.domain.Date;
import lapr4.jobs4u.usermanagement.domain.UserBuilderHelper;

public class ApplicationTest {

    static final String APPLICATION_NUMBER = "1";
    static final String APPLICATION_NUMBER2 = "2";

    public static Application dummyApplication(final String applicationNumber) {
        List<File> files = new ArrayList<File>();
        File file1 = File.valueOf("shared/temp");
        files.add(file1);
        // candidateBuilder
        final CandidateBuilder candidateBuilder = new CandidateBuilder();
        final SystemUserBuilder userBuilder = UserBuilderHelper.builder();
        final SystemUser creator = userBuilder
                .with("manager@email.local", "Pass123", "firstName", "lastName", "manager@email.local").build();

        Candidate candidate = candidateBuilder.with("Candidate", "Candidate", "user@mail.local", "910000000", creator)
                .build();

        // jobOpeningBuilder
        final JobOpeningBuilder jobOpeningBuilder = new JobOpeningBuilder();
        final CustomerBuilder customerBuilder = new CustomerBuilder();
        final SystemUser aSu = userBuilder
                .with("username@email.local", "Pass123", "firstName", "lastName", "email@email.local").build();
        final Customer aCustomer = customerBuilder
                .with("Fnac", "R. Sara Afonso 105, 4460-841 Sra. da Hora", "abcdefghij",
                        "fnac@email.local", "910000000", aSu)
                .build();
        ;

        JobOpening jobOpening = jobOpeningBuilder.with("12", "titleOrFunction", "VOLUNTEER",
                "HYBRID", "address", aCustomer, "jobDescription").build();

        return new ApplicationBuilder()
                .with(applicationNumber, Date.today(), files, jobOpening, candidate).build();
    }

    private Application getNewDummyApplication(final String applicationNumber) {
        return dummyApplication(applicationNumber);
    }

    @Test
    public void ensureApplicationEqualsPassesForTheSameApplicationValues() throws Exception {

        final Application aApplication = getNewDummyApplication(APPLICATION_NUMBER);

        final Application anotherApplication = getNewDummyApplication(APPLICATION_NUMBER);

        final boolean expected = aApplication.equals(anotherApplication);

        assertTrue(expected);
    }

    @Test
    public void ensureApplicationEqualsFailsForDifferenteApplicationValues() throws Exception {

        final Application aApplication = getNewDummyApplication(APPLICATION_NUMBER);

        final Application anotherApplication = getNewDummyApplication(APPLICATION_NUMBER2);

        final boolean expected = aApplication.equals(anotherApplication);

        assertFalse(expected);
    }

    @Test
    public void ensureApplicationEqualsAreTheSameForTheSameInstance() throws Exception {
        final Application applicationaApplication = getNewDummyApplication(APPLICATION_NUMBER);

        final boolean expected = applicationaApplication.equals(applicationaApplication);

        assertTrue(expected);
    }

    @Test
    public void ensureApplicationEqualsFailsForDifferenteObjectTypes() throws Exception {
        final Application application = getNewDummyApplication(APPLICATION_NUMBER);

        final boolean expected = application.equals(getNewDummyApplication(APPLICATION_NUMBER2));

        assertFalse(expected);
    }

}
