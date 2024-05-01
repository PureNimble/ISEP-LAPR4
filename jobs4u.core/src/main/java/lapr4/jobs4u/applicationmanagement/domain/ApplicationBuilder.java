package lapr4.jobs4u.applicationmanagement.domain;

import eapli.framework.domain.model.DomainFactory;
import lapr4.jobs4u.candidatemanagement.domain.Candidate;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
import lapr4.jobs4u.recruitmentprocessmanagement.domain.Date;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ApplicationBuilder implements DomainFactory<Application> {

    private static final Logger LOGGER = LogManager.getLogger(ApplicationBuilder.class);
    private ApplicationNumber applicationNumber;
    private Date date;
    private Result result;
    private List<File> file;
    private JobOpening jobOpening;
    private Candidate candidate;

    public ApplicationBuilder with(final String applicationNumber, final String date,
            final List<File> file, final JobOpening jobOpening, final Candidate candidate) {
        this.withApplicationNumber(applicationNumber);
        this.withDate(date);
        this.withFile(file);
        this.withJobOpening(jobOpening);
        this.withCandidate(candidate);
        this.withResult();

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

    public ApplicationBuilder withFile(final List<File> file) {
        this.file = file;
        return this;
    }

    public ApplicationBuilder withJobOpening(final JobOpening jobOpening) {
        this.jobOpening = jobOpening;
        return this;
    }

    public ApplicationBuilder withCandidate(final Candidate candidate) {
        this.candidate = candidate;
        return this;
    }

    public ApplicationBuilder withResult() {
        this.result = Result.valueOf();
        return this;
    }

    @Override
    public Application build() {
        final Application application = new Application(this.date, this.applicationNumber, this.file, this.jobOpening,
                this.candidate, this.result);
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Registering new application [{}] {} {} {} {} {} {}", application, this.date,
                    this.applicationNumber, this.file, this.jobOpening, this.candidate, this.result);
        }
        return application;
    }
}
