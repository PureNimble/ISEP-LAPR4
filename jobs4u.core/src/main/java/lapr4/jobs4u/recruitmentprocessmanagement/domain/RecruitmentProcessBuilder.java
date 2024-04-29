package lapr4.jobs4u.recruitmentprocessmanagement.domain;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import eapli.framework.domain.model.DomainFactory;

public class RecruitmentProcessBuilder implements DomainFactory<RecruitmentProcess> {

    private static final Logger LOGGER = LogManager.getLogger(RecruitmentProcessBuilder.class);
    private ApplicationPhase applicationPhase;
    private ScreeningPhase screeningPhase;
    private InterviewPhase interviewPhase;
    private AnalysisPhase analysisPhase;
    private ResultPhase resultPhase;

    public RecruitmentProcessBuilder with(final String applicationInitialDate, final String applicationFinalDate,
            final String screeningInitialDate, final String screeningFinalDate, final String interviewInitialDate,
            final String interviewFinalDate, final String analysisInitialDate, final String analysisFinalDate,
            final String resultInitialDate, final String resultFinalDate) {
        this.withApplicationPhase(applicationInitialDate, applicationInitialDate);
        this.withScreeningPhase(screeningInitialDate, screeningFinalDate);
        this.withInterviewPhase(interviewInitialDate, interviewFinalDate);
        this.withAnalysisPhase(analysisInitialDate, analysisFinalDate);
        this.withResultPhase(resultInitialDate, resultFinalDate);
        return this;
    }

    public RecruitmentProcessBuilder with(final String applicationInitialDate, final String applicationFinalDate,
    final String screeningInitialDate, final String screeningFinalDate, final String analysisInitialDate, final String analysisFinalDate,
    final String resultInitialDate, final String resultFinalDate) {
        this.withApplicationPhase(applicationInitialDate, applicationInitialDate);
        this.withScreeningPhase(screeningInitialDate, screeningFinalDate);
        this.withAnalysisPhase(analysisInitialDate, analysisFinalDate);
        this.withResultPhase(resultInitialDate, resultFinalDate);
        return this;
    }

    public RecruitmentProcessBuilder withApplicationPhase(final String initialDate, final String finalDate) {
        this.applicationPhase = ApplicationPhase.valueOf(initialDate, finalDate);
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

    @Override
    public RecruitmentProcess build() {
        final RecruitmentProcess recruitmentProcess = new RecruitmentProcess(this.applicationPhase, this.screeningPhase,
                this.interviewPhase, this.analysisPhase, this.resultPhase);
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Registering new recruitmentProcess [{}] {} {} {} {} {}", recruitmentProcess,
                    this.applicationPhase,
                    this.screeningPhase, this.interviewPhase, this.analysisPhase, this.resultPhase);
        }
        return recruitmentProcess;
    }
}
