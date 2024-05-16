package lapr4.jobs4u.recruitmentprocessmanagement.application;

import java.util.Optional;

import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
import lapr4.jobs4u.jobopeningmanagement.repositories.JobOpeningInterviewRepository;
import lapr4.jobs4u.jobopeningmanagement.repositories.JobOpeningRepository;
import lapr4.jobs4u.jobopeningmanagement.repositories.JobOpeningRequirementRepository;
import lapr4.jobs4u.recruitmentprocessmanagement.domain.AnalysisPhase;
import lapr4.jobs4u.recruitmentprocessmanagement.domain.ApplicationPhase;
import lapr4.jobs4u.recruitmentprocessmanagement.domain.InterviewPhase;
import lapr4.jobs4u.recruitmentprocessmanagement.domain.RecruitmentProcess;
import lapr4.jobs4u.recruitmentprocessmanagement.domain.ResultPhase;
import lapr4.jobs4u.recruitmentprocessmanagement.domain.ScreeningPhase;
import lapr4.jobs4u.recruitmentprocessmanagement.repositories.RecruitmentProcessRepository;
import lapr4.jobs4u.usermanagement.domain.BaseRoles;

@UseCaseController
public class OpenOrClosePhaseController {

    private final AuthorizationService authz;
    private final RecruitmentProcessRepository recruitmentProcessRepository;
    private final JobOpeningRepository jobOpeningRepository;
    private final JobOpeningRequirementRepository jobOpeningRequirementRepository;
    private final JobOpeningInterviewRepository JobOpeningInterviewRepository;

    public OpenOrClosePhaseController(RecruitmentProcessRepository recruitmentProcessRepository, JobOpeningRepository jobOpeningRepository, JobOpeningRequirementRepository jobOpeningRequirementRepository, JobOpeningInterviewRepository JobOpeningInterviewRepository, AuthorizationService authz){
        this.recruitmentProcessRepository = recruitmentProcessRepository;
        this.jobOpeningRepository = jobOpeningRepository;
        this.jobOpeningRequirementRepository = jobOpeningRequirementRepository;
        this.JobOpeningInterviewRepository = JobOpeningInterviewRepository;
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

    public boolean changePhase(String currentPhase, JobOpening theJobOpening) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER, BaseRoles.POWERUSER);
        RecruitmentProcess recruitmentProcess = recruitmentProcessRepository.findByJobOpening(theJobOpening).get();
        if (currentPhase == null) {
            ApplicationPhase applicationPhase = recruitmentProcess.applicationPhase();
            applicationPhase.open();
        }
        else if (currentPhase.equals("ApplicationPhase")) {
            if (!hasRequirements(theJobOpening)) {
                return false;
            }
            ApplicationPhase applicationPhase = recruitmentProcess.applicationPhase();
            applicationPhase.close();
            ScreeningPhase screeningPhase = recruitmentProcess.screeningPhase();
            screeningPhase.open();
        } else if (currentPhase.equals("ScreeningPhase")) {
            ScreeningPhase screeningPhase = recruitmentProcess.screeningPhase();
            screeningPhase.close();
            if (recruitmentProcess.interviewPhase() != null){
                if (!hasInterviewModel(theJobOpening)) {
                    return false;
                }
                InterviewPhase interviewPhase = recruitmentProcess.interviewPhase();
                interviewPhase.open();
            } else {
                AnalysisPhase analysisPhase = recruitmentProcess.analysisPhase();
                analysisPhase.open();
            }
        } else if (currentPhase.equals("InterviewPhase")) {
            InterviewPhase interviewPhase = recruitmentProcess.interviewPhase();
            interviewPhase.close();
            AnalysisPhase analysisPhase = recruitmentProcess.analysisPhase();
            analysisPhase.open();
        } else if (currentPhase.equals("AnalysisPhase")) {
            AnalysisPhase analysisPhase = recruitmentProcess.analysisPhase();
            analysisPhase.close();
            ResultPhase resultPhase = recruitmentProcess.resultPhase();
            resultPhase.open();
        } else if (currentPhase.equals("ResultPhase")) {
            ResultPhase resultPhase = recruitmentProcess.resultPhase();
            resultPhase.close();
            theJobOpening.deactivate();
        }
        recruitmentProcessRepository.save(recruitmentProcess);
        jobOpeningRepository.save(theJobOpening);
        return true;
    }

    private boolean hasInterviewModel(JobOpening theJobOpening) {
        return JobOpeningInterviewRepository.findJobOpeningInterviewsByJobOpening(theJobOpening).isPresent();
    }

    private boolean hasRequirements(JobOpening theJobOpening) {
        return jobOpeningRequirementRepository.findJobOpeningRequirementsByJobOpening(theJobOpening).isPresent();
    }
}