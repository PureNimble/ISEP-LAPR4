package lapr4.jobs4u.jobopeningmanagement.domain;

import eapli.framework.domain.model.DomainFactory;
import lapr4.jobs4u.customermanagement.domain.Address;
import lapr4.jobs4u.customermanagement.domain.Customer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class JobOpeningBuilder implements DomainFactory<JobOpening> {

    private static final Logger LOGGER = LogManager.getLogger(JobOpeningBuilder.class);
    private JobReference jobReference;
    private TitleOrFunction titleOrFunction;
    private ContractType contractType;
    private Mode mode;
    private Address address;
    private Customer customer;
    private JobDescription jobDescription;

    public JobOpeningBuilder with(final String jobReference, final String titleOrFunction, final String contractType,
            final String mode, final String address, final Customer customer, final String jobDescription) {
        this.withJobReference(jobReference);
        this.withTitleOrFunction(titleOrFunction);
        this.withContractType(contractType);
        this.withMode(mode);
        this.withAddress(address);
        this.withCustomer(customer);
        this.withJobDescription(jobDescription);
        return this;
    }

    public JobOpeningBuilder withJobReference(final String jobReference) {
        this.jobReference = JobReference.valueOf(jobReference);
        return this;
    }

    public JobOpeningBuilder withTitleOrFunction(final String titleOrFunction) {
        this.titleOrFunction = TitleOrFunction.valueOf(titleOrFunction);
        return this;
    }

    public JobOpeningBuilder withContractType(final String contractType) {
        this.contractType = ContractType.valueOf(contractType);
        return this;
    }

    public JobOpeningBuilder withMode(final String mode) {
        this.mode = Mode.valueOf(mode);
        return this;
    }

    public JobOpeningBuilder withAddress(final String address) {
        this.address = Address.valueOf(address);
        return this;
    }

    public JobOpeningBuilder withCustomer(final Customer customer) {
        this.customer = customer;
        return this;
    }

    public JobOpeningBuilder withJobDescription(final String jobDescription) {
        this.jobDescription = JobDescription.valueOf(jobDescription);
        return this;
    }

    @Override
    public JobOpening build() {
        final JobOpening jobOpening = new JobOpening(this.jobReference, this.titleOrFunction, this.contractType,
                this.mode, this.address, this.customer, this.jobDescription);
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Registering new Job Opening [{}] {} {} {} {} {} {} {} {}", jobOpening, this.jobReference,
                    this.titleOrFunction, this.contractType, this.mode, this.address, this.customer, this.jobDescription);
        }
        return jobOpening;
    }
}