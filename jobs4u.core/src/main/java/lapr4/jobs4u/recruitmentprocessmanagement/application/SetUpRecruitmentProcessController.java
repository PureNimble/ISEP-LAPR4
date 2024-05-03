package lapr4.jobs4u.recruitmentprocessmanagement.application;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.time.util.CurrentTimeCalendars;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
import lapr4.jobs4u.recruitmentprocessmanagement.domain.RecruitmentProcess;
import lapr4.jobs4u.recruitmentprocessmanagement.domain.RecruitmentProcessBuilder;
import lapr4.jobs4u.recruitmentprocessmanagement.repositories.RecruitmentProcessRepository;
import lapr4.jobs4u.usermanagement.domain.BaseRoles;
import lapr4.jobs4u.jobopeningmanagement.repositories.JobOpeningRepository;

@UseCaseController
public class SetUpRecruitmentProcessController {
        private final AuthorizationService authz;
        private final RecruitmentProcessRepository recruitmentProcessRepository;
        private final JobOpeningRepository jobOpeningRepository;

        public SetUpRecruitmentProcessController(final RecruitmentProcessRepository recruitmentProcessRepository,
                        final JobOpeningRepository jobOpeningRepository,
                        final AuthorizationService authz) {
                this.recruitmentProcessRepository = recruitmentProcessRepository;
                this.jobOpeningRepository = jobOpeningRepository;
                this.authz = authz;
        }

        public RecruitmentProcess SetUpRecruitmentProcess(final String applicationInitialDate,
                        final String applicationFinalDate,
                        final String screeningInitialDate, final String screeningFinalDate,
                        final String interviewInitialDate,
                        final String interviewFinalDate, final String analysisInitialDate,
                        final String analysisFinalDate,
                        final String resultInitialDate, final String resultFinalDate, final JobOpening jobOpening) {
                authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER);
                return registerRecruitmentProcess(applicationInitialDate, applicationFinalDate, screeningInitialDate,
                                screeningFinalDate, interviewInitialDate, interviewFinalDate, analysisInitialDate,
                                analysisFinalDate,
                                resultInitialDate, resultFinalDate, jobOpening);
        }

        public RecruitmentProcess SetUpRecruitmentProcess(final String applicationInitialDate,
                        final String applicationFinalDate,
                        final String screeningInitialDate, final String screeningFinalDate,
                        final String analysisInitialDate,
                        final String analysisFinalDate,
                        final String resultInitialDate, final String resultFinalDate, final JobOpening jobOpening) {
                authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER);
                return registerRecruitmentProcess(applicationInitialDate, applicationFinalDate, screeningInitialDate,
                                screeningFinalDate, analysisInitialDate, analysisFinalDate, resultInitialDate,
                                resultFinalDate, jobOpening);
        }

        private RecruitmentProcess registerRecruitmentProcess(final String applicationInitialDate,
                        final String applicationFinalDate,
                        final String screeningInitialDate, final String screeningFinalDate,
                        final String interviewInitialDate,
                        final String interviewFinalDate, final String analysisInitialDate,
                        final String analysisFinalDate,
                        final String resultInitialDate, final String resultFinalDate, final JobOpening jobOpening) {
                SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
                Calendar calendar = CurrentTimeCalendars.now();
                Date date = calendar.getTime();
                String formattedDate = format.format(date);
                final RecruitmentProcess recruitmentProcess = doSetUpRecruitmentProcess(applicationInitialDate,
                                applicationFinalDate,
                                screeningInitialDate, screeningFinalDate, interviewInitialDate, interviewFinalDate,
                                analysisInitialDate,
                                analysisFinalDate, resultInitialDate, resultFinalDate, jobOpening,
                                formattedDate);
                RecruitmentProcess re = recruitmentProcessRepository.save(recruitmentProcess);
                activateJobOpening(jobOpening);
                return re;
        }

        private RecruitmentProcess registerRecruitmentProcess(final String applicationInitialDate,
                        final String applicationFinalDate,
                        final String screeningInitialDate, final String screeningFinalDate,
                        final String analysisInitialDate,
                        final String analysisFinalDate,
                        final String resultInitialDate, final String resultFinalDate, final JobOpening jobOpening) {
                SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
                Calendar calendar = CurrentTimeCalendars.now();
                Date date = calendar.getTime();
                String formattedDate = format.format(date);
                final RecruitmentProcess recruitmentProcess = doSetUpRecruitmentProcess(applicationInitialDate,
                                applicationFinalDate,
                                screeningInitialDate, screeningFinalDate, analysisInitialDate, analysisFinalDate,
                                resultInitialDate,
                                resultFinalDate, jobOpening, formattedDate);
                RecruitmentProcess re = recruitmentProcessRepository.save(recruitmentProcess);
                activateJobOpening(jobOpening);
                return re;
        }

        private RecruitmentProcess doSetUpRecruitmentProcess(final String applicationInitialDate,
                        final String applicationFinalDate,
                        final String screeningInitialDate, final String screeningFinalDate,
                        final String interviewInitialDate,
                        final String interviewFinalDate, final String analysisInitialDate,
                        final String analysisFinalDate,
                        final String resultInitialDate, final String resultFinalDate, final JobOpening jobOpening,
                        final String registeredOn) {
                return new RecruitmentProcessBuilder()
                                .with(applicationInitialDate, applicationFinalDate, screeningInitialDate,
                                                screeningFinalDate,
                                                interviewInitialDate, interviewFinalDate, analysisInitialDate,
                                                analysisFinalDate,
                                                resultInitialDate, resultFinalDate, jobOpening, registeredOn)
                                .build();
        }

        private RecruitmentProcess doSetUpRecruitmentProcess(final String applicationInitialDate,
                        final String applicationFinalDate,
                        final String screeningInitialDate, final String screeningFinalDate,
                        final String analysisInitialDate,
                        final String analysisFinalDate,
                        final String resultInitialDate, final String resultFinalDate, final JobOpening jobOpening,
                        final String registeredOn) {
                return new RecruitmentProcessBuilder()
                                .with(applicationInitialDate, applicationFinalDate, screeningInitialDate,
                                                screeningFinalDate,
                                                analysisInitialDate, analysisFinalDate, resultInitialDate,
                                                resultFinalDate, jobOpening, registeredOn)
                                .build();
        }

        private void activateJobOpening(final JobOpening jobOpening) {
                jobOpening.activate();
                jobOpeningRepository.save(jobOpening);
        }
}
