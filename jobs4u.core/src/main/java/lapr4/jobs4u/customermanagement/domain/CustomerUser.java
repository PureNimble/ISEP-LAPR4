package lapr4.jobs4u.customermanagement.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.validations.Preconditions;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

/**
 * @author 2DI2
 */
@Entity
@Table(name = "T_CUSTOMER_USER")
public class CustomerUser implements AggregateRoot<Long> {

    private static final long serialVersionUID = 1L;

    @Version
    private Long version;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pk;

    /**
     * cascade = CascadeType.NONE as the systemUser is part of another aggregate
     */
    @OneToOne(optional = false)
    @JoinColumn(name = "customer_code", unique = true)
    private Customer customer;

    /**
     * cascade = CascadeType.NONE as the systemUser is part of another aggregate
     */
    @OneToOne(optional = false)
    @JoinColumn(name = "account_email", unique = true)
    private SystemUser systemUser;

    CustomerUser(final Customer customer, final SystemUser systemUser) {
        Preconditions.noneNull(new Object[] { customer, systemUser });
        this.customer = customer;
        this.systemUser = systemUser;
    }

    protected CustomerUser() {
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

    public Long pk() {
        return identity();
    }

    @Override
    public Long identity() {
        return this.pk;
    }

    public Customer customer() {
        return this.customer;
    }

    public SystemUser systemUser() {
        return this.systemUser;
    }
}
