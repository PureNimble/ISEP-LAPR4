package lapr4.jobs4u.candidatemanagement.application;

import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import lapr4.jobs4u.applicationmanagement.domain.Application;
import lapr4.jobs4u.applicationmanagement.dto.ApplicationDTO;
import lapr4.jobs4u.applicationmanagement.repositories.ApplicationRepository;
import lapr4.jobs4u.candidatemanagement.domain.Candidate;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
import lapr4.jobs4u.usermanagement.domain.BaseRoles;

@UseCaseController
public class DisplayCandidateApplicationsController {

    private final DisplayCandidateApplicationsService applicationService;
    private final AuthorizationService authz;

    public DisplayCandidateApplicationsController(ApplicationRepository applicationRepository, AuthorizationService authz) {
        this.applicationService = new DisplayCandidateApplicationsService(applicationRepository, authz);
        this.authz = authz;
    }

    public Iterable<ApplicationDTO> findApplicationsFromCandidate(final Candidate candidate) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER);
        return applicationService.findApplicationsFromCandidate(candidate);
    }

    public Application selectedApplication(final ApplicationDTO applicationDTO) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER);
        return applicationService.selectedApplication(applicationDTO);
    }
}
