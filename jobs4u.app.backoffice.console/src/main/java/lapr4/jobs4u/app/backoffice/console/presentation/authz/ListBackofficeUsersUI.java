package lapr4.jobs4u.app.backoffice.console.presentation.authz;

import lapr4.jobs4u.app.backoffice.console.presentation.authz.printer.SystemUserPrinter;
import lapr4.jobs4u.infrastructure.persistence.PersistenceContext;
import lapr4.jobs4u.usermanagement.application.ListUsersController;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.presentation.console.AbstractListUI;
import eapli.framework.visitor.Visitor;

/**
 * @author 2DI2
 */
@SuppressWarnings({ "squid:S106" })
public class ListBackofficeUsersUI extends AbstractListUI<SystemUser> {
    private ListUsersController theController = new ListUsersController(PersistenceContext.repositories().users());

    @Override
    public String headline() {
        return "List Backoffice Users";
    }

    @Override
    protected String emptyMessage() {
        return "No data.";
    }

    @Override
    protected Iterable<SystemUser> elements() {
        return theController.backofficeUsers();
    }

    @Override
    protected Visitor<SystemUser> elementPrinter() {
        return new SystemUserPrinter();
    }

    @Override
    protected String elementName() {
        return "Backoffice User";
    }

    @Override
    protected String listHeader() {
        return String.format("#  %-30s%-15s%-15s%-5s", "EMAIL", "NAME", "ROLE", "ACTIVE");
    }
}
