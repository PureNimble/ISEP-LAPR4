package lapr4.jobs4u.app.backoffice.console.presentation.authz.printer;

import eapli.framework.visitor.Visitor;
import lapr4.jobs4u.applicationmanagement.dto.ApplicationDTO;

public class ApplicationPrinter implements Visitor<ApplicationDTO> {

    @Override
    public void visit(final ApplicationDTO visitee) {
        System.out.printf("%-15s%-40s", visitee.getApplicationCode(), visitee.getCandidate());
    }
}