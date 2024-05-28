package lapr4.jobs4u.app.backoffice.console.presentation.authz.printer;

import eapli.framework.visitor.Visitor;
import lapr4.jobs4u.jobopeningmanagement.dto.JobOpeningDTO;

/**
 * @author 2DI2
 */
public class JobOpeningPrinter implements Visitor<JobOpeningDTO> {

    @Override
    public void visit(final JobOpeningDTO visitee) {
        System.out.printf("%-15s%-20s%-15s%-30s", visitee.getCustomerCode(), visitee.getCustomerName(),
                visitee.getJobReference(), visitee.getTitleOrFunction());
    }
}
