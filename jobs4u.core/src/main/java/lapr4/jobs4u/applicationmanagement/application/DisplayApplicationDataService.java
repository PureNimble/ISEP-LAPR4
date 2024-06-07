package lapr4.jobs4u.applicationmanagement.application;

import java.util.Optional;

import lapr4.jobs4u.applicationmanagement.domain.Application;
import lapr4.jobs4u.interviewmanagement.domain.Interview;
import lapr4.jobs4u.interviewmanagement.repositories.InterviewRepository;
import lapr4.jobs4u.requirementmanagement.domain.Requirement;
import lapr4.jobs4u.requirementmanagement.repositories.RequirementRepository;

/**
 * @author 2DI2
 */
public class DisplayApplicationDataService {

    private final RequirementRepository requirementRepository;
    private final InterviewRepository interviewRepository;

    public DisplayApplicationDataService(final RequirementRepository requirementRepository,
            final InterviewRepository interviewRepository) {
        this.requirementRepository = requirementRepository;
        this.interviewRepository = interviewRepository;
    }

    public Optional<Requirement> getApplicationRequirementFile(final Application application) {
        return requirementRepository.findRequirement(application);
    }

    public Optional<Interview> getApplicationInterviewFile(final Application application) {
        return interviewRepository.findInterviewByApplication(application);
    }

}
