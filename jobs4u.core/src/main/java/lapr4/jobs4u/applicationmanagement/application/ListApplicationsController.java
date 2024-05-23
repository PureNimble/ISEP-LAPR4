package lapr4.jobs4u.applicationmanagement.application;

import lapr4.jobs4u.applicationmanagement.domain.Application;
import lapr4.jobs4u.applicationmanagement.dto.ApplicationDTO;
import lapr4.jobs4u.applicationmanagement.repositories.ApplicationRepository;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
import lapr4.jobs4u.usermanagement.domain.BaseRoles;

import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;

@UseCaseController
public class ListApplicationsController {

    private final ListApplicationsService applicationService;
    private final AuthorizationService authz;

    public ListApplicationsController(ApplicationRepository applicationRepository, AuthorizationService authz) {
        this.applicationService = new ListApplicationsService(applicationRepository);
        this.authz = authz;
    }

    public Iterable<ApplicationDTO> filterByJobOpening(final JobOpening jobOpening) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER, BaseRoles.POWERUSER);
        return applicationService.filterByJobOpening(jobOpening);
    }

    public Application selectedApplication(final ApplicationDTO applicationDTO) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER, BaseRoles.POWERUSER);
        return applicationService.selectedApplication(applicationDTO);
    }

    public Iterable<ApplicationDTO> findApplicationWithInterviewRecord(final JobOpening jobOpening) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER, BaseRoles.POWERUSER);
        return applicationService.findApplicationWithInterviewRecord(jobOpening);
    }
}
