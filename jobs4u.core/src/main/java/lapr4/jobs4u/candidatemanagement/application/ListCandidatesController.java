package lapr4.jobs4u.candidatemanagement.application;

import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import lapr4.jobs4u.candidatemanagement.repositories.CandidateRepository;
import lapr4.jobs4u.candidatemanagement.dto.CandidateDTO;
import lapr4.jobs4u.usermanagement.domain.BaseRoles;

@UseCaseController
public class ListCandidatesController {
    private final AuthorizationService authz;
    private final ListCandidatesService listCandidatesService;

    public ListCandidatesController(CandidateRepository candidateRepository, AuthorizationService authz) {
        this.listCandidatesService = new ListCandidatesService(candidateRepository);
        this.authz = authz;
    }


    public Iterable<CandidateDTO> allCandidates() {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.OPERATOR);
        return listCandidatesService.allUsers();
    }
}
