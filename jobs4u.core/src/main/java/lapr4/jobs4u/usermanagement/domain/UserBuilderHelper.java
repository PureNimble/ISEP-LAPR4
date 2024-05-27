package lapr4.jobs4u.usermanagement.domain;

import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;
import eapli.framework.infrastructure.authz.domain.model.SystemUserBuilder;
import eapli.framework.util.Utility;

/**
 * @author 2DI2
 */
@Utility
public class UserBuilderHelper {
    private UserBuilderHelper() {
        // ensure utility
    }

    public static SystemUserBuilder builder() {
        return new SystemUserBuilder(new BasePasswordPolicy(), new PlainTextEncoder());
    }
}
