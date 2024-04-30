package lapr4.jobs4u.applicationmanagement.domain;

import java.util.List;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.validations.Preconditions;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lapr4.jobs4u.recruitmentprocessmanagement.domain.Date;

@Entity
@Table(name = "T_APPLICATION")
public class Application implements AggregateRoot<ApplicationNumber> {

    private static final long serialVersionUID = 1L;

    @Version
    private Long version;

    @EmbeddedId
    private ApplicationNumber applicationNumber;

    @Column(nullable = false)
    private Date date;

    @OneToOne()
    private Result result;

    @ElementCollection
    private List<File> file;
    // TODO: add JobOpening
    // @OneToOne(optional = false)
    // @JoinColumn(name = "JobOpennig", unique = true)
    // private JobOpening jobOpening;

    Application(final Date date, final ApplicationNumber applicationNumber,
            final List<File> file) {
        Preconditions.noneNull(new Object[] { date, applicationNumber, file });
        this.date = date;
        this.applicationNumber = applicationNumber;
        this.file = file;

    }

    protected Application() {
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

    public ApplicationNumber applicationNumber() {
        return identity();
    }

    public void addResult(Result result) {
        this.result = result;
    }

    @Override
    public ApplicationNumber identity() {
        return this.applicationNumber;
    }

}
