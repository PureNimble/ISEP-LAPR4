package lapr4.jobs4u.applicationmanagement.application;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import lapr4.jobs4u.applicationmanagement.domain.Application;
import lapr4.jobs4u.applicationmanagement.domain.ApplicationBuilder;
import lapr4.jobs4u.applicationmanagement.domain.File;
import lapr4.jobs4u.applicationmanagement.repositories.ApplicationRepository;
import lapr4.jobs4u.candidatemanagement.domain.Candidate;
import lapr4.jobs4u.candidatemanagement.domain.CandidateBuilder;
import lapr4.jobs4u.customermanagement.domain.Customer;
import lapr4.jobs4u.customermanagement.domain.CustomerBuilder;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpeningBuilder;
import lapr4.jobs4u.recruitmentprocessmanagement.domain.Date;
import lapr4.jobs4u.usermanagement.domain.UserBuilderHelper;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.authz.domain.model.SystemUserBuilder;
import eapli.framework.io.util.Files;
import eapli.framework.time.util.CurrentTimeCalendars;
import lapr4.jobs4u.candidatemanagement.application.DisplayCandidateApplicationsController;

/**
 * @author 2DI2
 */
public class DisplayCandidateApplicationsControllerTest {

    @Mock
    private ApplicationRepository applicationRepository;

    @Mock
    private AuthorizationService authz;

    private DisplayCandidateApplicationsController controller;

    @BeforeEach
    public void setup() {
        controller = new DisplayCandidateApplicationsController(applicationRepository, authz);
    }

    @Test
    public void testFindApplicationsFromCandidate() {
        Candidate candidate = mock(Candidate.class);
        controller.findApplicationsFromCandidate(candidate);
        verify(authz).ensureAuthenticatedUserHasAnyOf(any());
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Test
    public void testPrintFrequentlyUsedWords() {
        List<Application> applications = new ArrayList<>();
        applications.add(dummyApplication("1"));
        applications = (List) controller.printFrequentlyUsedWords(applications);
        assertTrue(applications.iterator().hasNext());
        assertFalse(applications.get(0).toString().isEmpty());
    }

    private static Application dummyApplication(final String applicationNumber) {
        List<File> files = new ArrayList<File>();
        if (Files.currentDirectory().contains("jobs4u.core")) {
            files.add(File.valueOf("../jobs4u.applicationsFileBot/sprintc/resources/input/3-file-1.txt"));
            files.add(File.valueOf("../jobs4u.applicationsFileBot/sprintc/resources/input/1-candidate-data.txt"));
        } else {
            files.add(File.valueOf("jobs4u.applicationsFileBot/sprintc/resources/input/3-file-1.txt"));
            files.add(File.valueOf("jobs4u.applicationsFileBot/sprintc/resources/input/1-candidate-data.txt"));
        }
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
        final Customer aCustomer = customerBuilder.with("Fnac", "R. Sara Afonso 105, 4460-841 Sra. da Hora", "ABC123",
                "fnac@email.local", "910000000", aSu).build();
        ;

        JobOpening jobOpening = jobOpeningBuilder.with("12", "titleOrFunction", "VOLUNTEER", "HYBRID", "address",
                aCustomer, "jobDescription", CurrentTimeCalendars.now(), "24").build();

        return new ApplicationBuilder().with(applicationNumber, Date.today(), files, jobOpening, candidate).build();
    }

}