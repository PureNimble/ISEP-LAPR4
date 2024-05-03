package lapr4.jobs4u.candidatemanagement.domain;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lapr4.jobs4u.candidatemanagement.dto.CandidateDTO;
import lapr4.jobs4u.customermanagement.domain.PhoneNumber;
import lapr4.jobs4u.jobopeningmanagement.dto.JobOpeningDTO;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.domain.model.Name;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.validations.Preconditions;

@Entity
@Table(name = "T_CANDIDATE")
public class Candidate implements AggregateRoot<EmailAddress> {

    private static final long serialVersionUID = 1L;

    @Version
    private Long version;

    @EmbeddedId
    private EmailAddress email;

    @Column(nullable = false)
    private Name name;

    @Column(nullable = false)
    private PhoneNumber phoneNumber;

    /**
     * cascade = CascadeType.NONE as the systemUser is part of another aggregate
     */
    @ManyToOne(optional = false)
    @JoinColumn(name = "registered_by")
    private SystemUser creator;

    Candidate(final Name name, final EmailAddress email, final PhoneNumber phoneNumber, final SystemUser creator) {
        Preconditions.noneNull(new Object[] { name, email, phoneNumber, creator });
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.creator = creator;
    }

    protected Candidate() {
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

    public EmailAddress emailAddress() {
        return identity();
    }

    public CandidateDTO toDTO() {
        return new CandidateDTO(this.email.toString(), this.name.toString(), this.phoneNumber.toString());
    }

    @Override
    public EmailAddress identity() {
        return this.email;
    }

    @Override
    public String toString() {
        return name.toString() + " - " + email.toString();
    }
}