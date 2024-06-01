package lapr4.jobs4u.emailmanagement.config;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import lapr4.jobs4u.AppSettings;

/**
 * @author 2DI2
 */
public class MailConfig {

    private static MailConfig instance;
    private AppSettings appSettings;

    private MailConfig() {
        this.appSettings = new AppSettings();
    }

    public static MailConfig getInstance() {
        if (instance == null) {
            instance = new MailConfig();
        }
        return instance;
    }

    public JavaMailSender javaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(appSettings.emailHost());
        mailSender.setPort(appSettings.emailPort());
        mailSender.getJavaMailProperties().put("mail.smtp.starttls.enable", appSettings.isEmailStarttlsEnabled());
        return mailSender;
    }
}
