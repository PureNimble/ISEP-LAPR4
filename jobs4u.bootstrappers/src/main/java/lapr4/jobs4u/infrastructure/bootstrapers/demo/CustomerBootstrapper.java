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
 * @author 2DI2
 */
public class CustomerBootstrapper extends Jobs4UBootstrapperBase implements Action {

        @Override
        public boolean execute() {
                final Customer c = registerCustomer("Customer", "Rua do Customer", "CUSTOMER", "cu@email.local",
                                "912345678", "Customer", "Customer");
                final Customer m = registerCustomer("Microsoft", "1 Microsoft Way", "MICROSOFT",
                                "billgates@microsoft.local", "912345678",
                                "Bill", "Gates");
                final Customer a = registerCustomer("Amazon", "410 Terry Ave N", "AMAZON", "jeffbezos@amazon.local",
                                "912345678",
                                "Jeff", "Bezos");

                registerJobOpening("Project Manager", "FULL_TIME", "PRESENTIAL",
                                "789 Project Parkway", c, "Manage and oversee project execution", "35");
                registerJobOpening("Community Outreach Volunteer", "VOLUNTEER", "PRESENTIAL",
                                "123 Volunteer Street", c, "Help organize and run community events", "8");
                registerJobOpening("Data Scientist", "INTERNSHIP", "REMOTE",
                                "123 Data Drive", m, "Analyze and interpret complex data sets", "30");
                registerJobOpening("Cloud Solutions Architect", "FULL_TIME", "HYBRID",
                                "410 Terry Ave N", a, "Design and manage solutions on Amazon Web Services", "10");
                final JobOpening activeMJO = registerJobOpening("Frontend Developer", "PART_TIME", "HYBRID",
                                "456 Frontend Street", m, "Develop user-friendly web interfaces", "15");
                final JobOpening activeCJO = registerJobOpening("Software Engineer", "FULL_TIME", "REMOTE",
                                "123 Software Street", c, "Develop and maintain software applications", "26");
                final JobOpening anotherActiveMJO = registerJobOpening("Data Analyst", "INTERNSHIP", "HYBRID",
                                "456 Data Drive", m, "Analyze and interpret complex data sets", "30");
                setUpRecruitmentProcess(activeMJO, true);
                setUpRecruitmentProcess(activeCJO, true);
                setUpRecruitmentProcess(anotherActiveMJO, false);
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

        private RecruitmentProcess setUpRecruitmentProcess(final JobOpening jobOpening, final boolean interview) {

                SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
                Calendar calendar = CurrentTimeCalendars.now();

                String[] dates = new String[10];
                for (int i = 0; i < dates.length; i++) {
                        calendar.add(Calendar.MONTH, i);
                        Date date = calendar.getTime();
                        dates[i] = format.format(date);
                }
                if (interview)
                        return addRecruitmentProcess(dates[0], dates[1], dates[2], dates[3], dates[4], dates[5],
                                        dates[6], dates[7], dates[8], dates[9], jobOpening);
                else
                        return addRecruitmentProcess(dates[0], dates[1], dates[2], dates[3], dates[4], dates[5],
                                        dates[6], dates[7], jobOpening);
        }
}
