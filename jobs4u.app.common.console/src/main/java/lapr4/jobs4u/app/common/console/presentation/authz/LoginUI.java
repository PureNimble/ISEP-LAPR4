package lapr4.jobs4u.app.common.console.presentation.authz;

import lapr4.jobs4u.infrastructure.authz.CredentialHandler;
import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

/**
 * @author 2DI2
 */
@SuppressWarnings("squid:S106")
public class LoginUI extends AbstractUI {

	private Role onlyWithThis;
	private static final int DEFAULT_MAX_ATTEMPTS = 3;
	private final int maxAttempts;

	private final CredentialHandler credentialHandler;

	public LoginUI(final CredentialHandler credentialHandler) {
		maxAttempts = DEFAULT_MAX_ATTEMPTS;
		this.credentialHandler = credentialHandler;
	}

	public LoginUI(final CredentialHandler credentialHandler, final Role onlyWithThis) {
		this.onlyWithThis = onlyWithThis;
		maxAttempts = DEFAULT_MAX_ATTEMPTS;
		this.credentialHandler = credentialHandler;
	}

	public LoginUI(final CredentialHandler credentialHandler, final Role onlyWithThis, final int maxAttempts) {
		this.onlyWithThis = onlyWithThis;
		this.maxAttempts = maxAttempts;
		this.credentialHandler = credentialHandler;
	}

	public LoginUI(final CredentialHandler credentialHandler, final int maxAttempts) {
		this.maxAttempts = maxAttempts;
		this.credentialHandler = credentialHandler;
	}

	@Override
	protected boolean doShow() {
		var attempt = 1;
		while (attempt <= maxAttempts) {
			final String email = Console.readNonEmptyLine("Email:", "Please provide an email");
			final String password = Console.readNonEmptyLine("Password:", "Please provide a password");

			if (credentialHandler.authenticated(email, password, onlyWithThis)) {
				return true;
			}
			System.out.printf("Wrong email or password. You have %d attempts left.%n%n»»»»»»»»»%n",
					maxAttempts - attempt);
			attempt++;
		}
		System.out.println("Sorry, we are unable to authenticate you. Please contact your system administrator.");
		return false;
	}

	@Override
	public String headline() {
		return "Login";
	}
}
