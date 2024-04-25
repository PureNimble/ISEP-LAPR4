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
package lapr4.jobs4u.infrastructure.bootstrapers.demo;

import java.util.HashSet;
import java.util.Set;

import lapr4.jobs4u.infrastructure.bootstrapers.UsersBootstrapperBase;
import lapr4.jobs4u.usermanagement.domain.BaseRoles;
import eapli.framework.actions.Action;
import eapli.framework.infrastructure.authz.domain.model.Role;

/**
 * @author Paulo Gandra Sousa
 */
public class BackofficeUsersBootstrapper extends UsersBootstrapperBase implements Action {

    @SuppressWarnings("squid:S2068")
    private static final String PASSWORD1 = "Password1";

    @Override
    public boolean execute() {
        registerCustomerManager("cm", PASSWORD1, "Johny", "Cash", "johny.doe@email.com");
        registerOperator("op", PASSWORD1, "Oven", "Stove", "Oven.and.stove@email.com");
        registerLanguageEngineer("le", PASSWORD1, "Master", "Chef", "master.chef@email.com");
        registerCustomer("cu", PASSWORD1, "Paulo", "Stone", "Paulo.and.Stone@email.com");
        registerCandidate("ca", PASSWORD1, "Fried", "Uabo", "Fried.and.Uabo@email.com");
        return true;
    }

    private void registerCustomerManager(final String username, final String password,
            final String firstName, final String lastName, final String email) {
        final Set<Role> roles = new HashSet<>();
        roles.add(BaseRoles.CUSTOMER_MANAGER);

        registerUser(username, password, firstName, lastName, email, roles);
    }

    private void registerOperator(final String username, final String password,
            final String firstName, final String lastName, final String email) {
        final Set<Role> roles = new HashSet<>();
        roles.add(BaseRoles.OPERATOR);

        registerUser(username, password, firstName, lastName, email, roles);
    }

    private void registerLanguageEngineer(final String username, final String password,
            final String firstName, final String lastName, final String email) {
        final Set<Role> roles = new HashSet<>();
        roles.add(BaseRoles.LANGUAGE_ENGINEER);

        registerUser(username, password, firstName, lastName, email, roles);
    }

    private void registerCustomer(final String username, final String password,
            final String firstName, final String lastName, final String email) {
        final Set<Role> roles = new HashSet<>();
        roles.add(BaseRoles.CUSTOMER);

        registerUser(username, password, firstName, lastName, email, roles);
    }

    private void registerCandidate(final String username, final String password,
            final String firstName, final String lastName, final String email) {
        final Set<Role> roles = new HashSet<>();
        roles.add(BaseRoles.CANDIDATE);

        registerUser(username, password, firstName, lastName, email, roles);
    }
}
