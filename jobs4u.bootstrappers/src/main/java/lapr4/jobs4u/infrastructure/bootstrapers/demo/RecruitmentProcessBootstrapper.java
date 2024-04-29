package lapr4.jobs4u.infrastructure.bootstrapers.demo;

import eapli.framework.actions.Action;
import lapr4.jobs4u.infrastructure.bootstrapers.RecruitmentProcessBootstrapperBase;

public class RecruitmentProcessBootstrapper extends RecruitmentProcessBootstrapperBase implements Action {

    @Override
    public boolean execute() {
        registerRecruitmentProcess(
                "02-03-2023", "03-03-2023", // application phase
                "04-03-2023", "05-03-2023", // screening phase
                "06-03-2023", "07-03-2023", // interview phase
                "08-03-2023", "09-03-2023", // analysis phase
                "10-03-2023", "11-03-2023" // result phase
        );
        return true;
    }

    private void registerRecruitmentProcess(final String applicationInitialDate,
            final String applicationFinalDate,
            final String screeningInitialDate, final String screeningFinalDate, final String interviewInitialDate,
            final String interviewFinalDate, final String analysisInitialDate, final String analysisFinalDate,
            final String resultInitialDate, final String resultFinalDate) {

        setUpRecruitmentProcess(applicationInitialDate, applicationFinalDate, screeningInitialDate,
                screeningFinalDate, interviewInitialDate, interviewFinalDate, analysisInitialDate, analysisFinalDate,
                resultInitialDate, resultFinalDate);
    }
}
