package lapr4.jobs4u.applicationmanagement.application;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import eapli.framework.infrastructure.authz.application.AuthorizationService;
import lapr4.jobs4u.applicationmanagement.domain.Application;
import lapr4.jobs4u.applicationmanagement.repositories.ApplicationRepository;
import lapr4.jobs4u.interviewmanagement.domain.Interview;
import lapr4.jobs4u.interviewmanagement.repositories.InterviewRepository;
import lapr4.jobs4u.requirementmanagement.domain.Requirement;
import lapr4.jobs4u.requirementmanagement.repositories.RequirementRepository;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author 2DI2
 */
class DisplayApplicationDataServiceTest {

    @Mock
    private ApplicationRepository applicationRepository;

    @Mock
    private RequirementRepository requirementRepository;

    @Mock
    private InterviewRepository interviewRepository;

    @Mock
    private AuthorizationService authz;

    private DisplayApplicationDataService service;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        service = new DisplayApplicationDataService(requirementRepository, interviewRepository);
    }

    @Test
    public void testGetApplicationRequirementFile() {
        Application application = mock(Application.class);
        Requirement expectedRequirement = mock(Requirement.class);
        when(requirementRepository.findRequirement(application)).thenReturn(Optional.of(expectedRequirement));

        Optional<Requirement> result = service.getApplicationRequirementFile(application);

        assertTrue(result.isPresent());
        assertEquals(expectedRequirement, result.get());
    }

    @Test
    public void testGetApplicationInterviewFile() {
        Application application = mock(Application.class);
        Interview expectedInterview = mock(Interview.class);
        when(interviewRepository.findInterviewByApplication(application)).thenReturn(Optional.of(expectedInterview));

        Optional<Interview> result = service.getApplicationInterviewFile(application);

        assertTrue(result.isPresent());
        assertEquals(expectedInterview, result.get());
    }
}