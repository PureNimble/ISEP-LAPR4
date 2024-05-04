package lapr4.jobs4u.jobopeningmanagement.application;

import lapr4.jobs4u.jobopeningmanagement.domain.JobOpeningInterview;
import lapr4.jobs4u.jobopeningmanagement.repositories.JobOpeningInterviewRepository;

public class SelectInterviewController {

    private final JobOpeningInterviewRepository repo;

    public SelectInterviewController(final JobOpeningInterviewRepository repo) {
        this.repo = repo;
    }

    public void addInterviewPluginToJobOpening(final JobOpeningInterview interview) {

        repo.save(interview);
    }
}
