package lapr4.jobs4u.persistence.impl.jpa;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.domain.model.Username;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;
import lapr4.jobs4u.Application;
import lapr4.jobs4u.customermanagement.domain.CustomerCode;
import lapr4.jobs4u.customermanagement.domain.CustomerUser;
import lapr4.jobs4u.customermanagement.repositories.CustomerUserRepository;

class JpaCustomerUserRepository extends JpaAutoTxRepository<CustomerUser, Long, Long>
        implements CustomerUserRepository {

    public JpaCustomerUserRepository(final TransactionalContext autoTx) {
        super(autoTx, "pk");
    }

    public JpaCustomerUserRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(),
                "pk");
    }

    @Override
    public Optional<CustomerUser> findByCustomerCode(final CustomerCode number) {
        final Map<String, Object> params = new HashMap<>();
        params.put("number", number);
        return matchOne("e.customerCode=:number", params);
    }

    @Override
    public Optional<CustomerUser> findByEmail(final Username email) {
        final Map<String, Object> params = new HashMap<>();
        params.put("email", email);
        return matchOne("e.systemUser.username=:email", params);
    }

}