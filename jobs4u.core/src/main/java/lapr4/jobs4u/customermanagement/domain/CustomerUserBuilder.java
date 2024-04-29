package lapr4.jobs4u.customermanagement.domain;

import eapli.framework.domain.model.DomainFactory;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustomerUserBuilder implements DomainFactory<CustomerUser> {

    private static final Logger LOGGER = LogManager.getLogger(CustomerUserBuilder.class);
    private Customer customer;
    private SystemUser systemUser;
    private SystemUser manager;

    public CustomerUserBuilder with(final Customer customer,
            final SystemUser systemUser, final SystemUser manager) {
        this.withCustomer(customer);
        this.withSystemUser(systemUser);
        this.withManager(manager);
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

    public CustomerUserBuilder withManager(final SystemUser manager) {
        this.manager = manager;
        return this;
    }

    @Override
    public CustomerUser build() {
        final CustomerUser customerUser = new CustomerUser(this.customer, this.systemUser, this.manager);
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Registering new customer [{}] {} {} {} {} {} {}", customerUser, this.customer,
                    this.systemUser, this.manager);
        }
        return customerUser;
    }
}
