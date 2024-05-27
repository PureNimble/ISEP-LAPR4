package lapr4.jobs4u.recruitmentprocessmanagement.domain;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import eapli.framework.domain.model.DomainFactory;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;

/**
 * @author 2DI2
 */
public class RecruitmentProcessBuilder implements DomainFactory<RecruitmentProcess> {

    private static final Logger LOGGER = LogManager.getLogger(RecruitmentProcessBuilder.class);
    private ApplicationPhase applicationPhase;
    private ScreeningPhase screeningPhase;
    private InterviewPhase interviewPhase;
    private AnalysisPhase analysisPhase;
    private ResultPhase resultPhase;
    private JobOpening jobOpening;

    public RecruitmentProcessBuilder with(final String applicationInitialDate, final String applicationFinalDate,
            final String screeningInitialDate, final String screeningFinalDate, final String interviewInitialDate,
            final String interviewFinalDate, final String analysisInitialDate, final String analysisFinalDate,
            final String resultInitialDate, final String resultFinalDate, final JobOpening jobOpening,
            final String minDate) {
        this.withApplicationPhase(applicationInitialDate, applicationFinalDate, minDate);
        this.withScreeningPhase(screeningInitialDate, screeningFinalDate);
        this.withInterviewPhase(interviewInitialDate, interviewFinalDate);
        this.withAnalysisPhase(analysisInitialDate, analysisFinalDate);
        this.withResultPhase(resultInitialDate, resultFinalDate);
        this.withJobOpening(jobOpening);
        return this;
    }

    public RecruitmentProcessBuilder with(final String applicationInitialDate, final String applicationFinalDate,
            final String screeningInitialDate, final String screeningFinalDate, final String analysisInitialDate,
            final String analysisFinalDate,
            final String resultInitialDate, final String resultFinalDate, JobOpening jobOpening, final String minDate) {
        this.withApplicationPhase(applicationInitialDate, applicationFinalDate, minDate);
        this.withScreeningPhase(screeningInitialDate, screeningFinalDate);
        this.interviewPhase = null;
        this.withAnalysisPhase(analysisInitialDate, analysisFinalDate);
        this.withResultPhase(resultInitialDate, resultFinalDate);
        this.withJobOpening(jobOpening);
        return this;
    }

    public RecruitmentProcessBuilder withApplicationPhase(final String initialDate, final String finalDate,
            final String minDate) {
        this.applicationPhase = ApplicationPhase.valueOf(initialDate, finalDate, minDate);
        return this;
    }

    public RecruitmentProcessBuilder withScreeningPhase(final String initialDate, final String finalDate) {
        this.screeningPhase = ScreeningPhase.valueOf(initialDate, finalDate);
        return this;
    }

    public RecruitmentProcessBuilder withInterviewPhase(final String initialDate, final String finalDate) {
        this.interviewPhase = InterviewPhase.valueOf(initialDate, finalDate);
        return this;
    }

    public RecruitmentProcessBuilder withAnalysisPhase(final String initialDate, final String finalDate) {
        this.analysisPhase = AnalysisPhase.valueOf(initialDate, finalDate);
        return this;
    }

    public RecruitmentProcessBuilder withResultPhase(final String initialDate, final String finalDate) {
        this.resultPhase = ResultPhase.valueOf(initialDate, finalDate);
        return this;
    }

    public RecruitmentProcessBuilder withJobOpening(JobOpening jobOpening) {
        this.jobOpening = jobOpening;
        return this;
    }

    @Override
    public RecruitmentProcess build() {
        final RecruitmentProcess recruitmentProcess;
        if (this.interviewPhase == null) {
            recruitmentProcess = new RecruitmentProcess(this.applicationPhase, this.screeningPhase,
                    this.analysisPhase, this.resultPhase, this.jobOpening);
        } else {
            recruitmentProcess = new RecruitmentProcess(this.applicationPhase, this.screeningPhase,
                    this.interviewPhase, this.analysisPhase, this.resultPhase, this.jobOpening);
        }
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("Registering new Recruitment Process [{}] {} {} {} {} {} {}", recruitmentProcess,
                    this.applicationPhase,
                    this.screeningPhase, this.interviewPhase, this.analysisPhase, this.resultPhase, this.jobOpening);
        }
        return recruitmentProcess;
    }
}
