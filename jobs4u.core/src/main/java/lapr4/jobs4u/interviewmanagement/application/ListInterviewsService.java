package lapr4.jobs4u.interviewmanagement.application;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import lapr4.jobs4u.interviewmanagement.domain.Interview;
import lapr4.jobs4u.interviewmanagement.dto.InterviewDTO;
import lapr4.jobs4u.interviewmanagement.repositories.InterviewRepository;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;

/**
 * @author 2DI2
 */
@Component
public class ListInterviewsService {

    private final InterviewRepository interviewRepository;

    public ListInterviewsService(InterviewRepository interviewRepository) {
        this.interviewRepository = interviewRepository;
    }

    public Iterable<InterviewDTO> sortedInterviewsByJobOpening(final JobOpening jobOpening, final boolean ascending) {
        final Iterable<Interview> interviews = this.interviewRepository.sortedInterviewsByJobOpening(jobOpening,
                ascending);
        List<InterviewDTO> InterviewsDTOS = new ArrayList<>();
        interviews.forEach(interview -> InterviewsDTOS.add(interview.toDTO()));
        return InterviewsDTOS;
    }

}
