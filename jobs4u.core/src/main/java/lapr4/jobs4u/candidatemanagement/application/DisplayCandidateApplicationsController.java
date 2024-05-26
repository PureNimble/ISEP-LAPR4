package lapr4.jobs4u.candidatemanagement.application;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.io.util.Files;
import lapr4.jobs4u.applicationmanagement.domain.Application;
import lapr4.jobs4u.applicationmanagement.domain.File;
import lapr4.jobs4u.applicationmanagement.dto.ApplicationDTO;
import lapr4.jobs4u.applicationmanagement.repositories.ApplicationRepository;
import lapr4.jobs4u.candidatemanagement.domain.Candidate;
import lapr4.jobs4u.usermanagement.domain.BaseRoles;

@UseCaseController
public class DisplayCandidateApplicationsController {

    private final DisplayCandidateApplicationsService applicationService;
    private final AuthorizationService authz;

    public DisplayCandidateApplicationsController(ApplicationRepository applicationRepository,
            AuthorizationService authz) {
        this.applicationService = new DisplayCandidateApplicationsService(applicationRepository);
        this.authz = authz;
    }

    public Iterable<ApplicationDTO> findApplicationsFromCandidate(final Candidate candidate) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER, BaseRoles.POWERUSER);
        return applicationService.findApplicationsFromCandidate(candidate);
    }

    public Application selectedApplication(final ApplicationDTO applicationDTO) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER, BaseRoles.POWERUSER);
        return applicationService.selectedApplication(applicationDTO);
    }

    public Iterable<Application> printFrequentlyUsedWords(Iterable<Application> app) {

        List<Thread> threads = new ArrayList<>();

        for (Application a : app) {
            Thread t = new Thread(a);
            threads.add(t);
            t.start();
        }
        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return app;

    }
}
