package lapr4.jobs4u.persistence.impl.jpa;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import lapr4.jobs4u.Application;
import lapr4.jobs4u.customermanagement.domain.Customer;
import lapr4.jobs4u.customermanagement.domain.CustomerCode;
import lapr4.jobs4u.customermanagement.repositories.CustomerRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.domain.model.Username;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

/**
 * @author 2DI2
 */
class JpaCustomerRepository
        extends JpaAutoTxRepository<Customer, CustomerCode, CustomerCode>
        implements CustomerRepository {

    public JpaCustomerRepository(final TransactionalContext autoTx) {
        super(autoTx, "customerCode");
    }

    public JpaCustomerRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(),
                "customerCode");
    }

    @Override
    public Optional<Customer> findByCustomerCode(final CustomerCode number) {
        final Map<String, Object> params = new HashMap<>();
        params.put("number", number);
        return matchOne("e.customerCode=:number", params);
    }

	@Override
	public Iterable<Customer> filterByCostumerManager(final Username name) {
		final Map<String, Object> params = new HashMap<>();
        params.put("name", name);
        return match("e.manager.username=:name", params);
	}
}
