package lapr4.jobs4u.interviewmanagement.application;

import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import lapr4.jobs4u.interviewmanagement.dto.InterviewDTO;
import lapr4.jobs4u.interviewmanagement.repositories.InterviewRepository;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
import lapr4.jobs4u.usermanagement.domain.BaseRoles;

/**
 * @author 2DI2
 */
@UseCaseController
public class ListCandidatesByInterviewPointsController {
    private final AuthorizationService authz;
    private final ListInterviewsService listInterviewsService;

    public ListCandidatesByInterviewPointsController(InterviewRepository interviewRepository,
            AuthorizationService authz) {
        this.listInterviewsService = new ListInterviewsService(interviewRepository);
        this.authz = authz;
    }

    public Iterable<InterviewDTO> allCandidatesSortedByInterviewPointsForJobOpening(final JobOpening jobOpening, final boolean ascending) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER, BaseRoles.POWERUSER);
        return listInterviewsService.sortedInterviewsByJobOpening(jobOpening, ascending);
    }
}