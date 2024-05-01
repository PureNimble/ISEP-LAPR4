package lapr4.jobs4u.applicationmanagement.domain;

import java.util.List;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.validations.Preconditions;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lapr4.jobs4u.candidatemanagement.domain.Candidate;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
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

    @ManyToOne(optional = false)
    @JoinColumn(name = "JobOpening")
    private JobOpening jobOpening;

    @ManyToOne(optional = false)
    @JoinColumn(name = "Candidate")
    private Candidate candidate;

    Application(final Date date, final ApplicationNumber applicationNumber,
            final List<File> file, final JobOpening jobOpening, final Candidate candidate,
            final Result result) {
        Preconditions.noneNull(new Object[] { date, applicationNumber, file, jobOpening, candidate, result });
        this.date = date;
        this.applicationNumber = applicationNumber;
        this.file = file;
        this.jobOpening = jobOpening;
        this.candidate = candidate;
        this.result = result;
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

    public void addResult(String outcome) {
        this.result.addOutcome(outcome);
    }

    public void addResult(String outcome, String justification) {
        this.result.addOutcome(outcome, justification);
    }

    @Override
    public ApplicationNumber identity() {
        return this.applicationNumber;
    }

}
