package lapr4.jobs4u.jobopeningmanagement.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
import lapr4.jobs4u.jobopeningmanagement.domain.JobReference;
import lapr4.jobs4u.jobopeningmanagement.dto.JobOpeningDTO;
import lapr4.jobs4u.jobopeningmanagement.repositories.JobOpeningRepository;
import lapr4.jobs4u.usermanagement.domain.BaseRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

@Component
public class ListJobOpeningsService {

    private final JobOpeningRepository jobOpeningRepository;
    private final AuthorizationService authz;

    public ListJobOpeningsService(JobOpeningRepository jobOpeningRepository, AuthorizationService authz) {
        this.jobOpeningRepository = jobOpeningRepository;
        this.authz = authz;
    }

    public Iterable<JobOpeningDTO> filterByCostumerManager() {
        final SystemUser manager = authz.loggedinUserWithPermissions(BaseRoles.CUSTOMER_MANAGER)
                .orElseThrow(IllegalStateException::new);
        final Iterable<JobOpening> jobOpenings = this.jobOpeningRepository.filterByCostumerManager(manager.username());

        List<JobOpeningDTO> jobOpeningsDTO = new ArrayList<>();
        jobOpenings.forEach(jobOpening -> jobOpeningsDTO.add(jobOpening.toDTO()));
        return jobOpeningsDTO;
    }

    public Optional<JobOpening> findJobOpeningByReference(JobReference jobReference) {
        Optional<JobOpening> jobOpening = jobOpeningRepository.findJobOpeningByReference(jobReference);
        return jobOpening;
    }

    public JobOpening selectedJobOpening(JobOpeningDTO jobOpeningDTO) {
        JobOpening selectedJobOpening = jobOpeningRepository
                .ofIdentity(JobReference.valueOf(jobOpeningDTO.getJobReference()))
                .orElseThrow(IllegalArgumentException::new);
        return selectedJobOpening;
    }

}
