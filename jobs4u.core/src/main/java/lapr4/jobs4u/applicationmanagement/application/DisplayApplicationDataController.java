package lapr4.jobs4u.applicationmanagement.application;

import java.util.Optional;

import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import lapr4.jobs4u.applicationmanagement.domain.Application;
import lapr4.jobs4u.interviewmanagement.domain.Interview;
import lapr4.jobs4u.interviewmanagement.repositories.InterviewRepository;
import lapr4.jobs4u.requirementmanagement.domain.Requirement;
import lapr4.jobs4u.requirementmanagement.repositories.RequirementRepository;
import lapr4.jobs4u.usermanagement.domain.BaseRoles;

/**
 * @author 2DI2
 */
@UseCaseController
public class DisplayApplicationDataController {

    private final DisplayApplicationDataService displayApplicationDataService;
    private final AuthorizationService authz;

    public DisplayApplicationDataController(final RequirementRepository requirementRepository,
            final InterviewRepository interviewRepository, final AuthorizationService authz) {
        this.displayApplicationDataService = new DisplayApplicationDataService(requirementRepository,
                interviewRepository);
        this.authz = authz;
    }

    public Optional<Requirement> getApplicationRequirementFile(final Application application) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER, BaseRoles.POWERUSER);
        return displayApplicationDataService.getApplicationRequirementFile(application);
    }

    public Optional<Interview> getApplicationInterviewFile(final Application application) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER, BaseRoles.POWERUSER);
        return displayApplicationDataService.getApplicationInterviewFile(application);
    }
}
