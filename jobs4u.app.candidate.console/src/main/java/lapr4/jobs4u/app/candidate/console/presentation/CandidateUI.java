package lapr4.jobs4u.app.candidate.console.presentation;

import eapli.framework.presentation.console.AbstractUI;
import lapr4.jobs4u.app.common.ClientBackend;

/**
 * @author 2DI2
 */
@SuppressWarnings("squid:S106")
public abstract class CandidateUI extends AbstractUI {

    @Override
    public String headline() {

        final String email = ClientBackend.getInstance().credentialAuth().email();
        return (email != null ? "Candidate App [ @" + email + " ] " : "");
    }

    @Override
    protected void drawFormTitle(final String title) {
        final String titleBorder = BORDER.substring(0, 2) + "Jobs4U - Candidate App" + title;
        System.out.println(titleBorder);
        drawFormBorder();
    }
}
