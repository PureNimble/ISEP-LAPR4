package lapr4.jobs4u.requirementmanagement.application;

import java.util.Optional;

import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
import lapr4.jobs4u.jobopeningmanagement.repositories.JobOpeningRequirementRepository;
import lapr4.jobs4u.questionmanagement.repositories.RequirementsQuestionRepository;
import lapr4.jobs4u.recruitmentprocessmanagement.repositories.RecruitmentProcessRepository;
import lapr4.jobs4u.requirementmanagement.repositories.RequirementRepository;
import lapr4.jobs4u.usermanagement.domain.BaseRoles;

/**
 * @author 2DI2
 */
@UseCaseController
public class EvaluateRequirementsController {

    private final RecruitmentProcessRepository recruitmentProcessRepository;
    private final EvaluateRequirementsService evaluateRequirementsService;
    private final AuthorizationService authz;

    public EvaluateRequirementsController(final RequirementsQuestionRepository RequirementsQuestionRepository,
            final RecruitmentProcessRepository recruitmentProcessRepository,
            final JobOpeningRequirementRepository jobOpeningRequirementRepository,
            final RequirementRepository RequirementRepository,
            final AuthorizationService authz) {
        this.recruitmentProcessRepository = recruitmentProcessRepository;
        this.evaluateRequirementsService = new EvaluateRequirementsService(RequirementRepository, jobOpeningRequirementRepository, RequirementsQuestionRepository);
        this.authz = authz;
    }

    public void evaluateRequirement(final JobOpening jobOpening) throws Exception {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER, BaseRoles.POWERUSER);
        evaluateRequirementsService.evaluateRequirement(jobOpening);
    }

    public String currentPhase(final JobOpening jobOpening) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER, BaseRoles.POWERUSER);
        Optional<String> phaseOpt = recruitmentProcessRepository.currentPhase(jobOpening);
        if (!phaseOpt.isPresent()) {
            return null;
        }
        String phase = phaseOpt.get();
        return phase;
    }

}
