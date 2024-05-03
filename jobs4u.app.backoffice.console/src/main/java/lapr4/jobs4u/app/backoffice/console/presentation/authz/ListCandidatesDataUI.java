package lapr4.jobs4u.app.backoffice.console.presentation.authz;

import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;
import lapr4.jobs4u.candidatemanagement.application.ListCandidatesDataController;
import lapr4.jobs4u.candidatemanagement.dto.CandidateDTO;
import lapr4.jobs4u.infrastructure.persistence.PersistenceContext;

public class ListCandidatesDataUI extends AbstractUI {

    final private ListCandidatesDataController controller = new ListCandidatesDataController(PersistenceContext.repositories().candidates(), AuthzRegistry.authorizationService());
    @Override
    protected boolean doShow() {
        final Iterable<CandidateDTO> candidateDTOS = this.controller.allCandidatesSortedAsc();
        final SelectWidget<CandidateDTO> selector = new SelectWidget<>("Candidates:", candidateDTOS,
                new CandidatePrinter());
        selector.show();
        final CandidateDTO selectedCandidate = selector.selectedElement();
        if (selectedCandidate != null) {
            printCandidateData(selectedCandidate);
        }
        return false;
    }

    private void printCandidateData(CandidateDTO candidate) {
        System.out.printf("Name: %s\n", candidate.getName());
        System.out.printf("Email: %s\n", candidate.getEmail());
        System.out.printf("Phone Number: %s\n", candidate.getPhoneNumber());
    }

    @Override
    public String headline() {
        return "Show Candidate Data";
    }
}
