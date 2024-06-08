package lapr4.jobs4u.app.backoffice.console.presentation.authz;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;
import lapr4.jobs4u.app.backoffice.console.presentation.authz.printer.JobOpeningPrinter;
import lapr4.jobs4u.app.common.console.presentation.utils.Utils;
import lapr4.jobs4u.infrastructure.persistence.PersistenceContext;
import lapr4.jobs4u.interviewmanagement.application.ListCandidatesByInterviewPointsController;
import lapr4.jobs4u.interviewmanagement.dto.InterviewDTO;
import lapr4.jobs4u.jobopeningmanagement.application.ListJobOpeningsController;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
import lapr4.jobs4u.jobopeningmanagement.dto.JobOpeningDTO;

/**
 * @author 2DI2
 */
public class ListCandidatesByInterviewPointsUI extends AbstractUI {

    private final ListCandidatesByInterviewPointsController listCandidatesByInterviewPointsController = new ListCandidatesByInterviewPointsController(
            PersistenceContext.repositories().interviews(), AuthzRegistry.authorizationService());
    private final ListJobOpeningsController listJobpeningsController = new ListJobOpeningsController(
            PersistenceContext.repositories().jobOpenings(), AuthzRegistry.authorizationService());

    private JobOpening theJobOpening;

    @Override
    public String headline() {
        return "List Candidates by Interview Points";
    }

    protected String emptyMessage() {
        return "No data.";
    }

    @Override
    protected boolean doShow() {

        final Iterable<JobOpeningDTO> jobOpenings = this.listJobpeningsController.filterWithEvaluatedInterviews();
        final SelectWidget<JobOpeningDTO> selector = new SelectWidget<>("Job Openings:", jobOpenings,
                new JobOpeningPrinter());
        selector.show();
        final JobOpeningDTO theJobOpeningDTO = selector.selectedElement();
        if (theJobOpeningDTO == null) {
            return false;
        }

        this.theJobOpening = listJobpeningsController.selectedJobOpening(theJobOpeningDTO);

        Iterable<InterviewDTO> elems = this.elements(theJobOpening, false);

        if (showList(elems)) {
            while (Utils.confirm("\nDo you want to reorder the list?")) {
                final List<String> options = Arrays.asList("Order by Asc", "Order by Desc");
                final int option = Utils.showAndSelectIndex(options, "\nWhich order do you wish to apply?");

                switch (option) {
                    case 0:
                        elems = this.sortedCandidatesByInterviewPointsForJobOpening(theJobOpening, false);
                        break;
                    case 1:
                        elems = this.sortedCandidatesByInterviewPointsForJobOpening(theJobOpening, true);
                        break;
                    default:
                        System.out.println("Invalid ordering option.");
                        return true;
                }
                showList(elems);
            }
        }

        return true;
    }

    protected Iterable<InterviewDTO> elements(final JobOpening theJobOpening, final boolean ascending) {
        return sortedCandidatesByInterviewPointsForJobOpening(theJobOpening, false);
    }

    protected boolean showList(final Iterable<InterviewDTO> elems) {
        if (!elems.iterator().hasNext()) {
            PrintStream var10000 = System.out;
            String var10001 = this.emptyMessage();
            var10000.println(var10001);
            return false;
        }
        System.out.println(elementName());
        System.out.println(listHeader());
        int i = 1;
        for (final InterviewDTO elem : elems) {
            System.out
                    .println(String.format("%d  %-30s%-30s%-5s", i, elem.getApplicationCode(), elem.getCandidateEmail(),
                            elem.getGrade() == null ? "N/A" : elem.getGrade()));
            i++;
        }
        return true;
    }

    protected Iterable<InterviewDTO> sortedCandidatesByInterviewPointsForJobOpening(final JobOpening jobOpening,
            final boolean ascending) {
        return listCandidatesByInterviewPointsController.allCandidatesSortedByInterviewPointsForJobOpening(jobOpening,
                ascending);
    }

    protected String elementName() {
        return "Candidates";
    }

    protected String listHeader() {
        return String.format("#  %-30s%-30s%-5s", "APP. CODE", "CANDIDATE EMAIL", "INTERVIEW POINTS");
    }
}