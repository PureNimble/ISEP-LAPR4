package lapr4.jobs4u.applicationmanagement.application;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import eapli.framework.infrastructure.authz.application.AuthorizationService;
import lapr4.jobs4u.applicationmanagement.domain.Application;
import lapr4.jobs4u.interviewmanagement.domain.Interview;
import lapr4.jobs4u.interviewmanagement.repositories.InterviewRepository;
import lapr4.jobs4u.requirementmanagement.domain.Requirement;
import lapr4.jobs4u.requirementmanagement.repositories.RequirementRepository;
import lapr4.jobs4u.usermanagement.domain.BaseRoles;

/**
 * @author 2DI2
 */
public class DisplayApplicationDataControllerTest {

    private DisplayApplicationDataService displayApplicationDataService;

    @Mock
    private AuthorizationService authz;

    @Mock
    private RequirementRepository requirementRepository;

    @Mock
    private InterviewRepository interviewRepository;

    private DisplayApplicationDataController controller;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        controller = new DisplayApplicationDataController(requirementRepository, interviewRepository, authz);
        displayApplicationDataService = new DisplayApplicationDataService(requirementRepository, interviewRepository);
    }

    @Test
    public void testGetApplicationRequirementFile() {
        Application application = mock(Application.class);
        Requirement expectedRequirement = mock(Requirement.class);
        when(displayApplicationDataService.getApplicationRequirementFile(application))
                .thenReturn(Optional.of(expectedRequirement));

        Optional<Requirement> result = controller.getApplicationRequirementFile(application);

        verify(authz).ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER, BaseRoles.POWERUSER);
        assertTrue(result.isPresent());
        assertEquals(expectedRequirement, result.get());
    }

    @Test
    public void testGetApplicationInterviewFile() {
        Application application = mock(Application.class);
        Interview expectedInterview = mock(Interview.class);
        when(displayApplicationDataService.getApplicationInterviewFile(application))
                .thenReturn(Optional.of(expectedInterview));

        Optional<Interview> result = controller.getApplicationInterviewFile(application);

        verify(authz).ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER, BaseRoles.POWERUSER);
        assertTrue(result.isPresent());
        assertEquals(expectedInterview, result.get());
    }
}
