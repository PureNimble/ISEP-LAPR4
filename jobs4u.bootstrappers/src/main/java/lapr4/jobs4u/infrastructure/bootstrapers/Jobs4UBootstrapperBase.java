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
package lapr4.jobs4u.infrastructure.bootstrapers;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lapr4.jobs4u.candidatemanagement.application.RegisterCandidateController;
import lapr4.jobs4u.candidatemanagement.domain.Candidate;
import lapr4.jobs4u.customermanagement.application.RegisterCustomerController;
import lapr4.jobs4u.customermanagement.domain.Customer;
import lapr4.jobs4u.infrastructure.persistence.PersistenceContext;
import lapr4.jobs4u.jobopeningmanagement.application.RegisterJobOpeningController;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
import lapr4.jobs4u.recruitmentprocessmanagement.application.SetUpRecruitmentProcessController;
import lapr4.jobs4u.recruitmentprocessmanagement.domain.RecruitmentProcess;
import lapr4.jobs4u.usermanagement.application.AddUserController;
import lapr4.jobs4u.usermanagement.application.ListUsersController;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.authz.domain.model.Username;

public class Jobs4UBootstrapperBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(Jobs4UBootstrapperBase.class);

    final AddUserController userController = new AddUserController();
    final ListUsersController listUserController = new ListUsersController(PersistenceContext.repositories().users());
    final RegisterCustomerController registerCustomerController = new RegisterCustomerController(
            PersistenceContext.repositories().customers(), PersistenceContext.repositories().customerUsers(),
            AuthzRegistry.authorizationService());
    final RegisterCandidateController registerCandidateController = new RegisterCandidateController(
            PersistenceContext.repositories().candidates(), PersistenceContext.repositories().candidateUsers(),
            AuthzRegistry.authorizationService());
    final RegisterJobOpeningController registerJobOpeningController = new RegisterJobOpeningController(
            PersistenceContext.repositories().jobOpenings(), AuthzRegistry.authorizationService());
    final SetUpRecruitmentProcessController setUpRecruitmentProcessController = new SetUpRecruitmentProcessController(
            PersistenceContext.repositories().recruitmentProcesses(), PersistenceContext.repositories().jobOpenings(),
            AuthzRegistry.authorizationService());

    public Jobs4UBootstrapperBase() {
        super();
    }

    /**
     * @param username
     * @param password
     * @param firstName
     * @param lastName
     * @param email
     * @param roles
     */
    protected SystemUser registerUser(final String email, final String firstName,
            final String lastName, final Set<Role> roles) {
        SystemUser u = null;
        try {
            u = userController.addUser(email, firstName, lastName, roles);
            LOGGER.debug("»»» %s", email);
        } catch (final IntegrityViolationException | ConcurrencyException e) {
            // assuming it is just a primary key violation due to the tentative
            // of inserting a duplicated user. let's just lookup that user
            u = listUserController.find(Username.valueOf(email)).orElseThrow(() -> e);
        }
        return u;
    }

    protected Customer addCustomer(final String name, final String address, final String customerCode,
            final String email, final String phoneNumber, final String firstName, final String lastName,
            final Set<Role> roles) {
        Customer c = null;
        try {
            c = registerCustomerController.registerCustomer(name, address, customerCode, email, phoneNumber);
            final SystemUser su = registerUser(email, firstName, lastName, roles);
            registerCustomerController.registerCustomerUser(c, su);

            LOGGER.debug("»»» {}", email);
        } catch (final IntegrityViolationException | ConcurrencyException e) {
            // assuming it is just a primary key violation due to the tentative
            // of inserting a duplicated user. let's just lookup that user
            // cu = listUserController.find(Username.valueOf(email)).orElseThrow(() -> e);
        }
        return c;
    }

    protected Candidate addCandidate(final String firstName, final String lastName, final String email,
            final String phoneNumber, final Set<Role> roles) {
        Candidate ca = null;
        try {
            ca = registerCandidateController.registerCandidate(firstName, lastName, email, phoneNumber);
            final SystemUser su = registerUser(email, firstName, lastName, roles);
            registerCandidateController.registerCandidateUser(ca, su);

            LOGGER.debug("»»» {}", email);
        } catch (final IntegrityViolationException | ConcurrencyException e) {
            // assuming it is just a primary key violation due to the tentative
            // of inserting a duplicated user. let's just lookup that user
            // cu = listUserController.find(Username.valueOf(email)).orElseThrow(() -> e);
        }
        return ca;
    }

    protected JobOpening addJobOpening(final String titleOrFunction, final String contractType,
            final String mode, final String address, final Customer customer, final String jobDescription) {
        JobOpening jo = null;
        try {
            jo = registerJobOpeningController.SetUpJobOpening(titleOrFunction, contractType,
                    mode, address, customer, jobDescription);
            LOGGER.debug("»»» {}", titleOrFunction);
        } catch (final IntegrityViolationException | ConcurrencyException e) {
            // assuming it is just a primary key violation due to the tentative
            // of inserting a duplicated user. let's just lookup that user
            // cu = listUserController.find(Username.valueOf(email)).orElseThrow(() -> e);
        }
        return jo;
    }

    protected RecruitmentProcess addRecruitmentProcess(final String applicationInitialDate,
            final String applicationFinalDate,
            final String screeningInitialDate, final String screeningFinalDate,
            final String interviewInitialDate,
            final String interviewFinalDate, final String analysisInitialDate,
            final String analysisFinalDate,
            final String resultInitialDate, final String resultFinalDate, final JobOpening jobOpening) {
        RecruitmentProcess re = null;
        try {
            re = setUpRecruitmentProcessController.SetUpRecruitmentProcess(applicationInitialDate,
                    applicationFinalDate, screeningInitialDate, screeningFinalDate, interviewInitialDate,
                    interviewFinalDate, analysisInitialDate, analysisFinalDate, resultInitialDate,
                    resultFinalDate, jobOpening);
            LOGGER.debug("»»» {}", jobOpening);
        } catch (final IntegrityViolationException | ConcurrencyException e) {
            // assuming it is just a primary key violation due to the tentative
            // of inserting a duplicated user. let's just lookup that user
            // cu = listUserController.find(Username.valueOf(email)).orElseThrow(() -> e);
        }
        return re;
    }
}
