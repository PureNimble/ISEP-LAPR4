/*
 * Copyright (c) 2013-2024 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package lapr4.jobs4u.app.backoffice.console.presentation;

import lapr4.jobs4u.Application;
import lapr4.jobs4u.app.backoffice.console.presentation.authz.AddUserUI;
import lapr4.jobs4u.app.backoffice.console.presentation.authz.DeactivateUserAction;
import lapr4.jobs4u.app.backoffice.console.presentation.authz.ImportApplicationsUI;
import lapr4.jobs4u.app.backoffice.console.presentation.authz.ListJobOpeningsUI;
import lapr4.jobs4u.app.backoffice.console.presentation.authz.ListUsersAction;
import lapr4.jobs4u.app.backoffice.console.presentation.authz.RegisterCandidateUI;
import lapr4.jobs4u.app.backoffice.console.presentation.authz.RegisterCustomerUI;
import lapr4.jobs4u.app.backoffice.console.presentation.authz.RegisterJobOpeningUI;
import lapr4.jobs4u.app.backoffice.console.presentation.authz.SetUpRecruitmentProcessUI;
import lapr4.jobs4u.app.common.console.presentation.authz.MyUserMenu;
import lapr4.jobs4u.usermanagement.domain.BaseRoles;
import eapli.framework.actions.Actions;
import eapli.framework.actions.menu.Menu;
import eapli.framework.actions.menu.MenuItem;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.ExitWithMessageAction;
import eapli.framework.presentation.console.menu.HorizontalMenuRenderer;
import eapli.framework.presentation.console.menu.MenuItemRenderer;
import eapli.framework.presentation.console.menu.MenuRenderer;
import eapli.framework.presentation.console.menu.VerticalMenuRenderer;

/**
 * TODO split this class in more specialized classes for each menu
 *
 * @author Paulo Gandra Sousa
 */
public class MainMenu extends AbstractUI {

    private static final String RETURN_LABEL = "Return ";

    private static final int EXIT_OPTION = 0;

    // USERS
    private static final int ADD_USER_OPTION = 1;
    private static final int LIST_USERS_OPTION = 2;
    private static final int DEACTIVATE_USER_OPTION = 3;

    //CUSTOMER MANAGER
    private static final int REGISTER_CUSTOMER = 1;
    private static final int REGISTER_JOB_OPENING = 2;
    private static final int LIST_JOB_OPENINGS = 3;
    private static final int SETUP_RECRUITMENT_PROCESS = 4;

    // OPERATOR
    private static final int IMPORT_APPLICATIONS_OPTION = 4;

    // MAIN MENU
    private static final int MY_USER_OPTION = 1;
    private static final int USERS_OPTION = 2;

    private static final String SEPARATOR_LABEL = "--------------";

    private final AuthorizationService authz = AuthzRegistry.authorizationService();

    @Override
    public boolean show() {
        drawFormTitle();
        return doShow();
    }

    /**
     * @return true if the user selected the exit option
     */
    @Override
    public boolean doShow() {
        final Menu menu = buildMainMenu();
        final MenuRenderer renderer;
        if (Application.settings().isMenuLayoutHorizontal()) {
            renderer = new HorizontalMenuRenderer(menu, MenuItemRenderer.DEFAULT);
        } else {
            renderer = new VerticalMenuRenderer(menu, MenuItemRenderer.DEFAULT);
        }
        return renderer.render();
    }

    @Override
    public String headline() {

        return authz.session().map(s -> "BackOffice App [ @" + s.authenticatedUser().identity() + " ]")
                .orElse("Backoffice App [ ==Anonymous== ]");
    }

    private Menu buildMainMenu() {
        final Menu mainMenu = new Menu();

        if (authz.isAuthenticatedUserAuthorizedTo(BaseRoles.ADMIN, BaseRoles.CUSTOMER_MANAGER, BaseRoles.OPERATOR,
                BaseRoles.LANGUAGE_ENGINEER)) {

            final Menu myUserMenu = new MyUserMenu();
            mainMenu.addSubMenu(MY_USER_OPTION, myUserMenu);

            if (!Application.settings().isMenuLayoutHorizontal()) {
                mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));
            }

            if (authz.isAuthenticatedUserAuthorizedTo(BaseRoles.ADMIN)) {
                final Menu usersMenu = buildAdminMenu();
                mainMenu.addSubMenu(USERS_OPTION, usersMenu);
            }

            if (authz.isAuthenticatedUserAuthorizedTo(BaseRoles.CUSTOMER_MANAGER)) {
                final Menu usersMenu = buildCustomerManagerMenu();
                mainMenu.addSubMenu(USERS_OPTION, usersMenu);
            }

            if (authz.isAuthenticatedUserAuthorizedTo(BaseRoles.OPERATOR)) {
                final Menu usersMenu = buildOperatorMenu();
                mainMenu.addSubMenu(USERS_OPTION, usersMenu);
            }

            if (authz.isAuthenticatedUserAuthorizedTo(BaseRoles.LANGUAGE_ENGINEER)) {
                final Menu usersMenu = buildLanguageEngineerMenu();
                mainMenu.addSubMenu(USERS_OPTION, usersMenu);
            }

            if (!Application.settings().isMenuLayoutHorizontal()) {
                mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));
            }

        } else {
            System.out
                    .println(
                            "You don't have permission to access this Application. Please contact the Administrator.\n");
        }
        mainMenu.addItem(EXIT_OPTION, "Exit", new ExitWithMessageAction("Goodbye!"));
        return mainMenu;
    }

    private Menu buildAdminMenu() {
        final Menu menu = new Menu("Users >");

        menu.addItem(ADD_USER_OPTION, "Add User", new AddUserUI()::show);
        menu.addItem(LIST_USERS_OPTION, "List all Users", new ListUsersAction());
        menu.addItem(DEACTIVATE_USER_OPTION, "Deactivate User", new DeactivateUserAction());
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }

    private Menu buildCustomerManagerMenu() {
        final Menu menu = new Menu("Users >");

        menu.addItem(REGISTER_CUSTOMER, "Register Customer", new RegisterCustomerUI()::show);
        menu.addItem(REGISTER_JOB_OPENING, "Register Job Opening", new RegisterJobOpeningUI()::show);
        menu.addItem(LIST_JOB_OPENINGS, "List Job Openings", new ListJobOpeningsUI()::show);
        menu.addItem(SETUP_RECRUITMENT_PROCESS, "SetUp Recruitment Process", new SetUpRecruitmentProcessUI()::show);
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }

    private Menu buildOperatorMenu() {
        final Menu menu = new Menu("Users >");

        menu.addItem(ADD_USER_OPTION, "Register Candidate", new RegisterCandidateUI()::show);
        menu.addItem(LIST_USERS_OPTION, "List all Users", new ListUsersAction());
        menu.addItem(DEACTIVATE_USER_OPTION, "Deactivate User", new DeactivateUserAction());
        menu.addItem(IMPORT_APPLICATIONS_OPTION, "Import Applications", new ImportApplicationsUI()::show);
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }

    private Menu buildLanguageEngineerMenu() {
        final Menu menu = new Menu("Users >");

        menu.addItem(ADD_USER_OPTION, "Add User", new AddUserUI()::show);
        menu.addItem(LIST_USERS_OPTION, "List all Users", new ListUsersAction());
        menu.addItem(DEACTIVATE_USER_OPTION, "Deactivate User", new DeactivateUserAction());
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }

}
