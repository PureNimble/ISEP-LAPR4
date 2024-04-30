package lapr4.jobs4u.jobopeningmanagement.domain;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lapr4.jobs4u.customermanagement.domain.Address;
import lapr4.jobs4u.customermanagement.domain.Customer;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.validations.Preconditions;

@Entity
@Table(name = "T_JOBOPENING")
public class JobOpening implements AggregateRoot<JobReference> {

    private static final long serialVersionUID = 1L;

    @Version
    private Long version;

    @EmbeddedId
    private JobReference jobReference;

    @Column(nullable = false)
    private TitleOrFunction titleOrFunction;

    @Column(nullable = false)
    private ContractType contractType;

    @Column(nullable = false)
    private Mode mode;

    @Column(nullable = false)
    private Address address;

    /**
     * cascade = CascadeType.NONE as the systemUser is part of another aggregate
     */
    @ManyToOne(optional = false)
    @JoinColumn(name = "customer_name", referencedColumnName = "name")
    private Customer customer;

    @Column(nullable = false)
    private JobDescription jobDescription;

    JobOpening(final JobReference jobReference, final TitleOrFunction titleOrFunction, final ContractType contractType,
            final Mode mode, final Address address, final Customer customer, final JobDescription jobDescription) {
        Preconditions.noneNull(jobReference, titleOrFunction, contractType, mode, address, customer, jobDescription);
        this.jobReference = jobReference;
        this.titleOrFunction = titleOrFunction;
        this.contractType = contractType;
        this.mode = mode;
        this.address = address;
        this.customer = customer;
        this.jobDescription = jobDescription;

    }

    protected JobOpening() {
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

    public JobReference customerCode() {
        return identity();
    }

    @Override
    public JobReference identity() {
        return this.jobReference;
    }
}