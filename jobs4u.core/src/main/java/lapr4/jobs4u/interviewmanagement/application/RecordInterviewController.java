package lapr4.jobs4u.interviewmanagement.application;

import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import lapr4.jobs4u.interviewmanagement.domain.Interview;
import lapr4.jobs4u.interviewmanagement.repositories.InterviewRepository;
import lapr4.jobs4u.usermanagement.domain.BaseRoles;

/**
 * @author 2DI2
 */
@UseCaseController
public class RecordInterviewController {
    private final InterviewRepository interviewRepository;
    private final AuthorizationService authz;

    public RecordInterviewController(InterviewRepository interviewRepository, AuthorizationService authz) {
        this.interviewRepository = interviewRepository;
        this.authz = authz;
    }

    public void save(Interview interview) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER, BaseRoles.POWERUSER);
        interviewRepository.save(interview);
    }

}