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
    private ApplicationCode applicationCode;
    private Date date;
    private Result result;
    private List<File> file;
    private JobOpening jobOpening;
    private Candidate candidate;

    public ApplicationBuilder with(final String applicationCode, final Date date,
            final List<File> file, final JobOpening jobOpening, final Candidate candidate) {
        this.withApplicationCode(applicationCode);
        this.withDate(date);
        this.withFile(file);
        this.withJobOpening(jobOpening);
        this.withCandidate(candidate);
        this.withResult();

        return this;
    }

    public ApplicationBuilder withApplicationCode(final String applicationCode) {
        this.applicationCode = ApplicationCode.valueOf(applicationCode);
        return this;
    }

    public ApplicationBuilder withDate(final Date date) {
        this.date = date;
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
        final Application application = new Application(this.date, this.applicationCode, this.file, this.jobOpening,
                this.candidate, this.result);
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("Registering new application [{}] {} {} {} {} {} {}", application, this.date,
                    this.applicationCode, this.file, this.jobOpening, this.candidate, this.result);
        }
        return application;
    }
}
