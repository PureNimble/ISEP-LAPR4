package lapr4.jobs4u.applicationmanagement.domain;

import eapli.framework.domain.model.DomainEntities;
import eapli.framework.domain.model.DomainEntity;
import eapli.framework.validations.Preconditions;
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
    Outcome outcome;

    @Column(nullable = true)
    Justification justification;

    protected Result(String outcome) {
        this.outcome = new Outcome(outcome);
    }

    protected Result(String outcome, String justification) {
        this.outcome = new Outcome(outcome);
        this.justification = new Justification(justification);
    }

    protected Result() {
        // for ORM
    }

    public static Result valueOf(String outcome) {
        return new Result(outcome);
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

    public void addOutcome(String outcome, String justification) {
        Preconditions.nonEmpty(outcome, justification);
        this.outcome = new Outcome(outcome);
        this.justification = new Justification(justification);
    }

    public void addOutcome(String outcome) {
        Preconditions.nonEmpty(outcome);
        Preconditions.ensure(outcome.equals(OutcomeValue.APPROVED.toString()),
                "Justification is only needed for rejected applications.");
        this.outcome = new Outcome(outcome);
    }

    @Override
    public Long identity() {
        return this.pk;
    }
}
