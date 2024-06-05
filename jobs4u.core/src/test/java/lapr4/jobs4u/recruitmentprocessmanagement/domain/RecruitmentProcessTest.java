package lapr4.jobs4u.recruitmentprocessmanagement.domain;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.junit.Test;

import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.authz.domain.model.SystemUserBuilder;
import eapli.framework.time.util.CurrentTimeCalendars;
import lapr4.jobs4u.customermanagement.domain.Customer;
import lapr4.jobs4u.customermanagement.domain.CustomerBuilder;
import lapr4.jobs4u.usermanagement.domain.UserBuilderHelper;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpeningBuilder;

/**
 * @author 2DI2
 */
public class RecruitmentProcessTest {

    private final static Calendar calendar = CurrentTimeCalendars.now();

    public static RecruitmentProcess dummyJobOpening(final String applicationInitialDate,
            final String applicationFinalDate, final String screeningInitialDate, final String screeningFinalDate,
            final String interviewInitialDate, final String interviewFinalDate, final String analysisInitialDate,
            final String analysisFinalDate, final String resultInitialDate, final String resultFinalDate) {

        final RecruitmentProcessBuilder recruitmentProcessBuilder = new RecruitmentProcessBuilder();
        final JobOpeningBuilder jobOpeningBuilder = new JobOpeningBuilder();
        final CustomerBuilder customerBuilder = new CustomerBuilder();
        final SystemUserBuilder userBuilder = UserBuilderHelper.builder();
        final SystemUser aSu = userBuilder
                .with("username@email.local", "Pass123", "firstName", "lastName", "email@email.local").build();
        final Customer aCustomer = customerBuilder
                .with("Fnac", "R. Sara Afonso 105, 4460-841 Sra. da Hora", "ABC123",
                        "fnac@email.local", "910000000", aSu)
                .build();
        JobOpening jo = jobOpeningBuilder.with("abcdefghij", "titleOrFunction", "VOLUNTEER",
                "HYBRID", "address", aCustomer, "jobDescription", calendar, "34").build();

        return recruitmentProcessBuilder
                .with(applicationInitialDate, applicationFinalDate, screeningInitialDate, screeningFinalDate,
                        interviewInitialDate, interviewFinalDate, analysisInitialDate, analysisFinalDate,
                        resultInitialDate, resultFinalDate, jo, jo.registeredOn().toString())
                .build();

    }

    private RecruitmentProcess getNewDummyJobOpening(final String applicationInitialDate,
            final String applicationFinalDate, final String screeningInitialDate, final String screeningFinalDate,
            final String interviewInitialDate, final String interviewFinalDate, final String analysisInitialDate,
            final String analysisFinalDate, final String resultInitialDate, final String resultFinalDate) {
        return dummyJobOpening(applicationInitialDate, applicationFinalDate, screeningInitialDate, screeningFinalDate,
                interviewInitialDate, interviewFinalDate, analysisInitialDate, analysisFinalDate, resultInitialDate,
                resultFinalDate);
    }

    @Test
    public void ensureRecruitmentProcessIsSequential() throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

        String[] dates = new String[10];
        for (int i = 0; i < dates.length; i++) {
            calendar.add(Calendar.MONTH, i);
            java.util.Date date = calendar.getTime();
            dates[i] = format.format(date);
        }

        assertThrows(IllegalArgumentException.class, () -> {
            getNewDummyJobOpening(dates[0], dates[1], dates[4], dates[5],
                    dates[3], dates[4], dates[6], dates[7], dates[8], dates[9]);
        });
    }

    @Test
    public void ensureRecruitmentProcessApplicationDateIsAfterJobOpeningReg() throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        String[] dates = new String[10];
        for (int i = 0; i < dates.length; i++) {
            calendar.add(Calendar.MONTH, i);
            java.util.Date date = calendar.getTime();
            dates[i] = format.format(date);
        }

        assertThrows(IllegalArgumentException.class, () -> {
            getNewDummyJobOpening("01-01-1950", dates[1], dates[4], dates[5],
                    dates[3], dates[3], dates[6], dates[7], dates[8], dates[9]);
        });
    }

    @Test
    public void ensureRecruitmentProcessWithNullArgs() throws Exception {

        assertThrows(IllegalArgumentException.class, () -> {
            getNewDummyJobOpening(null, null, null, null, null, null, null, null, null, null);
        });
    }

    @Test
    public void ensureRecruitmentProcessWithEmptyArgs() throws Exception {

        assertThrows(IllegalArgumentException.class, () -> {
            getNewDummyJobOpening("", "", "", "", "", "", "", "", "", "");
        });
    }
}
