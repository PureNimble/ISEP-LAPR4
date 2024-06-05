package lapr4.jobs4u.interviewmanagement.application;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import lapr4.jobs4u.interviewmanagement.domain.Interview;
import lapr4.jobs4u.interviewmanagement.dto.InterviewDTO;
import lapr4.jobs4u.interviewmanagement.repositories.InterviewRepository;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;

/**
 * @author 2DI2
 */
public class ListInterviewsServiceTest {

    @Mock
    InterviewRepository mockRepo;

    @Mock
    JobOpening mockJobOpening;

    @Mock
    Interview mockInterview;

    @Mock
    InterviewDTO mockInterviewDTO;

    ListInterviewsService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        when(mockInterview.toDTO()).thenReturn(mockInterviewDTO);
        when(mockRepo.sortedInterviewsByJobOpening(mockJobOpening, false)).thenReturn(Arrays.asList(mockInterview));
        service = new ListInterviewsService(mockRepo);
    }

    @Test
    void testSortedInterviewsByJobOpeningNotNull() {
        Iterable<InterviewDTO> result = service.sortedInterviewsByJobOpening(mockJobOpening, false);
        assertNotNull(result);
    }

    @Test
    void testSortedInterviewsByJobOpeningReturnsExpectedInterviews() {
        Iterable<InterviewDTO> result = service.sortedInterviewsByJobOpening(mockJobOpening, false);
        List<InterviewDTO> resultList = (List<InterviewDTO>) result;
        assertEquals(mockInterviewDTO, resultList.get(0));
    }

    @Test
    void testSortedInterviewsByJobOpeningCallsSortedInterviewsByJobOpening() {
        service.sortedInterviewsByJobOpening(mockJobOpening, false);
        verify(mockRepo).sortedInterviewsByJobOpening(mockJobOpening, false);
    }
}