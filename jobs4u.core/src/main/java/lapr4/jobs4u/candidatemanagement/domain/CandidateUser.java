package lapr4.jobs4u.candidatemanagement.domain;

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
@Table(name = "T_CANDIDATE_USER")
public class CandidateUser implements AggregateRoot<Long> {

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
    @JoinColumn(name = "candidate_email", unique = true)
    private Candidate candidate;

    /**
     * cascade = CascadeType.NONE as the systemUser is part of another aggregate
     */
    @OneToOne(optional = false)
    @JoinColumn(name = "account_email", unique = true)
    private SystemUser systemUser;

    CandidateUser(final Candidate candidate, final SystemUser systemUser) {
        Preconditions.noneNull(new Object[] { candidate, systemUser });
        this.candidate = candidate;
        this.systemUser = systemUser;
    }

    protected CandidateUser() {
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

    public Long customerCode() {
        return identity();
    }

    @Override
    public Long identity() {
        return this.pk;
    }
}
