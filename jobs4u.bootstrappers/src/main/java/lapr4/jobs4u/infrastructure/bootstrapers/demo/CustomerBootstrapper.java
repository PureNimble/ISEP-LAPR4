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
public class CustomerBootstrapper extends UsersBootstrapperBase implements Action {

    @Override
    public boolean execute() {
        registerCustomer("FnacWorten", "Rua do Povo", "fnacworten", "fnac@email.local", "910000000", "Pedro", "Worten");
        return true;
    }
    
    private void registerCustomer(String name, String address, String customerCode, String email, String phoneNumber, String firstName, String lastName) {
        final Set<Role> roles = new HashSet<>();
        roles.add(BaseRoles.CUSTOMER);
    
        addCustomer(name, address, customerCode, email, phoneNumber, firstName, lastName, roles);
    }
}
