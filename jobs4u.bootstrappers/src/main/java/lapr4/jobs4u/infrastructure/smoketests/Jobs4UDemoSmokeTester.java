package lapr4.jobs4u.infrastructure.smoketests;

import eapli.framework.actions.Action;
import eapli.framework.actions.ChainedAction;

/**
 * execute simple smoke tests on the application layer. we are assuming that the
 * bootstrappers mainly test the "register" use cases and some of the "finders"
 * to support those "register", so this class will focus mainly on executing the
 * other application methods
 *
 * @author 2DI2
 */
@SuppressWarnings("squid:S1126")
public class Jobs4UDemoSmokeTester implements Action {

    @Override
    public boolean execute() {
        return ChainedAction.first(new QuestionImportThruPluginSmokeTester()).then(new QuestionExportThruSmokeTester())
                .execute();
    }
}
