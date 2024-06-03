package lapr4.jobs4u.rankmanagement.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import jakarta.persistence.*;
import lapr4.jobs4u.applicationmanagement.domain.Application;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;

@Entity
@Table(name = "T_RANK")
public class Rank implements AggregateRoot<RankReference> {
    private static final long serialVersionUID = 1L;

    @Version
    private Long version;

    @EmbeddedId
    private RankReference rankReference;

    @Column (nullable = false)
    private RankPlacement rankPlacement;

    @OneToOne
    private JobOpening jobOpening;

    @OneToOne
    private Application application;

    Rank(final RankReference rankReference, final RankPlacement rankPlacement, final JobOpening jobOpening, final Application application) {
        this.rankReference = rankReference;
        this.rankPlacement = rankPlacement;
        this.jobOpening = jobOpening;
        this.application = application;
    }

    protected Rank() {
        //for ORM only
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
    public RankReference identity() {
        return this.rankReference;
    }

    @Override
    public String toString() {
        return rankReference.toString();
    }
}
