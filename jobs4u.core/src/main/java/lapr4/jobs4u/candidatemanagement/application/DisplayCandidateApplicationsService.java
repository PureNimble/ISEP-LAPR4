package lapr4.jobs4u.candidatemanagement.application;

import eapli.framework.infrastructure.authz.application.AuthorizationService;
import lapr4.jobs4u.applicationmanagement.domain.Application;
import lapr4.jobs4u.applicationmanagement.domain.ApplicationCode;
import lapr4.jobs4u.applicationmanagement.dto.ApplicationDTO;
import lapr4.jobs4u.applicationmanagement.repositories.ApplicationRepository;
import lapr4.jobs4u.candidatemanagement.domain.Candidate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DisplayCandidateApplicationsService {

    private final ApplicationRepository applicationRepository;
    private final AuthorizationService authz;

    public DisplayCandidateApplicationsService(ApplicationRepository applicationRepository, AuthorizationService authz) {
        this.applicationRepository = applicationRepository;
        this.authz = authz;
    }

    public Iterable<ApplicationDTO> findApplicationsFromCandidate(final Candidate candidate) {
        final Iterable<Application> applications = this.applicationRepository.findApplicationsFromCandidate(candidate);

        List<ApplicationDTO> applicationsDTO = new ArrayList<>();
        applications.forEach(application -> applicationsDTO.add(application.toDTO()));
        return applicationsDTO;
    }

    public Application selectedApplication(ApplicationDTO applicationDTO) {
        Application selectedJobOpening = applicationRepository
                .ofIdentity(ApplicationCode.valueOf(applicationDTO.getApplicationCode()))
                .orElseThrow(IllegalArgumentException::new);
        return selectedJobOpening;
    }

}