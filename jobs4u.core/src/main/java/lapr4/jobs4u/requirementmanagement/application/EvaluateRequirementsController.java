package lapr4.jobs4u.requirementmanagement.application;

import java.util.List;
import java.util.Optional;

import org.springframework.data.util.Pair;
import org.springframework.mail.javamail.JavaMailSender;

import eapli.framework.application.UseCaseController;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import jakarta.mail.MessagingException;
import lapr4.jobs4u.applicationmanagement.repositories.ApplicationRepository;
import lapr4.jobs4u.candidatemanagement.domain.Candidate;
import lapr4.jobs4u.emailmanagement.application.EmailService;
import lapr4.jobs4u.emailmanagement.config.MailConfig;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
import lapr4.jobs4u.jobopeningmanagement.repositories.JobOpeningRequirementRepository;
import lapr4.jobs4u.questionmanagement.repositories.RequirementsQuestionRepository;
import lapr4.jobs4u.recruitmentprocessmanagement.repositories.RecruitmentProcessRepository;
import lapr4.jobs4u.requirementmanagement.repositories.RequirementRepository;
import lapr4.jobs4u.usermanagement.domain.BaseRoles;

/**
 * @author 2DI2
 */
@UseCaseController
public class EvaluateRequirementsController {

    private final RecruitmentProcessRepository recruitmentProcessRepository;
    private final EvaluateRequirementsService evaluateRequirementsService;
    private final EmailService emailService;
    private final AuthorizationService authz;

    public EvaluateRequirementsController(final RequirementsQuestionRepository RequirementsQuestionRepository,
            final RecruitmentProcessRepository recruitmentProcessRepository,
            final JobOpeningRequirementRepository jobOpeningRequirementRepository,
            final RequirementRepository RequirementRepository,
            final ApplicationRepository applicationRepository,
            final TransactionalContext ctx,
            final AuthorizationService authz) {
        this.recruitmentProcessRepository = recruitmentProcessRepository;
        this.evaluateRequirementsService = new EvaluateRequirementsService(RequirementRepository, jobOpeningRequirementRepository, RequirementsQuestionRepository, applicationRepository, ctx);
        this.emailService = new EmailService(MailConfig.getInstance().javaMailSender());
        this.authz = authz;
    }

    public void evaluateRequirement(final JobOpening jobOpening) throws Exception {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER, BaseRoles.POWERUSER);
        final List<Pair<Candidate, Pair<String, String>>> emailsInfo = evaluateRequirementsService.evaluateRequirement(jobOpening);
        for (Pair<Candidate, Pair<String, String>> emailInfo : emailsInfo) {
            final Candidate candidade = emailInfo.getFirst();
            final String result = emailInfo.getSecond().getFirst();
            final String pathToAttachment = emailInfo.getSecond().getSecond();
            sendEmail(candidade, result, pathToAttachment);
        }
    }

    public String currentPhase(final JobOpening jobOpening) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER, BaseRoles.POWERUSER);
        Optional<String> phaseOpt = recruitmentProcessRepository.currentPhase(jobOpening);
        if (!phaseOpt.isPresent()) {
            return null;
        }
        String phase = phaseOpt.get();
        return phase;
    }

    private void sendEmail(final Candidate candidate, final String result, final String pathToAttachment) throws MessagingException {
        final String body;
        final String candidateName = candidate.name().toString();
        if (result == "APPROVED") {
            body = "Hello Mr/Mrs " + candidateName + ", \n\nCongratulations! Your result for the requirements specification has been approved. Please check the attachment for further information and details. \n\nBest regards, \nJobs4U Team";
        }
        else {
            body = "Hello Mr/Mrs " + candidateName + ", \n\nWe regret to inform you that your result for the requirements specification has been rejected. Please check the attachment for further information and details. \n\nBest regards, \nJobs4U Team";
        }
        emailService.sendEmailWithAttachment("vscosousa@gmail.com", "Evaluation Result", body, pathToAttachment);
    }

}
