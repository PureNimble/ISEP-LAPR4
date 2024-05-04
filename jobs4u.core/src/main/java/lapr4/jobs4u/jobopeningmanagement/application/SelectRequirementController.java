package lapr4.jobs4u.jobopeningmanagement.application;

import lapr4.jobs4u.jobopeningmanagement.domain.JobOpeningRequirement;
import lapr4.jobs4u.jobopeningmanagement.repositories.JobOpeningRequirementRepository;

public class SelectRequirementController {

    private final JobOpeningRequirementRepository repo;

    public SelectRequirementController(final JobOpeningRequirementRepository repo) {
        this.repo = repo;
    }

    public void addRequirementPluginToJobOpening(final JobOpeningRequirement interview) {
        repo.save(interview);
    }
}
