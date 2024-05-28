package lapr4.jobs4u.app.backoffice.console.presentation.authz.printer;

import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.visitor.Visitor;

/**
 * @author 2DI2
 */
@SuppressWarnings({ "squid:S106" })
public class SystemUserPrinter implements Visitor<SystemUser> {

    @Override
    public void visit(final SystemUser visitee) {
        System.out.printf("%-30s%-15s%-15s%-5s", visitee.email(), visitee.name().firstName(), visitee.name().lastName(), visitee.isActive());
    }
}
