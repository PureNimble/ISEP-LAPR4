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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;

/**
 * @author 2DI2
 */
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
    @JoinColumn(nullable = true)
    private InterviewPhase interviewPhase;

    @OneToOne(cascade = CascadeType.ALL)
    private AnalysisPhase analysisPhase;

    @OneToOne(cascade = CascadeType.ALL)
    private ResultPhase resultPhase;

    @OneToOne
    private JobOpening jobOpening;

    RecruitmentProcess(final ApplicationPhase applicationPhase, final ScreeningPhase screeningPhase,
            final InterviewPhase interviewPhase, final AnalysisPhase analysisPhase, final ResultPhase resultPhase,
            final JobOpening jobOpening) {
        Preconditions.noneNull(
                new Object[] { applicationPhase, screeningPhase, interviewPhase, analysisPhase, resultPhase,
                        jobOpening });
        if (!applicationPhase.finalDate().isBefore(screeningPhase.initialDate()) ||
                !screeningPhase.finalDate().isBefore(interviewPhase.initialDate()) ||
                !interviewPhase.finalDate().isBefore(analysisPhase.initialDate()) ||
                !analysisPhase.finalDate().isBefore(resultPhase.initialDate()))
            Actions.throwArgument("The phases must be in the correct order.");
        this.applicationPhase = applicationPhase;
        this.screeningPhase = screeningPhase;
        this.interviewPhase = interviewPhase;
        this.analysisPhase = analysisPhase;
        this.resultPhase = resultPhase;
        this.jobOpening = jobOpening;
    }

    RecruitmentProcess(final ApplicationPhase applicationPhase, final ScreeningPhase screeningPhase,
            final AnalysisPhase analysisPhase, final ResultPhase resultPhase, final JobOpening jobOpening) {
        Preconditions.noneNull(
                new Object[] { applicationPhase, screeningPhase, analysisPhase, resultPhase, jobOpening });
        if (!applicationPhase.finalDate().isBefore(screeningPhase.initialDate()) ||
                !screeningPhase.finalDate().isBefore(analysisPhase.initialDate()) ||
                !analysisPhase.finalDate().isBefore(resultPhase.initialDate()))
            Actions.throwArgument("The phases must be in the correct order.");
        this.applicationPhase = applicationPhase;
        this.screeningPhase = screeningPhase;
        this.interviewPhase = null;
        this.analysisPhase = analysisPhase;
        this.resultPhase = resultPhase;
        this.jobOpening = jobOpening;
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

    public ApplicationPhase applicationPhase() {
        return this.applicationPhase;
    }

    public ScreeningPhase screeningPhase() {
        return this.screeningPhase;
    }

    public InterviewPhase interviewPhase() {
        return this.interviewPhase;
    }

    public AnalysisPhase analysisPhase() {
        return this.analysisPhase;
    }

    public ResultPhase resultPhase() {
        return this.resultPhase;
    }

    public JobOpening jobOpening() {
        return this.jobOpening;
    }

    @Override
    public String toString() {
        return "Application Phase:\n" + applicationPhase.toString() + "\n\nScreening Phase:\n"
                + screeningPhase.toString()
                + (interviewPhase == null ? "" : "\n\nInterview Phase:\n" + interviewPhase.toString())
                + "\n\nAnalysis Phase:\n" + analysisPhase.toString() + "\n\nResult Phase:\n" + resultPhase.toString();
    }
}
