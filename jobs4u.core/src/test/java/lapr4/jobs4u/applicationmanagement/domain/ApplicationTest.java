package lapr4.jobs4u.applicationmanagement.domain;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ApplicationTest {
    static final String DATE = "10-02-2012";
    static final String FILE = "sharedfolder/temp";
    static final String APPLICATION_NUMBER = "1";
    static final String APPLICATION_NUMBER2 = "2";
    static final String FILE2 = "temo/sharedfolder";
    static final String DATE2 = "10-02-2017";

    public static Application dummyApplication(final String dateString, final String file,
            final String applicationNumberString) {
        List<File> files = new ArrayList<File>();
        File file1 = File.valueOf(file);
        files.add(file1);

        return new ApplicationBuilder().with(applicationNumberString, dateString, files).build();
    }

    private Application getNewDummyApplication(final String date, final String file, final String applicationNumber) {
        return dummyApplication(date, file, applicationNumber);
    }

    @Test
    public void ensureApplicationEqualsPassesForTheSameApplicationValues() throws Exception {

        final Application aApplication = getNewDummyApplication(DATE, FILE, APPLICATION_NUMBER);

        final Application anotherApplication = getNewDummyApplication(DATE, FILE, APPLICATION_NUMBER);

        final boolean expected = aApplication.equals(anotherApplication);

        assertTrue(expected);
    }

    @Test
    public void ensureApplicationEqualsFailsForDifferenteApplicationValues() throws Exception {

        final Application aApplication = getNewDummyApplication(DATE, FILE, APPLICATION_NUMBER);

        final Application anotherApplication = getNewDummyApplication(DATE2, FILE2, APPLICATION_NUMBER2);

        final boolean expected = aApplication.equals(anotherApplication);

        assertFalse(expected);
    }

    @Test
    public void ensureApplicationEqualsAreTheSameForTheSameInstance() throws Exception {
        final Application applicationaApplication = getNewDummyApplication(DATE, FILE, APPLICATION_NUMBER);

        final boolean expected = applicationaApplication.equals(applicationaApplication);

        assertTrue(expected);
    }

    @Test
    public void ensureApplicationEqualsFailsForDifferenteObjectTypes() throws Exception {
        final Application application = getNewDummyApplication(DATE, FILE, APPLICATION_NUMBER);

        final boolean expected = application.equals(getNewDummyApplication(DATE2, FILE2, APPLICATION_NUMBER2));

        assertFalse(expected);
    }

}
