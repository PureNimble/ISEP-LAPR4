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
package lapr4.jobs4u.infrastructure.bootstrapers;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lapr4.jobs4u.customerusermanagement.application.RegisterCustomerController;
import lapr4.jobs4u.customerusermanagement.domain.Customer;
import lapr4.jobs4u.infrastructure.persistence.PersistenceContext;
import lapr4.jobs4u.usermanagement.application.AddUserController;
import lapr4.jobs4u.usermanagement.application.ListUsersController;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.authz.domain.model.Username;

public class UsersBootstrapperBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(UsersBootstrapperBase.class);

    final AddUserController userController = new AddUserController();
    final ListUsersController listUserController = new ListUsersController();
    final RegisterCustomerController registerCustomerController = new RegisterCustomerController(
            PersistenceContext.repositories().customers());

    public UsersBootstrapperBase() {
        super();
    }

    /**
     * @param username
     * @param password
     * @param firstName
     * @param lastName
     * @param email
     * @param roles
     */
    protected SystemUser registerUser(final String email, final String firstName,
            final String lastName, final Set<Role> roles) {
        SystemUser u = null;
        try {
            u = userController.addUser(email, firstName, lastName, roles);
            LOGGER.debug("»»» %s", email);
        } catch (final IntegrityViolationException | ConcurrencyException e) {
            // assuming it is just a primary key violation due to the tentative
            // of inserting a duplicated user. let's just lookup that user
            u = listUserController.find(Username.valueOf(email)).orElseThrow(() -> e);
        }
        return u;
    }

    protected Customer addCustomer(String name, String address, String customerCode, String email, String phoneNumber, String firstName, String lastName, final Set<Role> roles) {
        Customer u = null;
        try {
            u = registerCustomerController.registerCustomer(registerUser(email, firstName, lastName, roles), name, address, customerCode, email, phoneNumber);
            LOGGER.debug("»»» %s", email);
        } catch (final IntegrityViolationException | ConcurrencyException e) {
            // assuming it is just a primary key violation due to the tentative
            // of inserting a duplicated user. let's just lookup that user
            //u = listUserController.find(Username.valueOf(email)).orElseThrow(() -> e);
        }
        return u;
    }
}
