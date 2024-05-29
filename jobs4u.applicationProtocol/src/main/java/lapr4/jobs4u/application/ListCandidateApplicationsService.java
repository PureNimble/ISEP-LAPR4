package lapr4.jobs4u.application;

import eapli.framework.general.domain.model.EmailAddress;
import lapr4.jobs4u.applicationmanagement.domain.Application;
import lapr4.jobs4u.applicationmanagement.domain.ApplicationCode;
import lapr4.jobs4u.applicationmanagement.dto.ApplicationDTO;
import lapr4.jobs4u.applicationmanagement.repositories.ApplicationRepository;
import lapr4.jobs4u.candidatemanagement.domain.Candidate;
import lapr4.jobs4u.candidatemanagement.repositories.CandidateRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author 2DI2
 */
@Component
public class ListCandidateApplicationsService {

    private final ApplicationRepository applicationRepository;
    private final CandidateRepository candidateRepository;

    public ListCandidateApplicationsService(ApplicationRepository applicationRepository, CandidateRepository candidateRepository) {
        this.applicationRepository = applicationRepository;
        this.candidateRepository = candidateRepository;
    }

    public Iterable<ApplicationDTO> findApplicationsFromCandidate(final EmailAddress emailAddress) {
        final Optional<Candidate> candidate = this.candidateRepository.findByEmail(emailAddress);
        if (candidate.isPresent()) {
            final Iterable<Application> applications = this.applicationRepository.findApplicationsFromCandidate(candidate.get());
            List<ApplicationDTO> applicationsDTO = new ArrayList<>();
            applications.forEach(application -> applicationsDTO.add(application.toDTO()));
            return applicationsDTO;
        } else {
            return null;
        }
    }

    public Integer numApplicants(ApplicationDTO applicationDTO) {
        Application selectedCandidate = applicationRepository
                .ofIdentity(ApplicationCode.valueOf(applicationDTO.getApplicationCode()))
                .orElseThrow(IllegalArgumentException::new);

        Iterable<Application> iterable = applicationRepository.findApplicationWithInterviewRecord(selectedCandidate.getJobOpening());
        int returnValue = 0;
        for (Application ignored : iterable) {
             returnValue++;
        }
        return returnValue;
    }

}