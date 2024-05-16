/*
 * Copyright (c) 2013-2024 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
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
 *
 * @author Fernando
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
