package lapr4.jobs4u.app.backoffice.console.presentation.authz;

import java.util.ArrayList;
import java.util.List;

import lapr4.jobs4u.app.backoffice.console.presentation.authz.printer.SystemUserPrinter;
import lapr4.jobs4u.app.common.console.presentation.utils.Utils;
import lapr4.jobs4u.candidatemanagement.application.EnableOrDisableCandidateUserController;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

/**
 * @author 2DI2
 */
@SuppressWarnings("squid:S106")
public class EnableOrDisableCandidateUserUI extends AbstractUI {

    private final EnableOrDisableCandidateUserController theController = new EnableOrDisableCandidateUserController();

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
        final Iterable<SystemUser> candidateUsers = this.theController.activeUsers();
        final SelectWidget<SystemUser> selector = new SelectWidget<>("Candidate Users:", candidateUsers,
                new SystemUserPrinter());
        selector.show();
        final SystemUser theCandidateUser = selector.selectedElement();
        if (theCandidateUser != null) {
            if(Utils.confirm("Do you want to deactivate the user: " + theCandidateUser.name() + "?")) {
                try {
                    theController.enableOrDisableUser(theCandidateUser, "disable");
                } catch (final ConcurrencyException ex) {
                    System.out.println(
                            "WARNING: That entity has already been changed or deleted since you last read it");
                }
            }
        }
        return false;
    }

    private boolean showDeactivatedUsers() {
        final Iterable<SystemUser> candidateUsers = this.theController.deactivatedUsers();
        final SelectWidget<SystemUser> selector = new SelectWidget<>("Backoffice Users:", candidateUsers,
                new SystemUserPrinter());
        selector.show();
        final SystemUser theCandidateUser = selector.selectedElement();
        if (theCandidateUser != null) {
            if(Utils.confirm("Do you want to activate the user: " + theCandidateUser.name() + "?")) {
                try {
                    theController.enableOrDisableUser(theCandidateUser, "enable");
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
        return "Enable/Disable Candidate User";
    }
}
