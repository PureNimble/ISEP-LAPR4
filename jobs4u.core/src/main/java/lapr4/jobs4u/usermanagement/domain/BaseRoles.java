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
package lapr4.jobs4u.usermanagement.domain;

import eapli.framework.infrastructure.authz.domain.model.Role;

/**
 * @author Paulo Gandra Sousa
 *
 */
public final class BaseRoles {
    /**
     * Jobs4U Administrator
     */
    public static final Role ADMIN = Role.valueOf("ADMIN");
    /**
     * Customer Manager
     */
    public static final Role CUSTOMER_MANAGER = Role.valueOf("CUSTOMER_MANAGER");
    /**
     * Operator
     */
    public static final Role OPERATOR = Role.valueOf("OPERATOR");
    /**
     * Language Engineer
     */
    public static final Role LANGUAGE_ENGINEER = Role.valueOf("LANGUAGE_ENGINEER");
    /**
     * Customer
     */
    public static final Role CUSTOMER = Role.valueOf("CUSTOMER");
    /**
     * Candidate
     */
    public static final Role CANDIDATE = Role.valueOf("CANDIDATE");
    
    /**
     * get available role types for adding new users
     *
     * @return
     */
    public static Role[] nonUserValues() {
        return new Role[] {CUSTOMER_MANAGER, OPERATOR, LANGUAGE_ENGINEER};
    }

    /**
     * Checks if a given role is a collaborator.
     *
     * @param role the role to check
     * @return true if the role is a collaborator, false otherwise
     */
    public boolean isCollaborator(final Role role) {
        return role != CUSTOMER && role != CANDIDATE;
    }
}
