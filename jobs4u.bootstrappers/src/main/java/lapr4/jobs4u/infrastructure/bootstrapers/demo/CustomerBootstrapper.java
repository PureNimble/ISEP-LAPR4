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
package lapr4.jobs4u.infrastructure.bootstrapers.demo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import lapr4.jobs4u.customermanagement.domain.Customer;
import lapr4.jobs4u.infrastructure.bootstrapers.Jobs4UBootstrapperBase;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
import lapr4.jobs4u.recruitmentprocessmanagement.domain.RecruitmentProcess;
import lapr4.jobs4u.usermanagement.domain.BaseRoles;
import eapli.framework.actions.Action;
import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.time.util.CurrentTimeCalendars;

/**
 * @author Paulo Gandra Sousa
 */
public class CustomerBootstrapper extends Jobs4UBootstrapperBase implements Action {

        @Override
        public boolean execute() {
                final Customer c = registerCustomer("Customer", "Rua do Customer", "CUSTOMER", "cu@email.local",
                                "912345678",
                                "Customer", "Customer");
                final JobOpening jo = registerJobOpening("JobOpening", "FULL_TIME", "PRESENTIAL", "Rua do Job Opening",
                                c, "Job Opening Description", "26");

                setUpRecruitmentProcess(jo);
                return true;
        }

        private Customer registerCustomer(final String name, final String address, final String customerCode,
                        final String email, final String phoneNumber, final String firstName, final String lastName) {
                final Set<Role> roles = new HashSet<>();
                roles.add(BaseRoles.CUSTOMER);

                return addCustomer(name, address, customerCode, email, phoneNumber, firstName, lastName, roles);
        }

        private JobOpening registerJobOpening(final String titleOrFunction, final String contractType,
                        final String mode, final String address, final Customer customer, final String jobDescription,
                        final String numberOfVacancies) {

                return addJobOpening(titleOrFunction, contractType, mode, address, customer, jobDescription,
                                numberOfVacancies);
        }

        private RecruitmentProcess setUpRecruitmentProcess(JobOpening jobOpening) {

                SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
                Calendar calendar = CurrentTimeCalendars.now();

                String[] dates = new String[10];
                for (int i = 0; i < dates.length; i++) {
                        calendar.add(Calendar.MONTH, i);
                        Date date = calendar.getTime();
                        dates[i] = format.format(date);
                }

                return addRecruitmentProcess(dates[0], dates[1], dates[2], dates[3], dates[4], dates[5], dates[6],
                                dates[7], dates[8], dates[9], jobOpening);
        }
}
