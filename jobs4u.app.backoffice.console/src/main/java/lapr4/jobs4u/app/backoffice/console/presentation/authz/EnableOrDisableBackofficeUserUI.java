package lapr4.jobs4u.app.backoffice.console.presentation.authz;

import java.util.ArrayList;
import java.util.List;

import lapr4.jobs4u.app.backoffice.console.presentation.authz.printer.SystemUserPrinter;
import lapr4.jobs4u.app.common.console.presentation.utils.Utils;
import lapr4.jobs4u.usermanagement.application.EnableOrDisableBackofficeUserController;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

/**
 * @author 2DI2
 */
@SuppressWarnings("squid:S106")
public class EnableOrDisableBackofficeUserUI extends AbstractUI {

    private final EnableOrDisableBackofficeUserController theController = new EnableOrDisableBackofficeUserController();

    @Override
    protected boolean doShow() {
        final List<String> options = new ArrayList<>();
        options.add("See Active User");
        options.add("See Deactivated User");
        final int option = Utils.showAndSelectIndex(options, "Which type of user do you want to see?");
        if (option == 0) {
            return showActiveUsers();
        } else if (option == 1) {
            return showDeactivatedUsers();
        }
        return false;
    }

    private boolean showActiveUsers() {
        final Iterable<SystemUser> backofficeUsers = this.theController.activeUsers();
        final SelectWidget<SystemUser> selector = new SelectWidget<>("Backoffice Users:", backofficeUsers,
                new SystemUserPrinter());
        selector.show();
        final SystemUser theBackofficeUser = selector.selectedElement();
        if (theBackofficeUser != null) {
            if(Utils.confirm("Do you want to deactivate the user: " + theBackofficeUser.name() + "?")) {
                try {
                    theController.enableOrDisableUser(theBackofficeUser, "disable");
                } catch (final ConcurrencyException ex) {
                    System.out.println(
                            "WARNING: That entity has already been changed or deleted since you last read it");
                }
            }
        }
        return false;
    }

    private boolean showDeactivatedUsers() {
        final Iterable<SystemUser> backofficeUsers = this.theController.deactivatedUsers();
        final SelectWidget<SystemUser> selector = new SelectWidget<>("Backoffice Users:", backofficeUsers,
                new SystemUserPrinter());
        selector.show();
        final SystemUser theBackofficeUser = selector.selectedElement();
        if (theBackofficeUser != null) {
            if(Utils.confirm("Do you want to activate the user: " + theBackofficeUser.name() + "?")) {
                try {
                    theController.enableOrDisableUser(theBackofficeUser, "enable");
                } catch (final ConcurrencyException ex) {
                    System.out.println(
                            "WARNING: That entity has already been changed or deleted since you last read it");
                }
            }
        }
        return false;
    }

    @Override
    public String headline() {
        return "Enable/Disable User";
    }
}
