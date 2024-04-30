package lapr4.jobs4u.recruitmentprocessmanagement.domain;

import eapli.framework.domain.model.DomainEntities;
import eapli.framework.domain.model.DomainEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "T_APPLICATION_PHASE")
public class ApplicationPhase extends Phase implements DomainEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pk;

    protected ApplicationPhase(final String initialDate, final String finalDate) {
        super(initialDate, finalDate);
    }

    protected ApplicationPhase() {}

    public static ApplicationPhase valueOf(final String initialDate, final String finalDate) {
        return new ApplicationPhase(initialDate, finalDate);
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
