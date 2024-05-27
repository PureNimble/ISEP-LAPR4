package lapr4.jobs4u.candidatemanagement.application;

import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import lapr4.jobs4u.candidatemanagement.domain.Candidate;
import lapr4.jobs4u.candidatemanagement.dto.CandidateDTO;
import lapr4.jobs4u.candidatemanagement.repositories.CandidateRepository;
import lapr4.jobs4u.usermanagement.domain.BaseRoles;

/**
 * @author 2DI2
 */
@UseCaseController
public class ListCandidatesDataController {
    private final AuthorizationService authz;
    private final ListCandidatesService listCandidatesService;

    public ListCandidatesDataController(CandidateRepository candidateRepository, AuthorizationService authz) {
        this.listCandidatesService = new ListCandidatesService(candidateRepository);
        this.authz = authz;
    }


    public Iterable<CandidateDTO> allCandidates() {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER, BaseRoles.POWERUSER);
        return listCandidatesService.allUsers();
    }

    public Iterable<CandidateDTO> allCandidatesSortedAsc() {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER, BaseRoles.POWERUSER);
        return listCandidatesService.allUsersSortedAsc();
    }

    public Candidate selectedCandidate(final CandidateDTO candidateDTO) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER, BaseRoles.POWERUSER);
        return listCandidatesService.selectedCandidate(candidateDTO);
    }

}
