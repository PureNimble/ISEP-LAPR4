/*
 * Copyright (c) 2013-2024 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package lapr4.jobs4u.app.candidate.console;

import lapr4.jobs4u.AppSettings;
import lapr4.jobs4u.app.candidate.console.presentation.FrontMenu;
import lapr4.jobs4u.app.common.ClientBackend;
import lapr4.jobs4u.infrastructure.persistence.PersistenceContext;
import lapr4.jobs4u.usermanagement.domain.BasePasswordPolicy;

import java.io.IOException;

import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;

/**
 *
 * @author Paulo Gandra Sousa
 */
@SuppressWarnings("squid:S106")
public final class CandidateApp {

    /**
     * Empty constructor is private to avoid instantiation of this class.
     */
    private CandidateApp() {
    }

    public static void main(final String[] args) {
        System.out.println("=====================================");
        System.out.println("Candidate App");
        System.out.println("(C) 2024");
        System.out.println("=====================================");

        AuthzRegistry.configure(PersistenceContext.repositories().users(), new BasePasswordPolicy(),
                new PlainTextEncoder());

        final AppSettings appSettings = new AppSettings();
        final String host = appSettings.serverHost();
        final Integer port = appSettings.serverPort();
        final ClientBackend client = ClientBackend.getInstance();
        try {
            client.connect(host, port);
            new FrontMenu().show();
        } catch (final IOException e) {
            System.out.println("Error connecting to host: " + host + " on port " + port);
        }

        // exiting the application, closing all threads
        System.exit(0);
    }
}
