package lapr4.jobs4u.jobopeningmanagement.application;

import java.util.Optional;

import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import lapr4.jobs4u.customermanagement.domain.Address;
import lapr4.jobs4u.integration.questions.importer.domain.QuestionImporterPlugin;
import lapr4.jobs4u.jobopeningmanagement.domain.ContractType;
import lapr4.jobs4u.jobopeningmanagement.domain.JobDescription;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpeningInterview;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpeningRequirement;
import lapr4.jobs4u.jobopeningmanagement.domain.Mode;
import lapr4.jobs4u.jobopeningmanagement.domain.NumberOfVacancies;
import lapr4.jobs4u.jobopeningmanagement.domain.TitleOrFunction;
import lapr4.jobs4u.jobopeningmanagement.repositories.JobOpeningInterviewRepository;
import lapr4.jobs4u.jobopeningmanagement.repositories.JobOpeningRepository;
import lapr4.jobs4u.jobopeningmanagement.repositories.JobOpeningRequirementRepository;
import lapr4.jobs4u.recruitmentprocessmanagement.domain.RecruitmentProcess;
import lapr4.jobs4u.recruitmentprocessmanagement.repositories.RecruitmentProcessRepository;
import lapr4.jobs4u.usermanagement.domain.BaseRoles;

/**
 * @author 2DI2
 */
@UseCaseController
public class EditJobOpeningController {

    private final JobOpeningRepository jobOpeningRepository;
    private final JobOpeningInterviewRepository jobOpeningInterviewRepository;
    private final JobOpeningRequirementRepository jobOpeningRequirementRepository;
    private final RecruitmentProcessRepository recruitmentProcessRepository;
    private final AuthorizationService authz;

    public EditJobOpeningController(final JobOpeningRepository jobOpeningRepository,
            final JobOpeningInterviewRepository jobOpeningInterviewRepository,
            final JobOpeningRequirementRepository jobOpeningRequirementRepository,
            final RecruitmentProcessRepository recruitmentProcessRepository,
            final AuthorizationService authz) {

        this.jobOpeningRepository = jobOpeningRepository;
        this.jobOpeningInterviewRepository = jobOpeningInterviewRepository;
        this.jobOpeningRequirementRepository = jobOpeningRequirementRepository;
        this.recruitmentProcessRepository = recruitmentProcessRepository;
        this.authz = authz;

    }

