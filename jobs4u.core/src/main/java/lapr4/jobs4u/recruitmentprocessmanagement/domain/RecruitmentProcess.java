package lapr4.jobs4u.recruitmentprocessmanagement.domain;

import eapli.framework.actions.Actions;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.validations.Preconditions;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

@Entity
@Table(name = "T_RECRUITMENT_PROCESS")
public class RecruitmentProcess implements AggregateRoot<Long> {

    private static final long serialVersionUID = 1L;

    @Version
    private Long version;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pk;

    @OneToOne(cascade = CascadeType.ALL)
    private ApplicationPhase applicationPhase;

    @OneToOne(cascade = CascadeType.ALL)
    private ScreeningPhase screeningPhase;

    @OneToOne(cascade = CascadeType.ALL)
    private InterviewPhase interviewPhase;

    @OneToOne(cascade = CascadeType.ALL)
    private AnalysisPhase analysisPhase;

    @OneToOne(cascade = CascadeType.ALL)
    private ResultPhase resultPhase;

    RecruitmentProcess(final ApplicationPhase applicationPhase, final ScreeningPhase screeningPhase,
            final InterviewPhase interviewPhase, final AnalysisPhase analysisPhase, final ResultPhase resultPhase) {
        Preconditions.noneNull(
                new Object[] { applicationPhase, screeningPhase, interviewPhase, analysisPhase, resultPhase });
        if (!applicationPhase.finalDate().isBefore(screeningPhase.initialDate()) ||
                !screeningPhase.finalDate().isBefore(interviewPhase.initialDate()) ||
                !interviewPhase.finalDate().isBefore(analysisPhase.initialDate()) ||
                !analysisPhase.finalDate().isBefore(resultPhase.initialDate()))
            Actions.throwArgument("At least one of the required method parameters is null");
        this.applicationPhase = applicationPhase;
        this.screeningPhase = screeningPhase;
        this.interviewPhase = interviewPhase;
        this.analysisPhase = analysisPhase;
        this.resultPhase = resultPhase;
    }

    RecruitmentProcess(final ApplicationPhase applicationPhase, final ScreeningPhase screeningPhase,
            final AnalysisPhase analysisPhase, final ResultPhase resultPhase) {
        Preconditions.noneNull(
                new Object[] { applicationPhase, screeningPhase, analysisPhase, resultPhase });
        this.applicationPhase = applicationPhase;
        this.screeningPhase = screeningPhase;
        this.analysisPhase = analysisPhase;
        this.resultPhase = resultPhase;
    }

    protected RecruitmentProcess() {
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

    public Long pk() {
        return identity();
    }

    @Override
    public Long identity() {
        return this.pk;
    }

}
