package lapr4.jobs4u.interviewmanagement.application;

import java.util.Optional;

import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import lapr4.jobs4u.interviewmanagement.repositories.InterviewRepository;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
import lapr4.jobs4u.jobopeningmanagement.repositories.JobOpeningInterviewRepository;
import lapr4.jobs4u.questionmanagement.repositories.InterviewQuestionRepository;
import lapr4.jobs4u.recruitmentprocessmanagement.repositories.RecruitmentProcessRepository;
import lapr4.jobs4u.usermanagement.domain.BaseRoles;

/**
 * @author 2DI2
 */
@UseCaseController
public class EvaluateInterviewController {

    private final RecruitmentProcessRepository recruitmentProcessRepository;
    private final EvaluateInterviewService evaluateInterviewService;
    private final AuthorizationService authz;

    public EvaluateInterviewController(final InterviewQuestionRepository InterviewQuestionRepository,
            final RecruitmentProcessRepository recruitmentProcessRepository,
            final JobOpeningInterviewRepository jobOpeningInterviewRepository,
            final InterviewRepository interviewRepository,
            final AuthorizationService authz) {
        this.recruitmentProcessRepository = recruitmentProcessRepository;
        this.evaluateInterviewService = new EvaluateInterviewService(interviewRepository, jobOpeningInterviewRepository,
                InterviewQuestionRepository);
        this.authz = authz;
    }

    public void evaluateInterview(final JobOpening jobOpening) throws Exception {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER, BaseRoles.POWERUSER);
        evaluateInterviewService.evaluateInterview(jobOpening);
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
