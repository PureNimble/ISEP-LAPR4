package lapr4.jobs4u.customermanagement.domain;

import eapli.framework.domain.model.DomainFactory;
import eapli.framework.general.domain.model.EmailAddress;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustomerBuilder implements DomainFactory<Customer> {

    private static final Logger LOGGER = LogManager.getLogger(CustomerBuilder.class);
    private CompanyName companyName;
    private Address address;
    private CustomerCode customerCode;
    private EmailAddress email;
    private PhoneNumber phoneNumber;

    public CustomerBuilder with(final String name, final String address,
            final String customerCode,
            final String email, final String phoneNumber) {
        this.withCustomerName(name);
        this.withAddress(address);
        this.withCustomerCode(customerCode);
        this.withEmail(email);
        this.withPhoneNumber(phoneNumber);
        return this;
    }

    public CustomerBuilder withCustomerCode(final String code) {
        this.customerCode = CustomerCode.valueOf(code);
        return this;
    }

    public CustomerBuilder withCustomerName(final String name) {
        this.companyName = CompanyName.valueOf(name);
        return this;
    }

    public CustomerBuilder withEmail(final String email) {
        this.email = EmailAddress.valueOf(email);
        return this;
    }

    public CustomerBuilder withPhoneNumber(final String phoneNumber) {
        this.phoneNumber = PhoneNumber.valueOf(phoneNumber);
        return this;
    }

    public CustomerBuilder withAddress(final String address) {
        this.address = Address.valueOf(address);
        return this;
    }

    @Override
    public Customer build() {
        final Customer customer = new Customer(this.customerCode, this.companyName, this.phoneNumber,
                this.address, this.email);
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Registering new customer [{}] {} {} {} {} {} {}", customer, this.customerCode,
                    this.companyName, this.phoneNumber, this.address, this.email);
        }
        return customer;
    }
}