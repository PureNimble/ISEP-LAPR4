package lapr4.jobs4u.usermanagement.domain;

import eapli.framework.infrastructure.authz.domain.model.Role;

/**
 * @author 2DI2
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
     * PowerUser
     */
    public static final Role POWERUSER = Role.valueOf("POWER_USER");
    
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
