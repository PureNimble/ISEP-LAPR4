package lapr4.jobs4u.recruitmentprocessmanagement.application;

import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
import lapr4.jobs4u.recruitmentprocessmanagement.domain.RecruitmentProcess;
import lapr4.jobs4u.recruitmentprocessmanagement.domain.RecruitmentProcessBuilder;
import lapr4.jobs4u.recruitmentprocessmanagement.repositories.RecruitmentProcessRepository;
import lapr4.jobs4u.usermanagement.domain.BaseRoles;

@UseCaseController
public class SetUpRecruitmentProcessController {
        private final AuthorizationService authz = AuthzRegistry.authorizationService();
        private final RecruitmentProcessRepository recruitmentProcessRepository;

        public SetUpRecruitmentProcessController(final RecruitmentProcessRepository recruitmentProcessRepository) {
                this.recruitmentProcessRepository = recruitmentProcessRepository;
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
                final RecruitmentProcess recruitmentProcess = doSetUpRecruitmentProcess(applicationInitialDate,
                                applicationFinalDate,
                                screeningInitialDate, screeningFinalDate, interviewInitialDate, interviewFinalDate,
                                analysisInitialDate,
                                analysisFinalDate, resultInitialDate, resultFinalDate, jobOpening);
                return recruitmentProcessRepository.save(recruitmentProcess);
        }

        private RecruitmentProcess registerRecruitmentProcess(final String applicationInitialDate,
                        final String applicationFinalDate,
                        final String screeningInitialDate, final String screeningFinalDate,
                        final String analysisInitialDate,
                        final String analysisFinalDate,
                        final String resultInitialDate, final String resultFinalDate, final JobOpening jobOpening) {
                final RecruitmentProcess recruitmentProcess = doSetUpRecruitmentProcess(applicationInitialDate,
                                applicationFinalDate,
                                screeningInitialDate, screeningFinalDate, analysisInitialDate, analysisFinalDate,
                                resultInitialDate,
                                resultFinalDate, jobOpening);
                return recruitmentProcessRepository.save(recruitmentProcess);
        }

        private RecruitmentProcess doSetUpRecruitmentProcess(final String applicationInitialDate,
                        final String applicationFinalDate,
                        final String screeningInitialDate, final String screeningFinalDate,
                        final String interviewInitialDate,
                        final String interviewFinalDate, final String analysisInitialDate,
                        final String analysisFinalDate,
                        final String resultInitialDate, final String resultFinalDate, final JobOpening jobOpening) {
                return new RecruitmentProcessBuilder()
                                .with(applicationInitialDate, applicationFinalDate, screeningInitialDate,
                                                screeningFinalDate,
                                                interviewInitialDate, interviewFinalDate, analysisInitialDate,
                                                analysisFinalDate,
                                                resultInitialDate, resultFinalDate, jobOpening)
                                .build();
        }

        private RecruitmentProcess doSetUpRecruitmentProcess(final String applicationInitialDate,
                        final String applicationFinalDate,
                        final String screeningInitialDate, final String screeningFinalDate,
                        final String analysisInitialDate,
                        final String analysisFinalDate,
                        final String resultInitialDate, final String resultFinalDate, final JobOpening jobOpening) {
                return new RecruitmentProcessBuilder()
                                .with(applicationInitialDate, applicationFinalDate, screeningInitialDate,
                                                screeningFinalDate,
                                                analysisInitialDate, analysisFinalDate, resultInitialDate,
                                                resultFinalDate, jobOpening)
                                .build();
        }
}
