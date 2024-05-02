package lapr4.jobs4u.applicationmanagement.application;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

import lapr4.jobs4u.applicationmanagement.domain.Application;
import lapr4.jobs4u.applicationmanagement.domain.ApplicationCode;
import lapr4.jobs4u.applicationmanagement.dto.ApplicationDTO;
import lapr4.jobs4u.applicationmanagement.repositories.ApplicationRepository;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
import eapli.framework.infrastructure.authz.application.AuthorizationService;

@Component
public class ListApplicationsService {

    private final ApplicationRepository applicationRepository;
    private final AuthorizationService authz;

    public ListApplicationsService(ApplicationRepository applicationRepository, AuthorizationService authz) {
        this.applicationRepository = applicationRepository;
        this.authz = authz;
    }

    public Iterable<ApplicationDTO> filterByJobOpening(final JobOpening jobOpening) {
        final Iterable<Application> applications = this.applicationRepository.filterByJobOpening(jobOpening);

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