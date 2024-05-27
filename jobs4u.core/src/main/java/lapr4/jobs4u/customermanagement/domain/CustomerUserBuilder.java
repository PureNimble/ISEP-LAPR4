package lapr4.jobs4u.customermanagement.domain;

import eapli.framework.domain.model.DomainFactory;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author 2DI2
 */
public class CustomerUserBuilder implements DomainFactory<CustomerUser> {

    private static final Logger LOGGER = LogManager.getLogger(CustomerUserBuilder.class);
    private Customer customer;
    private SystemUser systemUser;

    public CustomerUserBuilder with(final Customer customer,
            final SystemUser systemUser) {
        this.withCustomer(customer);
        this.withSystemUser(systemUser);
        return this;
    }

    public CustomerUserBuilder withCustomer(final Customer customer) {
        this.customer = customer;
        return this;
    }

    public CustomerUserBuilder withSystemUser(final SystemUser systemUser) {
        this.systemUser = systemUser;
        return this;
    }

    @Override
    public CustomerUser build() {
        final CustomerUser customerUser = new CustomerUser(this.customer, this.systemUser);
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("Registering new Customer User [{}] {} {}", customerUser, this.customer,
                    this.systemUser);
        }
        return customerUser;
    }
}
