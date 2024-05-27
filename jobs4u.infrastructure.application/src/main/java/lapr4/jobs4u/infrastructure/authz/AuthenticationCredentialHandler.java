package lapr4.jobs4u.infrastructure.authz;

import eapli.framework.infrastructure.authz.application.Authenticator;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.Role;

/**
 * @author 2DI2
 */
public class AuthenticationCredentialHandler implements CredentialHandler {

	private final Authenticator authenticationService = AuthzRegistry.authenticationService();

	@Override
	public boolean authenticated(final String username, final String password, final Role onlyWithThis) {
		return authenticationService.authenticate(username, password, onlyWithThis).isPresent();
	}

}
