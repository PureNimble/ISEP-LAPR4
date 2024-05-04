package lapr4.jobs4u.jobopeningmanagement.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.validations.Preconditions;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lapr4.jobs4u.integration.questions.import_.domain.QuestionImporterPlugin;

@Entity
@Table(name = "T_JOB_OPENING_INTERVIEW")
public class JobOpeningInterview implements AggregateRoot<Long> {

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
    @JoinColumn(name = "job_reference", unique = true)
    private JobOpening jobOpening;

    @ManyToOne(optional = false)
    @JoinColumn(name = "plugin_id")
    private QuestionImporterPlugin plugin;

    JobOpeningInterview(final JobOpening jobopening, final QuestionImporterPlugin plugin) {
        Preconditions.noneNull(new Object[] { jobopening, plugin });
        this.plugin = plugin;
        this.jobOpening = jobopening;
    }

    protected JobOpeningInterview() {
        // for ORM only
    }

    public static JobOpeningInterview valueOf(final JobOpening jobopening, final QuestionImporterPlugin plugin) {
        return new JobOpeningInterview(jobopening, plugin);
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
