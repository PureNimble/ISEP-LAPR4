package lapr4.jobs4u.app.backoffice.console.presentation.authz.printer;

import eapli.framework.visitor.Visitor;
import lapr4.jobs4u.candidatemanagement.dto.CandidateDTO;

public class CandidatePrinter implements Visitor<CandidateDTO> {

    @Override
    public void visit(final CandidateDTO visitee) {
        System.out.printf("%-30s%-30s", visitee.getName(), visitee.getEmail());
    }
}
