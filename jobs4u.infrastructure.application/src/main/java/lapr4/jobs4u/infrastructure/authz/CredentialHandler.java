package lapr4.jobs4u.infrastructure.authz;

import eapli.framework.infrastructure.authz.domain.model.Role;

/**
 * @author 2DI2
 */
public interface CredentialHandler {
	boolean authenticated(final String username, final String password, final Role onlyWithThis);
}
