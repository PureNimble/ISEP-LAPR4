package lapr4.jobs4u.applicationmanagement.domain;

import eapli.framework.domain.model.DomainFactory;
import lapr4.jobs4u.recruitmentprocessmanagement.domain.Date;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ApplicationBuilder implements DomainFactory<Application> {

    private static final Logger LOGGER = LogManager.getLogger(ApplicationBuilder.class);
    private ApplicationNumber applicationNumber;
    private Date date;
    private List<File> file;

    public ApplicationBuilder with(final String applicationNumber, final String date,
            final List<File> file) {
        this.withApplicationNumber(applicationNumber);
        this.withDate(date);
        this.file = file;

        return this;
    }

    public ApplicationBuilder withApplicationNumber(final String applicationNumber) {
        this.applicationNumber = ApplicationNumber.valueOf(applicationNumber);
        return this;
    }

    public ApplicationBuilder withDate(final String date) {
        this.date = Date.valueOf(date);
        return this;
    }

    @Override
    public Application build() {
        final Application application = new Application(this.date, this.applicationNumber, this.file);
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Registering new application [{}] {} {} {}", application, this.date,
                    this.applicationNumber, this.file);
        }
        return application;
    }
}
