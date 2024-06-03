package lapr4.jobs4u.integration.email.application;

import java.io.File;

import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import eapli.framework.validations.Preconditions;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

/**
 * @author 2DI2
 */
public class EmailService {

    private final JavaMailSender emailSender;
    private static final String EMAIL_FROM = "jobs4u@noreply.local";

    public EmailService(final JavaMailSender emailSender) {
        Preconditions.nonNull(emailSender);
        this.emailSender = emailSender;
    }

    public void sendEmail(final String to, final String subject, final String body) {

        final SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom(EMAIL_FROM);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);

        emailSender.send(message);
    }

    public void sendEmailWithAttachment(final String to, final String subject, final String body,
            final String pathToAttachment) throws MessagingException {

        final MimeMessage message = emailSender.createMimeMessage();
        final MimeMessageHelper helper = new MimeMessageHelper(message, true);

        message.setFrom(EMAIL_FROM);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(body);

        final File file = new File(pathToAttachment);

        final FileSystemResource filetoSend = new FileSystemResource(file);
        helper.addAttachment(file.getName(), filetoSend);

        emailSender.send(message);
    }
}
