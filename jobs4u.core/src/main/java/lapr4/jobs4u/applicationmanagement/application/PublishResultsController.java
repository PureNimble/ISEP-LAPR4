package lapr4.jobs4u.applicationmanagement.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import eapli.framework.application.UseCaseController;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import jakarta.mail.MessagingException;
import lapr4.jobs4u.applicationmanagement.domain.Application;
import lapr4.jobs4u.applicationmanagement.domain.File;
import lapr4.jobs4u.applicationmanagement.domain.Outcome;
import lapr4.jobs4u.applicationmanagement.domain.OutcomeValue;
import lapr4.jobs4u.applicationmanagement.repositories.ApplicationRepository;
import lapr4.jobs4u.integration.email.application.EmailService;
import lapr4.jobs4u.integration.email.config.MailConfig;
import lapr4.jobs4u.interviewmanagement.domain.Interview;
import lapr4.jobs4u.interviewmanagement.repositories.InterviewRepository;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
import lapr4.jobs4u.rankmanagement.domain.Rank;
import lapr4.jobs4u.rankmanagement.repositories.RankRepository;
import lapr4.jobs4u.requirementmanagement.domain.Requirement;
import lapr4.jobs4u.requirementmanagement.repositories.RequirementRepository;
import lapr4.jobs4u.usermanagement.domain.BaseRoles;

/**
 * @author 2DI2
 */
@UseCaseController
public class PublishResultsController {

    private final ApplicationRepository applicationRepository;
    private final TransactionalContext txCtx;
    private final RankRepository rankRepository;
    private final InterviewRepository interviewRepository;
    private final RequirementRepository requirementRepository;
    private final EmailService emailService;
    private final AuthorizationService authz;

    public PublishResultsController(final ApplicationRepository applicationRepository,
            final RankRepository rankRepository,
            final InterviewRepository interviewRepository,
            final RequirementRepository requirementRepository,
            final TransactionalContext txCtx,
            final AuthorizationService authz) {
        this.applicationRepository = applicationRepository;
        this.rankRepository = rankRepository;
        this.interviewRepository = interviewRepository;
        this.requirementRepository = requirementRepository;
        this.txCtx = txCtx;
        this.emailService = new EmailService(MailConfig.getInstance().javaMailSender());
        this.authz = authz;
    }

    public void publishResults(final JobOpening jobOpening) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER, BaseRoles.POWERUSER);

        final Iterable<Application> applications = applicationRepository.filterByJobOpening(jobOpening);
        final Iterable<Rank> topNRank = rankRepository.findTopNApplicationsByJobOpening(jobOpening);
        final List<Application> processedApplications = saveResults(applications, topNRank);
        doPublishResults(processedApplications);
    }

    private List<Application> saveResults(final Iterable<Application> applications, final Iterable<Rank> topNRank) {
        List<Application> processedApplications = new ArrayList<>();
        try {
            txCtx.beginTransaction();
            for (final Application application : applications) {
                for (final Rank rank : topNRank) {
                    if (application.equals(rank.application())) {
                        application.addResult(OutcomeValue.APPROVED.toString());
                        break;
                    }
                }

                if (application.result().outcome() == Outcome.valueOf(OutcomeValue.PENDING.toString()))
                    application.addResult(OutcomeValue.REJECTED.toString());

                this.applicationRepository.save(application);
                processedApplications.add(application);
            }
            txCtx.commit();
        } catch (final Exception e) {
            txCtx.rollback();
            throw new IllegalStateException("Error publishing results", e);
        }
        return processedApplications;
    }

    private void doPublishResults(final List<Application> applications) {
        for (final Application application : applications) {
            final String result = application.result().toString();
            final String candidateName = application.candidate().name().toString();
            final JobOpening jobOpening = application.jobOpening();
            final String subBody = "your application for the position '" + jobOpening.titleOrFunction().toString()
                    + "' at '" + jobOpening.customer().companyName().toString() + "' has been";
            final String body;
            if (result == "APPROVED") {
                body = "Hello Mr/Mrs " + candidateName
                        + ", \n\nCongratulations! " + subBody
                        + " approved. Please check the attachments for further information and details. \n\nBest regards, \nJobs4U Team";
            } else {
                body = "Hello Mr/Mrs " + candidateName
                        + ", \n\nWe regret to inform you that " + subBody
                        + " rejected. Please check the attachments for further information and details. \n\nBest regards, \nJobs4U Team";
            }
            try {
                final Optional<Requirement> requirement = requirementRepository.findRequirement(application);
                final Optional<Interview> interview = interviewRepository.findInterviewByApplication(application);

                List<String> attachments = new ArrayList<>();
                for (final File filePath : application.getFiles())
                    attachments.add(filePath.toString());

                attachments.add(requirement.get().file().toString());

                if (interview.isPresent()) {
                    attachments.add(interview.get().file().toString());
                }

                System.out.println("Sending email to " + application.candidate().emailAddress().toString()
                        + " with result " + result + " and attachments " + attachments.toString());

                emailService.sendEmailWithAttachment(application.candidate().emailAddress().toString(),
                        "Application Result", body, attachments.toArray(new String[0]));
            } catch (final MessagingException e) {
                e.printStackTrace();
            }
        }
    }
}
