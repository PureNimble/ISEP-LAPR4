package lapr4.jobs4u.rankmanagement.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.validations.Preconditions;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lapr4.jobs4u.applicationmanagement.domain.Application;
import lapr4.jobs4u.rankmanagement.dto.RankDTO;

/**
 * @author 2DI2
 */
@Entity
@Table(name = "T_RANK")
public class Rank implements AggregateRoot<Long> {

    private static final long serialVersionUID = 1L;

    @Version
    private Long version;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pk;

    @Column(nullable = false)
    private RankPlacement rankPlacement;

    @OneToOne
    private Application application;

    Rank(final RankPlacement rankPlacement, final Application application) {
        Preconditions.noneNull(new Object[] { rankPlacement, application });
        this.rankPlacement = rankPlacement;
        this.application = application;
    }

    protected Rank() {
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

    @Override
    public Long identity() {
        return this.pk;
    }

    public RankPlacement rankPlacement() {
        return this.rankPlacement;
    }

    public Application application() {
        return this.application;
    }

    public RankDTO toDTO() {
        return new RankDTO(this.pk.toString(), this.rankPlacement.toString(),
                this.application.candidate().emailAddress().toString(),
                this.application.candidate().name().toString());
    }

    public void replace(final RankPlacement placement){
        this.rankPlacement = placement;
    }

    @Override
    public String toString() {
        return pk.toString();
    }
}
