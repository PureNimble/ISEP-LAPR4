package lapr4.jobs4u.app.backoffice.console.presentation.authz;

import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.presentation.console.AbstractListUI;
import eapli.framework.visitor.Visitor;
import lapr4.jobs4u.candidatemanagement.application.ListCandidatesController;
import lapr4.jobs4u.candidatemanagement.dto.CandidateDTO;
import lapr4.jobs4u.infrastructure.persistence.PersistenceContext;

public class ListCandidatesUI extends AbstractListUI<CandidateDTO> {
    private ListCandidatesController listCandidatesController = new ListCandidatesController(
            PersistenceContext.repositories().candidates(), AuthzRegistry.authorizationService());

    @Override
    public String headline() {
        return "List Candidates";
    }

    @Override
    protected String emptyMessage() {
        return "No data.";
    }

    @Override
    protected Iterable<CandidateDTO> elements() {
        return listCandidatesController.allCandidates();
    }

    @Override
    protected Visitor<CandidateDTO> elementPrinter() {
        return new CandidatePrinter();
    }

    @Override
    protected String elementName() {
        return "Candidates";
    }

    @Override
    protected String listHeader() {
        return String.format("#  %-30s%-30s%-15s", "C.NAME", "C.EMAIL", "PHONE NUMBER");
    }
}
