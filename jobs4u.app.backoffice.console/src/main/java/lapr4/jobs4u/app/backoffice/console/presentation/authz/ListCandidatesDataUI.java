package lapr4.jobs4u.app.backoffice.console.presentation.authz;

import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;
import lapr4.jobs4u.app.backoffice.console.presentation.authz.printer.CandidatePrinter;
import lapr4.jobs4u.applicationmanagement.dto.ApplicationDTO;
import lapr4.jobs4u.candidatemanagement.application.DisplayCandidateApplicationsController;
import lapr4.jobs4u.candidatemanagement.application.ListCandidatesDataController;
import lapr4.jobs4u.candidatemanagement.domain.Candidate;
import lapr4.jobs4u.candidatemanagement.dto.CandidateDTO;
import lapr4.jobs4u.infrastructure.persistence.PersistenceContext;

public class ListCandidatesDataUI extends AbstractUI {

    final private ListCandidatesDataController listCandidatesDataController = new ListCandidatesDataController(PersistenceContext.repositories().candidates(), AuthzRegistry.authorizationService());
    final private DisplayCandidateApplicationsController displayCandidateApplicationsController = new DisplayCandidateApplicationsController(PersistenceContext.repositories().applications(), AuthzRegistry.authorizationService());
    @Override
    protected boolean doShow() {
        final Iterable<CandidateDTO> candidateDTOS = this.listCandidatesDataController.allCandidatesSortedAsc();
        final SelectWidget<CandidateDTO> selector = new SelectWidget<>("Candidates:", candidateDTOS,
                new CandidatePrinter());
        selector.show();
        final CandidateDTO selectedCandidateDTO = selector.selectedElement();
        if (selectedCandidateDTO != null) {
            printCandidateData(selectedCandidateDTO);
            Candidate selectedCandidate = listCandidatesDataController.selectedCandidate(selectedCandidateDTO);
            final Iterable<ApplicationDTO> applicationDTOS = this.displayCandidateApplicationsController.findApplicationsFromCandidate(selectedCandidate);
            printApplications(applicationDTOS);
        }
        return false;
    }

    private void printCandidateData(CandidateDTO candidate) {
        System.out.printf("\nCandidate Details:\n");
        System.out.printf("Name: %s\n", candidate.getName());
        System.out.printf("Email: %s\n", candidate.getEmail());
        System.out.printf("Phone Number: %s\n", candidate.getPhoneNumber());
    }

    private void printApplications(Iterable<ApplicationDTO> applicationDTOS) {
        for (ApplicationDTO applicationDTO : applicationDTOS) {
            System.out.printf("Application Code: %s\n", applicationDTO.getApplicationCode());
        }
    }

    @Override
    public String headline() {
        return "Show Candidate Data";
    }
}
