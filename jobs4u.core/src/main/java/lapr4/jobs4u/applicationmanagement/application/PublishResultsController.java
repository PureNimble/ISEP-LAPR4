package lapr4.jobs4u.applicationmanagement.application;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
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

    private static final String EVALUATED_TAG = "Evaluated";
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
        doPublishResults(processedApplications, jobOpening);
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
            throw new IllegalStateException("Error publishing results" + e.getMessage());
        }
        return processedApplications;
    }

    private void doPublishResults(final List<Application> applications, final JobOpening jobOpening) {

        List<Application> approvedApplications = new ArrayList<>();
        final String subBody = "your application for the position '" + jobOpening.titleOrFunction().toString()
                + "' at '" + jobOpening.customer().companyName().toString() + "' has been";
        for (final Application application : applications) {
            final String result = application.result().outcome().toString();
            final String candidateName = application.candidate().name().toString();
            final String body;
            if (result == OutcomeValue.APPROVED.toString()) {
                body = "Hello Mr/Mrs " + candidateName
                        + ", \n\nCongratulations! " + subBody
                        + " approved. Please check the attachments for further information and details. \n\nBest regards, \nJobs4U Team";
                approvedApplications.add(application);
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

                final Path requirementPath = new java.io.File(requirement.get().file().toString()).toPath();
                final Path parentPath = requirementPath.getParent();
                final String fileName = requirementPath.getFileName().toString();
                final String newFileName = EVALUATED_TAG + fileName;
                final Path newPath = parentPath.resolve(newFileName);
                final String requirementFile = newPath.toString().replace("input", "output");
                attachments.add(requirementFile);

                if (interview.isPresent() && interview.get().file() != null) {
                    final Path interviewPath = new java.io.File(interview.get().file().toString()).toPath();
                    final Path interviewFileName = interviewPath.getParent();
                    final String interviewFileNameStr = interviewPath.getFileName().toString();
                    final String newInterviewFileName = EVALUATED_TAG + interviewFileNameStr;
                    final Path newInterviewPath = interviewFileName.resolve(newInterviewFileName);
                    final String interviewFilePath = newInterviewPath.toString().replace("input", "output");
                    attachments.add(interviewFilePath);
                }

                emailService.sendEmailWithAttachment(application.candidate().emailAddress().toString(),
                        "Application Result", body, attachments.toArray(new String[0]));
            } catch (final MessagingException e) {
                throw new IllegalStateException("Error sending emails" + e.getMessage());
            }
        }

        try {
            final java.io.File tempFile = java.io.File.createTempFile(jobOpening.jobReference().toString(), ".txt");
            final FileWriter writer = new FileWriter(tempFile);
            writer.write(
                    String.format("Approved applications for the job opening:\n#  %-30s%-30s%-20s", "Name", "Email",
                            "Phone Number"));

            int i = 1;
            for (final Application application : approvedApplications) {
                writer.write(String.format("\n%d  %-30s%-30s%-20s", i, application.candidate().name().toString(),
                        application.candidate().emailAddress().toString(),
                        application.candidate().phoneNumber().toString()));
                i++;
            }
            writer.close();
            emailService.sendEmailWithAttachment(jobOpening.customer().email().toString(), "Job Opening Results",
                    "Hello Mr/Mrs " + jobOpening.customer().companyName().toString()
                            + ",\n\n We are pleased to inform you that the positions for the job opening '"
                            + jobOpening.jobReference().toString() + "' you listed with us "
                            + "have been successfully filled. We appreciate the opportunity to assist you in finding the right "
                            + "candidates for your needs.\n Attatched bellow is a list of the selected candidates,\n"
                            + "Thank you for choosing our services. We look forward to serving you again "
                            + "in the future.\n\nBest regards,\nJobs4U Team",
                    tempFile.getAbsolutePath());

            tempFile.delete();
        } catch (final IOException | MessagingException e) {
            throw new IllegalStateException("Error sending emails: " + e.getMessage());
        }
    }
}
