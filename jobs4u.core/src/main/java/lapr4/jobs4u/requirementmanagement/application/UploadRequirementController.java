package lapr4.jobs4u.requirementmanagement.application;

import java.io.IOException;
import java.util.Optional;

import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import lapr4.jobs4u.applicationmanagement.domain.Application;
import lapr4.jobs4u.applicationmanagement.domain.File;
import lapr4.jobs4u.requirementmanagement.domain.Requirement;
import lapr4.jobs4u.requirementmanagement.repositories.RequirementRepository;
import lapr4.jobs4u.usermanagement.domain.BaseRoles;

/**
 * @author 2DI2
 */
@UseCaseController
public class UploadRequirementController {
    private final UploadRequirementService uploadRequirementService;
    private final AuthorizationService authz;

    public UploadRequirementController(final RequirementRepository requirementRepository, final AuthorizationService authz) {
        this.uploadRequirementService = new UploadRequirementService(requirementRepository);
        this.authz = authz;
    }

    public void registerRequirement(final Requirement requirement, final String filePath) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER, BaseRoles.POWERUSER);
        final File file = File.valueOf(filePath);
        uploadRequirementService.registerRequirement(requirement, file);
    }

    public boolean isCorrectRequirement(final Requirement requirement, final String filePath) throws IOException {
        return uploadRequirementService.isCorrectRequirement(requirement, filePath);
    }

    public Requirement findRequirement(final Application application) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER, BaseRoles.POWERUSER);
        Optional<Requirement> i = uploadRequirementService.findRequirement(application);

        if (i.isPresent()) {
            return i.get();
        }
        return null;
    }

}