    public JobOpening editJobOpening(final String titleOrFunction, final String contractType,
            final String mode, final String address, final String jobDescription,
            final String numberOfVacancies, final JobOpening jobOpening) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER, BaseRoles.POWERUSER);

        return doEditJobOpening(titleOrFunction, contractType, mode, address, jobDescription,
                numberOfVacancies, jobOpening);
    }

    private JobOpening doEditJobOpening(final String titleOrFunction, final String contractType, final String mode,
            final String address, final String jobDescription, final String numberOfVacancies,
            final JobOpening jobOpening) {

        if (!jobOpening.titleOrFunction().toString().equals(titleOrFunction)) {
            jobOpening.editTitleOrFunction(TitleOrFunction.valueOf(titleOrFunction));
        }
        if (!jobOpening.contractType().toString().equals(contractType)) {
            jobOpening.editContractType(ContractType.valueOf(contractType));
        }
        if (!jobOpening.mode().toString().equals(mode)) {
            jobOpening.editMode(Mode.valueOf(mode));
        }
        if (!jobOpening.address().toString().equals(address)) {
            jobOpening.editAddress(Address.valueOf(address));
        }
        if (!jobOpening.jobDescription().toString().equals(jobDescription)) {
            jobOpening.editJobDescription(JobDescription.valueOf(jobDescription));
        }
        if (!jobOpening.numberOfVacancies().toString().equals(numberOfVacancies)) {
            jobOpening.editNumberOfVacancies(NumberOfVacancies.valueOf(numberOfVacancies));
        }
        return jobOpeningRepository.save(jobOpening);
    }

    public JobOpeningInterview editJobOpeningInterview(final JobOpeningInterview jobOpeningInterview,
            final QuestionImporterPlugin plugin) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER, BaseRoles.POWERUSER);
        return doEditJobOpeningInterview(jobOpeningInterview, plugin);
    }

    private JobOpeningInterview doEditJobOpeningInterview(final JobOpeningInterview jobOpeningInterview,
            final QuestionImporterPlugin plugin) {
        jobOpeningInterview.editPlugin(plugin);
        return jobOpeningInterviewRepository.save(jobOpeningInterview);
    }

    public JobOpeningRequirement editJobOpeningRequirement(final JobOpeningRequirement jobOpeningRequirement,
            final QuestionImporterPlugin plugin) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER, BaseRoles.POWERUSER);
        return doEditJobOpeningRequirement(jobOpeningRequirement, plugin);
    }

    private JobOpeningRequirement doEditJobOpeningRequirement(final JobOpeningRequirement jobOpeningRequirement,
            final QuestionImporterPlugin plugin) {
        jobOpeningRequirement.editPlugin(plugin);
        return jobOpeningRequirementRepository.save(jobOpeningRequirement);
    }

    public RecruitmentProcess editJobOpeningRecruitmentProcess(
            final RecruitmentProcess jobOpeningRecruitmentProcess, final String applicationInitialDate,
            final String applicationFinalDate, final String screeningInitialDate,
            final String screeningFinalDate, final String interviewInitialDate,
            final String interviewFinalDate, final String analysisInitialDate,
            final String analysisFinalDate, final String resultInitialDate, final String resultFinalDate) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER, BaseRoles.POWERUSER);
        if (applicationInitialDate != jobOpeningRecruitmentProcess.applicationPhase().initialDate().toString())
            jobOpeningRecruitmentProcess.applicationPhase().changeInitialDate(applicationInitialDate);
        if (applicationFinalDate != jobOpeningRecruitmentProcess.applicationPhase().finalDate().toString())
            jobOpeningRecruitmentProcess.applicationPhase().changeFinalDate(applicationFinalDate);
        if (screeningInitialDate != jobOpeningRecruitmentProcess.screeningPhase().initialDate().toString())
            jobOpeningRecruitmentProcess.screeningPhase().changeInitialDate(screeningInitialDate);
        if (screeningFinalDate != jobOpeningRecruitmentProcess.screeningPhase().finalDate().toString())
            jobOpeningRecruitmentProcess.screeningPhase().changeFinalDate(screeningFinalDate);
        if (interviewInitialDate != null && interviewInitialDate != jobOpeningRecruitmentProcess
                .interviewPhase().initialDate().toString())
            jobOpeningRecruitmentProcess.interviewPhase().changeInitialDate(interviewInitialDate);
        if (interviewFinalDate != null && interviewFinalDate != jobOpeningRecruitmentProcess.interviewPhase()
                .finalDate().toString())
            jobOpeningRecruitmentProcess.interviewPhase().changeFinalDate(interviewFinalDate);
        if (analysisInitialDate != jobOpeningRecruitmentProcess.analysisPhase().initialDate().toString())
            jobOpeningRecruitmentProcess.analysisPhase().changeInitialDate(analysisInitialDate);
        if (analysisFinalDate != jobOpeningRecruitmentProcess.analysisPhase().finalDate().toString())
            jobOpeningRecruitmentProcess.analysisPhase().changeFinalDate(analysisFinalDate);
        if (resultInitialDate != jobOpeningRecruitmentProcess.resultPhase().initialDate().toString())
            jobOpeningRecruitmentProcess.resultPhase().changeInitialDate(resultInitialDate);
        if (resultFinalDate != jobOpeningRecruitmentProcess.resultPhase().finalDate().toString())
            jobOpeningRecruitmentProcess.resultPhase().changeFinalDate(resultFinalDate);
        return doEditJobOpeningRecruitmentProcess(jobOpeningRecruitmentProcess);
    }

    private RecruitmentProcess doEditJobOpeningRecruitmentProcess(
            final RecruitmentProcess jobOpeningRecruitmentProcess) {
        return recruitmentProcessRepository.save(jobOpeningRecruitmentProcess);
    }

    public Optional<JobOpeningInterview> interviewModel(final JobOpening jobOpening) {
        return jobOpeningInterviewRepository.findJobOpeningInterviewsByJobOpening(jobOpening);
    }

    public Optional<JobOpeningRequirement> requirementModel(final JobOpening jobOpening) {
        return jobOpeningRequirementRepository.findJobOpeningRequirementsByJobOpening(jobOpening);
    }

    public Optional<RecruitmentProcess> recruitmentProcess(final JobOpening jobOpening) {
        return recruitmentProcessRepository.findByJobOpening(jobOpening);
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

}
