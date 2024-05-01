package lapr4.jobs4u.jobopeningmanagement.application;

import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
import lapr4.jobs4u.jobopeningmanagement.dto.JobOpeningDTO;
import lapr4.jobs4u.jobopeningmanagement.repositories.JobOpeningRepository;
import lapr4.jobs4u.usermanagement.domain.BaseRoles;

import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;

@UseCaseController
public class ListJobOpeningsController {

    private final ListJobOpeningsService jobOpeningsService;
    private final AuthorizationService authz;

    public ListJobOpeningsController(JobOpeningRepository jobOpeningRepository, AuthorizationService authz) {
        this.jobOpeningsService = new ListJobOpeningsService(jobOpeningRepository, authz);
        this.authz = authz;
    }

    public Iterable<JobOpeningDTO> filterByCostumerManager() {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER);
        return jobOpeningsService.filterByCostumerManager();
    }

    public JobOpening selectedJobOpening(final JobOpeningDTO jobOpeningDTO) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER);
        return jobOpeningsService.selectedJobOpening(jobOpeningDTO);
    }
}
