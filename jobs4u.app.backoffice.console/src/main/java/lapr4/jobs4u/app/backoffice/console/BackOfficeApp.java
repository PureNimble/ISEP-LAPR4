/*
 * Copyright (c) 2013-2024 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package lapr4.jobs4u.app.backoffice.console;

import lapr4.jobs4u.app.backoffice.console.presentation.FrontMenu;
import lapr4.jobs4u.app.common.console.Jobs4UApplication;
import lapr4.jobs4u.infrastructure.persistence.PersistenceContext;
import lapr4.jobs4u.usermanagement.domain.BasePasswordPolicy;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;
import eapli.framework.infrastructure.pubsub.EventDispatcher;

/**
 *
 * @author Paulo Gandra Sousa
 */
@SuppressWarnings("squid:S106")
public final class BackOfficeApp extends Jobs4UApplication {

    /**
     * avoid instantiation of this class.
     */
    private BackOfficeApp() {
    }

    /**
     * @param args
     *            the command line arguments
     */
    public static void main(final String[] args) {

        AuthzRegistry.configure(PersistenceContext.repositories().users(),
                new BasePasswordPolicy(), new PlainTextEncoder());

        new BackOfficeApp().run(args);
    }

    @Override
    protected void doMain(final String[] args) {
        new FrontMenu().show();
    }

    @Override
    protected String appTitle() {
        return "Jobs4U - BackOffice";
    }

    @Override
    protected String appGoodbye() {
        return "Goodbye!";
    }

    @Override
    protected void doSetupEventHandlers(final EventDispatcher dispatcher) {}
}
