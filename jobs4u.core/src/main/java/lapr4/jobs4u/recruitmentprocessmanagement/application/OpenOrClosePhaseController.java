package lapr4.jobs4u.recruitmentprocessmanagement.application;

import java.util.Optional;
import eapli.framework.application.UseCaseController;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import lapr4.jobs4u.applicationmanagement.repositories.ApplicationRepository;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpeningState;
import lapr4.jobs4u.jobopeningmanagement.domain.TypesOfJobOpeningStates;
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
    private final TransactionalContext txCtx;

    public OpenOrClosePhaseController(RecruitmentProcessRepository recruitmentProcessRepository,
            JobOpeningRepository jobOpeningRepository, JobOpeningRequirementRepository jobOpeningRequirementRepository,
            JobOpeningInterviewRepository JobOpeningInterviewRepository, ApplicationRepository ApplicationRepository,
            AuthorizationService authz, TransactionalContext txCtx) {
        this.recruitmentProcessRepository = recruitmentProcessRepository;
        this.jobOpeningRepository = jobOpeningRepository;
        this.jobOpeningRequirementRepository = jobOpeningRequirementRepository;
        this.JobOpeningInterviewRepository = JobOpeningInterviewRepository;
        this.ApplicationRepository = ApplicationRepository;
        this.authz = authz;
        this.txCtx = txCtx;
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

    public boolean changePhase(String currentPhase, JobOpening theJobOpening, Boolean moveUp) throws Exception {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER, BaseRoles.POWERUSER);
        RecruitmentProcess recruitmentProcess = recruitmentProcessRepository.findByJobOpening(theJobOpening).get();

        txCtx.beginTransaction();
        switch (currentPhase) {

            case null -> {
                if (theJobOpening.jobOpeningState().equals(JobOpeningState.valueOf(TypesOfJobOpeningStates.PENDING.toString()))) {
                    if (moveUp) {
                        recruitmentProcess.applicationPhase().open();
                        theJobOpening.activate();
                    }
                    else {
                        throw new Exception("The job opening is in the initial state! Cannot go to a previous phase");
                    }
                } else if (theJobOpening.jobOpeningState().equals(JobOpeningState.valueOf(TypesOfJobOpeningStates.CLOSED.toString()))) {
                    if (moveUp) {
                        throw new Exception("The job opening is closed! There are no more phases to open next");
                    } else {
                        recruitmentProcess.resultPhase().close();
                        theJobOpening.deactivate(currentPhase);
                    }
                } else {
                    throw new Exception("The job opening is in an invalid state");
                }
                
            }

            case "ApplicationPhase" -> {
                recruitmentProcess.applicationPhase().close();
                if (moveUp) {
                    if (!hasRequirements(theJobOpening)) {
                        throw new Exception("No requirements specifications associated with the job opening: "
                                + theJobOpening.jobReference());
                    } else if (!hasApplications(theJobOpening)) {
                        throw new Exception("You cannot move to the screening phase without applications");
                    } else {
                        recruitmentProcess.screeningPhase().open();
                    }
                } else {
                    if (!hasApplications(theJobOpening)) {
                        theJobOpening.deactivate(currentPhase);
                    } else {
                        throw new Exception("Cannot go to the previous phase! Application phase is already in progress");
                    }
                }
            }

            case "ScreeningPhase" -> {
                recruitmentProcess.screeningPhase().close();
                if (moveUp) {
                    if (recruitmentProcess.interviewPhase() != null) {
                        if (!hasInterviewModel(theJobOpening))
                            throw new Exception("No interview model associated with the job opening: "
                                    + theJobOpening.jobReference());
                        recruitmentProcess.interviewPhase().open();
                    } else {
                        recruitmentProcess.analysisPhase().open();
                    }
                } else {
                    if (!recruitmentProcess.screeningPhase().inProgress()) {
                        recruitmentProcess.applicationPhase().open();
                    } else {
                        throw new Exception("Cannot go to the previous phase! Screening phase is already in progress");
                    }
                }
            }

            case "InterviewPhase" -> {
                recruitmentProcess.interviewPhase().close();
                if (moveUp) {
                    recruitmentProcess.analysisPhase().open();
                } else {
                    if (!recruitmentProcess.interviewPhase().inProgress()) {
                        recruitmentProcess.screeningPhase().open();
                    } else {
                        throw new Exception("Cannot go to the previous phase! Interview phase is already in progress");
                    }
                }
            }

            case "AnalysisPhase" -> {
                recruitmentProcess.analysisPhase().close();
                if (moveUp) {
                    recruitmentProcess.resultPhase().open();
                } else {
                    if (!recruitmentProcess.analysisPhase().inProgress()) {
                        if (recruitmentProcess.interviewPhase() != null) {
                            recruitmentProcess.interviewPhase().open();
                        } else {
                            recruitmentProcess.screeningPhase().open();
                        }
                    } else {
                        throw new Exception("Cannot go to the previous phase! Analysis phase is already in progress");
                    }
                }
            }

            case "ResultPhase" -> {
                recruitmentProcess.resultPhase().close();
                if (moveUp) {
                    theJobOpening.deactivate(currentPhase);
                } else {
                    if (!recruitmentProcess.resultPhase().inProgress()) {
                        recruitmentProcess.analysisPhase().open();
                    } else {
                        throw new Exception("Cannot go to the previous phase! Result phase is already in progress");
                    }
                }
            }

            default -> throw new Exception("Invalid phase: " + currentPhase);
        }
        ;

        recruitmentProcessRepository.save(recruitmentProcess);
        jobOpeningRepository.save(theJobOpening);
        try {
            txCtx.commit();
        } catch (final Exception e) {
            txCtx.rollback();
            throw new RuntimeException("Error occurred while committing the transaction. Rolled back.", e);
        } finally {
            txCtx.close();
        }
        return true;

    }

    private boolean hasInterviewModel(JobOpening theJobOpening) {
        return JobOpeningInterviewRepository.findJobOpeningInterviewsByJobOpening(theJobOpening).isPresent();
    }

    private boolean hasRequirements(JobOpening theJobOpening) {
        return jobOpeningRequirementRepository.findJobOpeningRequirementsByJobOpening(theJobOpening).isPresent();
    }

    private boolean hasApplications(JobOpening theJobOpening) {
        return ApplicationRepository.filterByJobOpening(theJobOpening).iterator().hasNext();
    }
}