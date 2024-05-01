package lapr4.jobs4u.customermanagement.domain;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
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
    @JoinColumn(name = "managed_by")
    private SystemUser manager;

    Customer(final CustomerCode customerCode, final CompanyName companyName,
            final PhoneNumber phoneNumber, final Address address, final EmailAddress email, final SystemUser manager) {
        Preconditions.noneNull(new Object[] { customerCode, companyName, phoneNumber, address, email, manager });
        this.customerCode = customerCode;
        this.companyName = companyName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.email = email;
        this.manager = manager;
    }

    protected Customer() {
        // for ORM only
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

    public SystemUser manager() {
        return this.manager;
    }

    @Override
    public CustomerCode identity() {
        return this.customerCode;
    }

    @Override
    public String toString() {
        return customerCode.toString() + " - " + companyName.toString();
    }

    public CompanyName companyName() {
        return this.companyName;
    }
}