package lapr4.jobs4u.applicationmanagement.domain;

import eapli.framework.domain.model.DomainEntities;
import eapli.framework.domain.model.DomainEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "T_RESULT")
public class Result implements DomainEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pk;

    @Column(nullable = false)
    OutCome outcome;

    Justification justification;

    protected Result(final String outcome, final String justification) {
        this.outcome = new OutCome(outcome);
        this.justification = Justification.valueOf(justification);

    }

    protected Result() {
    }

    @Override
    public int hashCode() {
        return DomainEntities.hashCode(this);
    }

    @Override
    public boolean sameAs(final Object other) {
        return DomainEntities.areEqual(this, other);
    }

    @Override
    public boolean equals(final Object o) {
        return DomainEntities.areEqual(this, o);
    }

    public Long pk() {
        return identity();
    }

    @Override
    public Long identity() {
        return this.pk;
    }
}
