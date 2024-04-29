package lapr4.jobs4u.customerusermanagement.domain;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.validations.Preconditions;

@Entity
@Table(name = "T_CUSTOMER")
public class Customer implements AggregateRoot<CustomerCode> {

    private static final long serialVersionUID = 1L;

    @Version
    private Long version;

    @EmbeddedId
    private CustomerCode customerCode;

    @Column(nullable = false)
    private CompanyName companyName;

    @Column(nullable = false)
    private PhoneNumber phoneNumber;

    @Column(nullable = false)
    private Address address;

    @Column(nullable = false)
    private EmailAddress email;

    /**
     * cascade = CascadeType.NONE as the systemUser is part of another aggregate
     */
    @OneToOne(optional = false)
    private SystemUser systemUser;

    Customer(final SystemUser systemUser, final CustomerCode customerCode, final CompanyName companyName,
            final PhoneNumber phoneNumber, final Address address, final EmailAddress email) {
        Preconditions.noneNull(new Object[] { systemUser, customerCode, companyName, phoneNumber, address, email });
        this.systemUser = systemUser;
        this.customerCode = customerCode;
        this.companyName = companyName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.email = email;
    }

    protected Customer() {
        // for ORM only
    }

    public SystemUser user() {
        return this.systemUser;
    }

    @Override
    public int hashCode() {
        return DomainEntities.hashCode(this);
    }

    @Override
    public boolean equals(final Object o) {
        return DomainEntities.areEqual(this, o);
    }

    @Override
    public boolean sameAs(final Object other) {
        return DomainEntities.areEqual(this, other);
    }

    public CustomerCode customerCode() {
        return identity();
    }

    @Override
    public CustomerCode identity() {
        return this.customerCode;
    }
}