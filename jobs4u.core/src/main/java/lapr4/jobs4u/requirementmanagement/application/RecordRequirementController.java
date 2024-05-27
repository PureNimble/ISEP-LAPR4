package lapr4.jobs4u.requirementmanagement.application;

import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import lapr4.jobs4u.requirementmanagement.domain.Requirement;
import lapr4.jobs4u.requirementmanagement.repositories.RequirementRepository;
import lapr4.jobs4u.usermanagement.domain.BaseRoles;

/**
 * @author Paulo Gandra de Sousa 2024.04.30
 */
@UseCaseController
public class RecordRequirementController {
    private final RequirementRepository requirementRepository;
    private final AuthorizationService authz;

    public RecordRequirementController(RequirementRepository requirementRepository, AuthorizationService authz) {
        this.requirementRepository = requirementRepository;
        this.authz = authz;
    }

    public void save(Requirement requirement) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER, BaseRoles.POWERUSER);
        requirementRepository.save(requirement);
    }

}