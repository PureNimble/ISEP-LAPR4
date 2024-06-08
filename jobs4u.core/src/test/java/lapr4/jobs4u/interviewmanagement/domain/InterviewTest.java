package lapr4.jobs4u.interviewmanagement.domain;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.authz.domain.model.SystemUserBuilder;
import eapli.framework.io.util.Files;
import eapli.framework.time.util.CurrentTimeCalendars;
import lapr4.jobs4u.applicationmanagement.domain.Application;
import lapr4.jobs4u.applicationmanagement.domain.ApplicationBuilder;
import lapr4.jobs4u.applicationmanagement.domain.File;
import lapr4.jobs4u.candidatemanagement.domain.Candidate;
import lapr4.jobs4u.candidatemanagement.domain.CandidateBuilder;
import lapr4.jobs4u.customermanagement.domain.Customer;
import lapr4.jobs4u.customermanagement.domain.CustomerBuilder;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpeningBuilder;
import lapr4.jobs4u.recruitmentprocessmanagement.domain.Date;
import lapr4.jobs4u.usermanagement.domain.UserBuilderHelper;

/**
 * @author 2DI2
 */
public class InterviewTest {

        static final String APPLICATION_NUMBER = "1";
        static final String APPLICATION_NUMBER2 = "2";

        public Application dummyApplication(final String applicationNumber) {
                List<File> files = new ArrayList<File>();
                if (Files.currentDirectory().contains("jobs4u.core")) {
                        files.add(File.valueOf(
                                        "../jobs4u.applicationsFileBot/sprintc/resources/input/1-candidate-data.txt"));
                } else {
                        files.add(File.valueOf(
                                        "jobs4u.applicationsFileBot/sprintc/resources/input/1-candidate-data.txt"));
                }
                // candidateBuilder
                final CandidateBuilder candidateBuilder = new CandidateBuilder();
                final SystemUserBuilder userBuilder = UserBuilderHelper.builder();
                final SystemUser creator = userBuilder
                                .with("manager@email.local", "Pass123", "firstName", "lastName", "manager@email.local")
                                .build();

                Candidate candidate = candidateBuilder
                                .with("Candidate", "Candidate", "user@mail.local", "910000000", creator).build();

                // jobOpeningBuilder
                final JobOpeningBuilder jobOpeningBuilder = new JobOpeningBuilder();
                final CustomerBuilder customerBuilder = new CustomerBuilder();
                final SystemUser aSu = userBuilder
                                .with("username@email.local", "Pass123", "firstName", "lastName", "email@email.local")
                                .build();
                final Customer aCustomer = customerBuilder.with("Fnac", "R. Sara Afonso 105, 4460-841 Sra. da Hora",
                                "ABC123", "fnac@email.local", "910000000", aSu).build();
                ;

                JobOpening jobOpening = jobOpeningBuilder.with("12", "titleOrFunction", "VOLUNTEER", "HYBRID",
                                "address", aCustomer, "jobDescription", CurrentTimeCalendars.now(), "24").build();

                return new ApplicationBuilder().with(applicationNumber, Date.today(), files, jobOpening, candidate)
                                .build();
        }

        private Application getNewDummyApplication(final String applicationNumber) {
                return dummyApplication(applicationNumber);
        }

        @Test
        public void ensureApplicationEqualsPassesForTheSameApplicationValues() throws Exception {

                Interview i = Interview.valueOf(Date.today().toString(), "10:00",
                                getNewDummyApplication(APPLICATION_NUMBER));
                Interview i2 = Interview.valueOf(Date.today().toString(), "10:00",
                                getNewDummyApplication(APPLICATION_NUMBER));

                final boolean expected = i.equals(i2);

                assertTrue(expected);
        }

        @Test
        public void ensureApplicationEqualsFailsForDifferenteApplicationValues() throws Exception {

                Interview i = Interview.valueOf(Date.today().toString(), "10:00",
                                getNewDummyApplication(APPLICATION_NUMBER));
                Interview i2 = Interview.valueOf(Date.today().toString(), "09:00",
                                getNewDummyApplication(APPLICATION_NUMBER2));

                final boolean expected = i.equals(i2);

                assertTrue(expected);
        }

        @Test
        public void ensureApplicationEqualsAreTheSameForTheSameInstance() throws Exception {
                Interview i = Interview.valueOf(Date.today().toString(), "10:00",
                                getNewDummyApplication(APPLICATION_NUMBER));

                final boolean expected = i.equals(i);

                assertTrue(expected);
        }

        @Test
        public void ensureApplicationEqualsFailsForDifferenteObjectTypes() throws Exception {
                Interview i = Interview.valueOf(Date.today().toString(), Time.now().toString(),
                                getNewDummyApplication(APPLICATION_NUMBER));

                final boolean expected = i.equals(Interview.valueOf(Date.today().toString(), Time.now().toString(),
                                getNewDummyApplication(APPLICATION_NUMBER2)));

                assertTrue(expected);
        }

        @Test
        public void testInterviewCreationWithNullDate() {
                assertThrows(IllegalArgumentException.class, () -> {
                        Interview.valueOf(null, "10:00", getNewDummyApplication(APPLICATION_NUMBER));
                });
        }

        @Test
        public void testInterviewCreationWithNullTime() {
                assertThrows(IllegalArgumentException.class, () -> {
                        Interview.valueOf(Date.today().toString(), null, getNewDummyApplication(APPLICATION_NUMBER));
                });
        }

        @Test
        public void testInterviewCreationWithNullApplication() {
                assertThrows(IllegalArgumentException.class, () -> {
                        Interview.valueOf(Date.today().toString(), "10:00", null);
                });
        }

        @Test
        public void testInterviewCreationWithInvalidTime() {
                assertThrows(IllegalArgumentException.class, () -> {
                        Interview.valueOf(Date.today().toString(), "25:00", getNewDummyApplication(APPLICATION_NUMBER));
                });
        }

        @Test
        public void testInterviewCreationWithInvalidDate() {
                assertThrows(IllegalArgumentException.class, () -> {
                        Interview.valueOf("2022-13-32", "10:00", getNewDummyApplication(APPLICATION_NUMBER));
                });
        }

}
