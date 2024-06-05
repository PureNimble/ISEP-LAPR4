package lapr4.jobs4u.interviewmanagement.application;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import eapli.framework.infrastructure.authz.application.AuthorizationService;
import lapr4.jobs4u.interviewmanagement.domain.Interview;
import lapr4.jobs4u.interviewmanagement.dto.InterviewDTO;
import lapr4.jobs4u.interviewmanagement.repositories.InterviewRepository;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
import lapr4.jobs4u.usermanagement.domain.BaseRoles;

/**
 * @author 2DI2
 */
public class ListCandidatesByInterviewPointsControllerTest {

    @Mock
    InterviewRepository mockRepo;

    @Mock
    AuthorizationService mockAuthz;

    @Mock
    JobOpening mockJobOpening;

    @Mock
    Interview mockInterview;

    @Mock
    InterviewDTO mockInterviewDTO;

    ListCandidatesByInterviewPointsController controller;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        when(mockInterview.toDTO()).thenReturn(mockInterviewDTO);
        when(mockRepo.sortedInterviewsByJobOpening(mockJobOpening, false)).thenReturn(Arrays.asList(mockInterview));
        controller = new ListCandidatesByInterviewPointsController(mockRepo, mockAuthz);
    }

    @Test
    void testAllCandidatesSortedByInterviewPointsForJobOpeningNotNull() {
        Iterable<InterviewDTO> result = controller.allCandidatesSortedByInterviewPointsForJobOpening(mockJobOpening,
                false);
        assertNotNull(result);
    }

    @Test
    void testAllCandidatesSortedByInterviewPointsForJobOpeningReturnsExpectedInterviews() {
        Iterable<InterviewDTO> result = controller.allCandidatesSortedByInterviewPointsForJobOpening(mockJobOpening,
                false);
        List<InterviewDTO> resultList = (List<InterviewDTO>) result;
        assertEquals(mockInterviewDTO, resultList.get(0));
    }

    @Test
    void testAllCandidatesSortedByInterviewPointsForJobOpeningCallsEnsureAuthenticatedUserHasAnyOf() {
        controller.allCandidatesSortedByInterviewPointsForJobOpening(mockJobOpening, false);
        verify(mockAuthz).ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER, BaseRoles.POWERUSER);
    }
}