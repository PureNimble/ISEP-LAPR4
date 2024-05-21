package lapr4.jobs4u.recruitmentprocessmanagement.application;

import java.util.Optional;

import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import org.springframework.transaction.annotation.Transactional;
import lapr4.jobs4u.applicationmanagement.repositories.ApplicationRepository;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
import lapr4.jobs4u.jobopeningmanagement.repositories.JobOpeningInterviewRepository;
import lapr4.jobs4u.jobopeningmanagement.repositories.JobOpeningRepository;
import lapr4.jobs4u.jobopeningmanagement.repositories.JobOpeningRequirementRepository;
import lapr4.jobs4u.recruitmentprocessmanagement.domain.RecruitmentProcess;
import lapr4.jobs4u.recruitmentprocessmanagement.repositories.RecruitmentProcessRepository;
import lapr4.jobs4u.usermanagement.domain.BaseRoles;

@UseCaseController
public class OpenOrClosePhaseController {

    private final AuthorizationService authz;
    private final RecruitmentProcessRepository recruitmentProcessRepository;
    private final JobOpeningRepository jobOpeningRepository;
    private final JobOpeningRequirementRepository jobOpeningRequirementRepository;
    private final JobOpeningInterviewRepository JobOpeningInterviewRepository;
    private final ApplicationRepository ApplicationRepository;

    public OpenOrClosePhaseController(RecruitmentProcessRepository recruitmentProcessRepository,
            JobOpeningRepository jobOpeningRepository, JobOpeningRequirementRepository jobOpeningRequirementRepository,
            JobOpeningInterviewRepository JobOpeningInterviewRepository, ApplicationRepository ApplicationRepository, AuthorizationService authz) {
        this.recruitmentProcessRepository = recruitmentProcessRepository;
        this.jobOpeningRepository = jobOpeningRepository;
        this.jobOpeningRequirementRepository = jobOpeningRequirementRepository;
        this.JobOpeningInterviewRepository = JobOpeningInterviewRepository;
        this.ApplicationRepository = ApplicationRepository;
        this.authz = authz;
    }

    public String currentPhase(JobOpening jobOpening) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER, BaseRoles.POWERUSER);
        Optional<String> phaseOpt = recruitmentProcessRepository.currentPhase(jobOpening);
        if (!phaseOpt.isPresent()) {
            return null;
        }
        String phase = phaseOpt.get();
        return phase;
    }

    @Transactional
    public boolean changePhase(String currentPhase, JobOpening theJobOpening, Boolean moveUp) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER, BaseRoles.POWERUSER);
        RecruitmentProcess recruitmentProcess = recruitmentProcessRepository.findByJobOpening(theJobOpening).get();


        boolean success = switch (currentPhase) {

            case null -> {
                if (moveUp) {
                    recruitmentProcess.applicationPhase().open();
                    theJobOpening.activate();
                } else {
                    yield false;
                }
                yield true;
            }
            case "ApplicationPhase" -> {
                recruitmentProcess.applicationPhase().close();
                if (moveUp) {
                    if (!hasRequirements(theJobOpening)) {
                        yield false;
                    }
                    else{
                        recruitmentProcess.screeningPhase().open();
                    }
                } else {
                    if (!ApplicationRepository.filterByJobOpening(theJobOpening).iterator().hasNext()) {
                        theJobOpening.deactivate();
                    } else {
                        yield false;
                    }
                }
                yield true;
            }
            case "ScreeningPhase" -> {
                recruitmentProcess.screeningPhase().close();
                if (moveUp) {
                    if (recruitmentProcess.interviewPhase() != null) {
                        if (!hasInterviewModel(theJobOpening))
                            yield false;
                        recruitmentProcess.interviewPhase().open();
                    } else {
                        recruitmentProcess.analysisPhase().open();
                    }
                } else {
                    //TODO: redo this verification to check if there is already requirements that have been checked
                    if (!recruitmentProcess.screeningPhase().inProgress()) {
                        recruitmentProcess.applicationPhase().open();
                    } else {
                        yield false;
                    }
                }
                yield true;
            }
            case "InterviewPhase" -> {
                recruitmentProcess.interviewPhase().close();
                if (moveUp) {
                    recruitmentProcess.analysisPhase().open();
                } else {
                    //TODO: redo this verification to check if there is already interviews registered in the system
                    if (!recruitmentProcess.interviewPhase().inProgress()) {
                        recruitmentProcess.screeningPhase().open();
                    } else {
                        yield false;
                    }
                }
                yield true;
            }
            case "AnalysisPhase" -> {
                recruitmentProcess.analysisPhase().close();
                if (moveUp) {
                    recruitmentProcess.resultPhase().open();
                } else {
                    //TODO: redo this verification to check if there is already interviews that have been analyzed
                    if (!recruitmentProcess.analysisPhase().inProgress()) {
                        if (recruitmentProcess.interviewPhase() != null) {
                            recruitmentProcess.interviewPhase().open();
                        } else {
                            recruitmentProcess.screeningPhase().open();
                        }
                    } else {
                        yield false;
                    }
                }
                yield true;
            }
            case "ResultPhase" -> {
                recruitmentProcess.resultPhase().close();
                if (moveUp) {
                    theJobOpening.deactivate();
                } else {
                    //TODO: redo this verification to check if there is already results that have been published
                    if (!recruitmentProcess.resultPhase().inProgress()) {
                        recruitmentProcess.analysisPhase().open();
                    } else {
                        yield false;
                    }
                }
                yield true;
            }
            default -> false;
        };

        if (success) {
            recruitmentProcessRepository.save(recruitmentProcess);
            jobOpeningRepository.save(theJobOpening);
        }

        return success;
    }

    private boolean hasInterviewModel(JobOpening theJobOpening) {
        return JobOpeningInterviewRepository.findJobOpeningInterviewsByJobOpening(theJobOpening).isPresent();
    }

    private boolean hasRequirements(JobOpening theJobOpening) {
        return jobOpeningRequirementRepository.findJobOpeningRequirementsByJobOpening(theJobOpening).isPresent();
    }
}