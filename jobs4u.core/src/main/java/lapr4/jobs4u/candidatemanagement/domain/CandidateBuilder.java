package lapr4.jobs4u.candidatemanagement.domain;

import eapli.framework.domain.model.DomainFactory;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.domain.model.Name;
import lapr4.jobs4u.customermanagement.domain.PhoneNumber;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CandidateBuilder implements DomainFactory<Candidate> {

    private static final Logger LOGGER = LogManager.getLogger(CandidateBuilder.class);
    private EmailAddress email;
    private PhoneNumber phoneNumber;
    private Name name;

    public CandidateBuilder with(final String firstName, final String lastName, final String email,
            final String phoneNumber) {
        this.withName(firstName, lastName);
        this.withEmail(email);
        this.withPhoneNumber(phoneNumber);
        return this;
    }

    public CandidateBuilder withName(final String firstName, final String lastName) {
        this.name = Name.valueOf(firstName, lastName);
        return this;
    }

    public CandidateBuilder withEmail(final String email) {
        this.email = EmailAddress.valueOf(email);
        return this;
    }

    public CandidateBuilder withPhoneNumber(final String phoneNumber) {
        this.phoneNumber = PhoneNumber.valueOf(phoneNumber);
        return this;
    }

    @Override
    public Candidate build() {
        final Candidate candidate = new Candidate(this.name, this.email, this.phoneNumber);
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Registering new candidate [{}] {} {} {}", candidate, this.name, this.email,
                    this.phoneNumber);
        }
        return candidate;
    }
}