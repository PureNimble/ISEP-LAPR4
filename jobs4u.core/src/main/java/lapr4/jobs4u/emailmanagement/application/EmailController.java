package lapr4.jobs4u.emailmanagement.application;

import org.springframework.mail.javamail.JavaMailSender;

import eapli.framework.application.UseCaseController;
import jakarta.mail.MessagingException;

/**
 * @author 2DI2
 */
@UseCaseController
public class EmailController {

    private final EmailService emailService;

    public EmailController(final JavaMailSender emailSender) {
        this.emailService = new EmailService(emailSender);
    }

    public void sendEmail(final String to, final String subject, final String body) {
        emailService.sendEmail(to, subject, body);
    }

    public void sendEmailWithAttachment(final String to, final String subject, final String body,
            final String pathToAttachment) throws MessagingException {
        emailService.sendEmailWithAttachment(to, subject, body, pathToAttachment);
    }
}
