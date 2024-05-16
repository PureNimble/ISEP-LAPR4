package lapr4.jobs4u.app.backoffice.console.presentation;

import eapli.framework.actions.Actions;
import eapli.framework.actions.menu.Menu;
import lapr4.jobs4u.app.backoffice.console.presentation.authz.action.ExportInterviewAction;
import lapr4.jobs4u.app.backoffice.console.presentation.authz.action.ListApplicationsAction;
import lapr4.jobs4u.app.backoffice.console.presentation.authz.action.ListCandidatesDataAction;
import lapr4.jobs4u.app.backoffice.console.presentation.authz.action.ListJobOpeningsAction;
import lapr4.jobs4u.app.backoffice.console.presentation.authz.action.OpenOrClosePhaseAction;
import lapr4.jobs4u.app.backoffice.console.presentation.authz.action.RegisterCustomerAction;
import lapr4.jobs4u.app.backoffice.console.presentation.authz.action.RegisterJobOpeningAction;
import lapr4.jobs4u.app.backoffice.console.presentation.authz.action.SelectInterviewAction;
import lapr4.jobs4u.app.backoffice.console.presentation.authz.action.SelectRequirementAction;
import lapr4.jobs4u.app.backoffice.console.presentation.authz.action.SetUpRecruitmentProcessAction;

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
    private static final int EXIT_OPTION = 0;
    private static final String RETURN_LABEL = "Return ";

    public CustomerManagerMenu() {
        super("Customer >");

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
        addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);
    }
}
