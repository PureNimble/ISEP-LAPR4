package lapr4.jobs4u.interviewmanagement.application;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

import eapli.framework.infrastructure.authz.application.AuthorizationService;
import lapr4.jobs4u.interviewmanagement.domain.Interview;
import lapr4.jobs4u.interviewmanagement.dto.InterviewDTO;
import lapr4.jobs4u.interviewmanagement.repositories.InterviewRepository;

/**
 * @author 2DI2
 */
public class RecordInterviewControllerTest {

    @Mock
    InterviewRepository mockRepo;

    @Mock
    AuthorizationService mockAuthz;

    @Mock
    Interview mockInterview;

    @Mock
    InterviewDTO mockInterviewDTO;

    RecordInterviewController controller;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        when(mockInterview.toDTO()).thenReturn(mockInterviewDTO);
        controller = new RecordInterviewController(mockRepo, mockAuthz);
    }

    @Test
    public void ensureSave() {
        controller.save(mockInterview);

        verify(mockInterview, times(1));
    }
}