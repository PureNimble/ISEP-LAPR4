package lapr4.jobs4u.applicationmanagement.application;

import lapr4.jobs4u.applicationmanagement.domain.Application;
import lapr4.jobs4u.applicationmanagement.dto.ApplicationDTO;
import lapr4.jobs4u.applicationmanagement.repositories.ApplicationRepository;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
import lapr4.jobs4u.usermanagement.domain.BaseRoles;

import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;

/**
 * @author 2DI2
 */
@UseCaseController
public class ListApplicationsController {

    private final ListApplicationsService applicationService;
    private final AuthorizationService authz;

    public ListApplicationsController(final ApplicationRepository applicationRepository, final AuthorizationService authz) {
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

    public Iterable<ApplicationDTO> unrankedApplicationByJobOpening(final JobOpening jobOpening) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER, BaseRoles.POWERUSER);
        return applicationService.unrankedApplicationByJobOpening(jobOpening);
    }
}
