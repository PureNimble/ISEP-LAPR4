package lapr4.jobs4u.app.backoffice.console.presentation;

import eapli.framework.actions.Actions;
import eapli.framework.actions.menu.Menu;
import lapr4.jobs4u.app.backoffice.console.presentation.authz.action.*;

/**
 * @author 2DI2
 */
public class CustomerManagerMenu extends Menu {

    private static final int REGISTER_CUSTOMER = 1;
    private static final int REGISTER_JOB_OPENING = 2;
    private static final int LIST_JOB_OPENINGS = 3;
    private static final int SETUP_RECRUITMENT_PROCESS = 4;
    private static final int LIST_APPLICATIONS = 5;
    private static final int DISPLAY_CANDIDATE_DATA = 6;
    private static final int GENERATE_INTERVIEW = 7;
    private static final int SELECT_INTERVIEW = 8;
    private static final int SELECT_REQUIREMENT = 9;
    private static final int OPEN_OR_CLOSE_PHASE = 10;
    private static final int EDIT_JOB_OPENING = 11;
    private static final int RECORD_INTERVIEW = 12;
    private static final int UPLOAD_INTERVIEW = 13;
    private static final int EVALUATE_INTERVIEW = 14;
    private static final int EVALUATE_REQUIREMENT = 15;
    private static final int LIST_CANDIDATES_BY_INTERVIEW_POINTS = 16;
    private static final int REGISTER_RANK = 17;
    private static final int DISPLAY_APPLICATION_DATA = 18;
    private static final int PUBLISH_RESULTS = 19;
    private static final int EXIT_OPTION = 0;
    private static final String RETURN_LABEL = "Return ";

    public CustomerManagerMenu() {
        super("Customer Manager Menu >");

        addItem(REGISTER_CUSTOMER, "Register Customer", new RegisterCustomerAction());
        addItem(REGISTER_JOB_OPENING, "Register Job Opening", new RegisterJobOpeningAction());
        addItem(LIST_JOB_OPENINGS, "List Job Openings", new ListJobOpeningsAction());
        addItem(SETUP_RECRUITMENT_PROCESS, "SetUp Recruitment Process", new SetUpRecruitmentProcessAction());
        addItem(LIST_APPLICATIONS, "List Applications for a Job Opening", new ListApplicationsAction());
        addItem(DISPLAY_CANDIDATE_DATA, "Display the personal data of a candidate", new ListCandidatesDataAction());
        addItem(GENERATE_INTERVIEW, "Generate Interview Template", new ExportInterviewAction());
        addItem(SELECT_INTERVIEW, "Select Interview", new SelectInterviewAction());
        addItem(SELECT_REQUIREMENT, "Select Requirement", new SelectRequirementAction());
        addItem(OPEN_OR_CLOSE_PHASE, "Open or Close Phase", new OpenOrClosePhaseAction());
        addItem(EDIT_JOB_OPENING, "Edit Job Opening", new EditJobOpeningAction());
        addItem(RECORD_INTERVIEW, "Record Interview", new RecordInterviewAction());
        addItem(UPLOAD_INTERVIEW, "Upload Interview", new UploadInterviewAction());
        addItem(EVALUATE_INTERVIEW, "Evaluate Interview", new EvaluateInterviewAction());
        addItem(EVALUATE_REQUIREMENT, "Evaluate Requirement", new EvaluateRequirementAction());
        addItem(LIST_CANDIDATES_BY_INTERVIEW_POINTS, "List Candidates by Interview Points", new ListCandidatesByInterviewPointsAction());
        addItem(REGISTER_RANK, "Rank Candidates", new RegisterRankAction());
        addItem(DISPLAY_APPLICATION_DATA, "Display Application Data", new DisplayApplicationDataAction());
        addItem(PUBLISH_RESULTS, "Launch Results", new PublishResultsAction());
        addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);
    }
}
