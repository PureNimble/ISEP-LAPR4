package lapr4.jobs4u.app.backoffice.console.presentation.authz.printer;

import eapli.framework.visitor.Visitor;
import lapr4.jobs4u.rankmanagement.dto.RankDTO;

/**
 * @author 2DI2
 */
public class RankPrinter implements Visitor<RankDTO> {

    @Override
    public void visit(final RankDTO visitee) {
        System.out.printf("%-20s%-20s", visitee.getCandidateEmail(),
                visitee.getCandidateName());
    }
}
