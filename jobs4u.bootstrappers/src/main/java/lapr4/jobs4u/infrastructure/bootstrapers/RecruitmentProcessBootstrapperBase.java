package lapr4.jobs4u.infrastructure.bootstrapers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import lapr4.jobs4u.infrastructure.persistence.PersistenceContext;
import lapr4.jobs4u.recruitmentprocessmanagement.application.SetUpRecruitmentProcessController;
import lapr4.jobs4u.recruitmentprocessmanagement.domain.RecruitmentProcess;

public class RecruitmentProcessBootstrapperBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(UsersBootstrapperBase.class);

    final SetUpRecruitmentProcessController setUpRecruitmentProcessController = new SetUpRecruitmentProcessController(
            PersistenceContext.repositories().recruitmentProcesses());

    public RecruitmentProcessBootstrapperBase() {
        super();
    }

    /**
     * @param username
     * @param password
     * @param firstName
     * @param lastName
     * @param email
     * @param roles
     */
    protected RecruitmentProcess setUpRecruitmentProcess(final String applicationInitialDate,
            final String applicationFinalDate,
            final String screeningInitialDate, final String screeningFinalDate, final String interviewInitialDate,
            final String interviewFinalDate, final String analysisInitialDate, final String analysisFinalDate,
            final String resultInitialDate, final String resultFinalDate) {
                RecruitmentProcess u = null;
        try {
            u = setUpRecruitmentProcessController.SetUpRecruitmentProcess(applicationInitialDate, applicationFinalDate,
                    screeningInitialDate, screeningFinalDate, interviewInitialDate, interviewFinalDate, analysisInitialDate, 
                    analysisFinalDate, resultInitialDate, resultFinalDate);
        } catch (final IntegrityViolationException | ConcurrencyException e) {
            // assuming it is just a primary key violation due to the tentative
            // of inserting a duplicated user. let's just lookup that user
        }
        return u;
    }
}
