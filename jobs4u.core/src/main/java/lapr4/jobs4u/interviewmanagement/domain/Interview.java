package lapr4.jobs4u.interviewmanagement.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.validations.Preconditions;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lapr4.jobs4u.applicationmanagement.domain.Application;
import lapr4.jobs4u.applicationmanagement.domain.File;
import lapr4.jobs4u.recruitmentprocessmanagement.domain.Date;

@Entity
@Table(name = "T_INTERVIEW")
public class Interview implements AggregateRoot<Long> {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Version
    private Long version;

    @Column(nullable = false)
    private Date date;

    @Column(nullable = false)
    private Time time;

    @ManyToOne(optional = false)
    @JoinColumn(name = "Application")
    private Application application;

    @Column(nullable = true)
    private File file;

    protected Interview(final String date, final String time, final Application application) {
        Preconditions.noneNull(new Object[] { date, time, application });
        this.date = Date.valueOf(date);
        this.time = Time.valueOf(time);
        this.application = application;
    }

    protected Interview() {
        // for ORM only
    }

    public static Interview valueOf(final String date, final String time, final Application application) {
        return new Interview(date, time, application);
    }

    public void addFile(File file) {
        Preconditions.nonNull(file);
        this.file = file;
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
        return this.date.toString() + "-" + this.time.toString();
    }

}
