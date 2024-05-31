package lapr4.jobs4u.jobopeningmanagement.domain;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Version;
import lapr4.jobs4u.customermanagement.domain.Address;
import lapr4.jobs4u.customermanagement.domain.Customer;
import lapr4.jobs4u.jobopeningmanagement.dto.JobOpeningDTO;
import java.util.Calendar;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.representations.dto.DTOable;
import eapli.framework.time.util.CurrentTimeCalendars;
import eapli.framework.validations.Preconditions;

/**
 * @author 2DI2
 */
@Entity
@Table(name = "T_JOB_OPENING")
public class JobOpening implements AggregateRoot<JobReference>, DTOable<JobOpeningDTO> {

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

    @Column(nullable = false)
    private NumberOfVacancies numberOfVacancies;

    @Column(nullable = false)
    private JobOpeningState jobOpeningState;

    @Temporal(TemporalType.DATE)
    private Calendar registeredOn;

    /**
     * cascade = CascadeType.NONE as the systemUser is part of another aggregate
     */
    @ManyToOne(optional = false)
    private Customer customer;

    @Column(nullable = false)
    private JobDescription jobDescription;

    JobOpening(final JobReference jobReference, final TitleOrFunction titleOrFunction, final ContractType contractType,
            final Mode mode, final Address address, final Customer customer, final JobDescription jobDescription,
            final Calendar createdOn, final NumberOfVacancies numberOfVacancies) {
        Preconditions.noneNull(jobReference, titleOrFunction, contractType, mode, address, customer, jobDescription);
        this.registeredOn = createdOn == null ? CurrentTimeCalendars.now() : createdOn;
        this.jobReference = jobReference;
        this.titleOrFunction = titleOrFunction;
        this.contractType = contractType;
        this.mode = mode;
        this.address = address;
        this.customer = customer;
        this.jobDescription = jobDescription;
        this.numberOfVacancies = numberOfVacancies;
        this.jobOpeningState = JobOpeningState.valueOf(TypesOfJobOpeningStates.PENDING.toString());

    }

    protected JobOpening() {
        // for ORM only
    }

    public Customer customer() {
        return this.customer;
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

    public JobOpeningState jobOpeningState() {
        return this.jobOpeningState;
    }

    public Calendar registeredOn() {
        return this.registeredOn;
    }

    public String registeredOnPeriod() {
        int month = this.registeredOn.get(Calendar.MONTH) + 1;
        int year = this.registeredOn.get(Calendar.YEAR);
        return month + "-" + year;
    }

    public void activate() {
        if (this.jobOpeningState.equals(JobOpeningState.valueOf(TypesOfJobOpeningStates.OCURRING.toString()))) {
            throw new IllegalStateException("Cannot activate an ocurring job opening");
        } else {
            this.jobOpeningState = JobOpeningState.valueOf(TypesOfJobOpeningStates.OCURRING.toString());
        }
    }

    public void deactivate(String recruitmentProcessPhase) {
        if (this.jobOpeningState.equals(JobOpeningState.valueOf(TypesOfJobOpeningStates.PENDING.toString())) || this.jobOpeningState.equals(JobOpeningState.valueOf(TypesOfJobOpeningStates.CLOSED.toString()))) {
            throw new IllegalStateException("Cannot deactivate a pending/closed job opening");
        } else {
            if (recruitmentProcessPhase.equals("ApplicationPhase")) {
                this.jobOpeningState = JobOpeningState.valueOf(TypesOfJobOpeningStates.PENDING.toString());
            } else if (recruitmentProcessPhase.equals("ResultPhase")) {
                this.jobOpeningState = JobOpeningState.valueOf(TypesOfJobOpeningStates.CLOSED.toString());
            }
        }
    }

    public TitleOrFunction titleOrFunction() {
        return this.titleOrFunction;
    }

    public ContractType contractType() {
        return this.contractType;
    }

    public Mode mode() {
        return this.mode;
    }

    public Address address() {
        return this.address;
    }

    public NumberOfVacancies numberOfVacancies() {
        return this.numberOfVacancies;
    }

    public JobDescription jobDescription() {
        return this.jobDescription;
    }

    public void editTitleOrFunction(final TitleOrFunction titleOrFunction) {
        this.titleOrFunction = titleOrFunction;
    }

    public void editContractType(final ContractType contractType) {
        this.contractType = contractType;
    }

    public void editMode(final Mode mode) {
        this.mode = mode;
    }

    public void editAddress(final Address address) {
        this.address = address;
    }

    public void editJobDescription(final JobDescription jobDescription) {
        this.jobDescription = jobDescription;
    }

    public void editNumberOfVacancies(final NumberOfVacancies numberOfVacancies) {
        this.numberOfVacancies = numberOfVacancies;
    }

    public JobOpeningDTO toDTO() {
        return new JobOpeningDTO(this.jobReference.toString(), this.titleOrFunction.toString(),
                this.contractType.toString(), this.mode.toString(), this.address.toString(),
                this.customer.customerCode().toString(), this.customer.companyName().toString(),
                this.jobDescription.toString(), this.registeredOn.toString());
    }

    public JobReference jobReference() {
        return identity();
    }

    @Override
    public JobReference identity() {
        return this.jobReference;
    }

    @Override
    public String toString() {
        return jobReference.toString();
    }
}