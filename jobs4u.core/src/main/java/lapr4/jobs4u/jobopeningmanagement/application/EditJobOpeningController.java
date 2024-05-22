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
import lapr4.jobs4u.usermanagement.domain.BaseRoles;

@UseCaseController
public class EditJobOpeningController {

        private final JobOpeningRepository jobOpeningRepository;
        private final JobOpeningInterviewRepository jobOpeningInterviewRepository;
        private final JobOpeningRequirementRepository jobOpeningRequirementRepository;
        private final AuthorizationService authz;

        public EditJobOpeningController(final JobOpeningRepository jobOpeningRepository,
                        final JobOpeningInterviewRepository jobOpeningInterviewRepository,
                        final JobOpeningRequirementRepository jobOpeningRequirementRepository,
                        final AuthorizationService authz) {

                this.jobOpeningRepository = jobOpeningRepository;
                this.jobOpeningInterviewRepository = jobOpeningInterviewRepository;
                this.jobOpeningRequirementRepository = jobOpeningRequirementRepository;
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

        public JobOpeningInterview editJobOpeningInterview(final JobOpeningInterview jobOpeningInterview, final QuestionImporterPlugin plugin) {
                authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER, BaseRoles.POWERUSER);
                return doEditJobOpeningInterview(jobOpeningInterview, plugin);
        }

        private JobOpeningInterview doEditJobOpeningInterview(final JobOpeningInterview jobOpeningInterview, final QuestionImporterPlugin plugin) {
                jobOpeningInterview.editPlugin(plugin);
                return jobOpeningInterviewRepository.save(jobOpeningInterview);
        }

        public JobOpeningRequirement editJobOpeningRequirement(final JobOpeningRequirement jobOpeningRequirement, final QuestionImporterPlugin plugin) {
                authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER, BaseRoles.POWERUSER);
                return doEditJobOpeningRequirement(jobOpeningRequirement, plugin);
        }

        private JobOpeningRequirement doEditJobOpeningRequirement(final JobOpeningRequirement jobOpeningRequirement, final QuestionImporterPlugin plugin) {
                jobOpeningRequirement.editPlugin(plugin);
                return jobOpeningRequirementRepository.save(jobOpeningRequirement);
        }

        public Optional<JobOpeningInterview> interviewModel(final JobOpening jobOpening) {
                return jobOpeningInterviewRepository.findJobOpeningInterviewsByJobOpening(jobOpening);
        }

        public Optional<JobOpeningRequirement> requirementModel(final JobOpening jobOpening) {
                return jobOpeningRequirementRepository.findJobOpeningRequirementsByJobOpening(jobOpening);
        }
        
}
