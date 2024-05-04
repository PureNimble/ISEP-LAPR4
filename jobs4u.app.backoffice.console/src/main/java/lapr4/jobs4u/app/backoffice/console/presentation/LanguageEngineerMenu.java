package lapr4.jobs4u.app.backoffice.console.presentation;

import eapli.framework.actions.Actions;
import eapli.framework.actions.menu.Menu;
import lapr4.jobs4u.app.backoffice.console.presentation.authz.action.CreatePluginsAction;
import lapr4.jobs4u.app.backoffice.console.presentation.authz.action.ExportRequirementAction;

public class LanguageEngineerMenu extends Menu {

    private static final int ADD_PLUGINS = 1;
    private static final int GENERATE_REQUIREMENT = 2;
    private static final int EXIT_OPTION = 0;
    private static final String RETURN_LABEL = "Return ";

    public LanguageEngineerMenu() {
        super("Plugins >");

        addItem(ADD_PLUGINS, "Criar Plugin", new CreatePluginsAction());
        addItem(GENERATE_REQUIREMENT, "Generate Requirement Template", new ExportRequirementAction());
        addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);
    }
}