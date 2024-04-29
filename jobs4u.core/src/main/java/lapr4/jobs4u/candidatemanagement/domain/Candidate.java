package lapr4.jobs4u.candidatemanagement.domain;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lapr4.jobs4u.customermanagement.domain.PhoneNumber;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.domain.model.Name;
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

    Candidate(final Name name, final EmailAddress email, final PhoneNumber phoneNumber) {
        Preconditions.noneNull(new Object[] { name, email, phoneNumber });
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
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

    public EmailAddress customerCode() {
        return identity();
    }

    @Override
    public EmailAddress identity() {
        return this.email;
    }
}