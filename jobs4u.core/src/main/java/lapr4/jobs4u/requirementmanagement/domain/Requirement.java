package lapr4.jobs4u.requirementmanagement.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.validations.Preconditions;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lapr4.jobs4u.applicationmanagement.domain.Application;
import lapr4.jobs4u.applicationmanagement.domain.File;
import lapr4.jobs4u.applicationmanagement.domain.Result;

/**
 * @author 2DI2
 */
@Entity
@Table(name = "T_REQUIREMENT")
public class Requirement implements AggregateRoot<Long> {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Version
    private Long version;

    @ManyToOne(optional = false)
    @JoinColumn(name = "Application", unique = true)
    private Application application;

    @Column(nullable = true)
    private File file;

    @OneToOne(cascade = CascadeType.ALL)
    private Result result;

    protected Requirement(final Application application, Result result) {
        Preconditions.noneNull(new Object[] { application });
        this.application = application;
        this.result = result;
    }

    protected Requirement() {
        // for ORM only
    }

    public static Requirement valueOf(final Application application, final Result result) {
        return new Requirement(application, result);
    }

    public void addFile(final File file) {
        this.file = file;
    }

    public void addResult(String outcome) {
        this.result.addOutcome(outcome);
    }

    public void addResult(String outcome, String justification) {
        this.result.addOutcome(outcome, justification);
    }

    public Application application() {
        return this.application;
    }

    public File file() {
        return this.file;
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

    @Override
    public Long identity() {
        return this.id;
    }

    public String toString() {
        return this.id.toString();
    }

}
