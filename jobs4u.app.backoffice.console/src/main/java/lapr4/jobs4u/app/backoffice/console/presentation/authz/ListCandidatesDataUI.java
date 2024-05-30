package lapr4.jobs4u.app.backoffice.console.presentation.authz;

import java.util.ArrayList;
import java.util.List;

import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;
import lapr4.jobs4u.app.backoffice.console.presentation.authz.printer.CandidatePrinter;
import lapr4.jobs4u.applicationmanagement.domain.Application;
import lapr4.jobs4u.applicationmanagement.dto.ApplicationDTO;
import lapr4.jobs4u.candidatemanagement.application.DisplayCandidateApplicationsController;
import lapr4.jobs4u.candidatemanagement.application.ListCandidatesDataController;
import lapr4.jobs4u.candidatemanagement.domain.Candidate;
import lapr4.jobs4u.candidatemanagement.dto.CandidateDTO;
import lapr4.jobs4u.infrastructure.persistence.PersistenceContext;

/**
 * @author 2DI2
 */
public class ListCandidatesDataUI extends AbstractUI {

    final private ListCandidatesDataController listCandidatesDataController = new ListCandidatesDataController(
            PersistenceContext.repositories().candidates(), AuthzRegistry.authorizationService());
    final private DisplayCandidateApplicationsController displayCandidateApplicationsController = new DisplayCandidateApplicationsController(
            PersistenceContext.repositories().applications(), AuthzRegistry.authorizationService());

    @Override
    protected boolean doShow() {
        final Iterable<CandidateDTO> candidateDTOS = this.listCandidatesDataController.allCandidatesSortedAsc();

        CandidateDTO selectedCandidateDTO;
        while (true) {
            final SelectWidget<CandidateDTO> selector = new SelectWidget<>("Candidates:", candidateDTOS,
                    new CandidatePrinter());
            selector.show();
            selectedCandidateDTO = selector.selectedElement();
            if (selectedCandidateDTO == null) {
                return false;
            }
            printCandidateData(selectedCandidateDTO);
            final Candidate selectedCandidate = listCandidatesDataController.selectedCandidate(selectedCandidateDTO);
            final Iterable<ApplicationDTO> applicationDTOS = this.displayCandidateApplicationsController
                    .findApplicationsFromCandidate(selectedCandidate);
            printApplications(applicationDTOS);
        }
    }

    private void printCandidateData(final CandidateDTO candidate) {
        System.out.printf("\nCandidate Details:\n");
        System.out.printf("Name: %s\n", candidate.getName());
        System.out.printf("Email: %s\n", candidate.getEmail());
        System.out.printf("Phone Number: %s\n", candidate.getPhoneNumber());
    }

    private void printApplications(final Iterable<ApplicationDTO> app) {
        if (!app.iterator().hasNext())
            return;
        List<Application> applications = new ArrayList<>();
        for (ApplicationDTO a : app)
            applications.add(displayCandidateApplicationsController.selectedApplication(a));

        applications = (List<Application>) displayCandidateApplicationsController
                .printFrequentlyUsedWords(applications);

        for (Application a : applications) {
            System.out.println(a.toString());
        }

    }

    @Override
    public String headline() {
        return "Show Candidate Data";
    }
}
