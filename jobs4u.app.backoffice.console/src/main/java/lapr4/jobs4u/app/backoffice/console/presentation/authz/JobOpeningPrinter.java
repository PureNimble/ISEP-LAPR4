package lapr4.jobs4u.app.backoffice.console.presentation.authz;

import eapli.framework.visitor.Visitor;
import lapr4.jobs4u.jobopeningmanagement.dto.JobOpeningDTO;

public class JobOpeningPrinter implements Visitor<JobOpeningDTO> {

    @Override
    public void visit(final JobOpeningDTO visitee) {
        System.out.printf("%-15s%-15s%-15s", visitee.getCustomerCode(), visitee.getCustomerName(), visitee.getJobReference());    }
}
