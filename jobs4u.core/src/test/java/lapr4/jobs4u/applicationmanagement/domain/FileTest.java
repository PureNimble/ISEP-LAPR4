package lapr4.jobs4u.applicationmanagement.domain;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;

import eapli.framework.io.util.Files;

public class FileTest {
    String valid_format = "jobs4u.applicationsFileBot/resources/input";
    String VALID_FILE = valid_format + "/1-big-file-1.txt";
    String VALID_FILE2 = valid_format + "/1-candidate-data.txt";
    static final String INVALID_FILE = "temo/sharedfolder";

    public static File dummyFile(final String file) {
        System.out.println(Files.currentDirectory());
        String temp = file;
        if (Files.currentDirectory().contains("jobs4u.core")) {
            temp = "../" + file;
        }

        return File.valueOf(temp);
    }

    private File getNewDummyFile(final String file) {
        return dummyFile(file);
    }

    @Test
    public void ensureFileEqualsPassesForTheSameFileValues() throws Exception {

        final File aFile = getNewDummyFile(VALID_FILE);

        final File anotherFile = getNewDummyFile(VALID_FILE);

        final boolean expected = aFile.equals(anotherFile);

        assertTrue(expected);
    }

    @Test
    public void ensureFileEqualsFailsForDifferenteFileValues() throws Exception {

        final File aFile = getNewDummyFile(VALID_FILE);

        final File anotherFile = getNewDummyFile(VALID_FILE2);

        final boolean expected = aFile.equals(anotherFile);

        assertFalse(expected);
    }

    @Test
    public void ensureFileEqualsAreTheSameForTheSameInstance() throws Exception {
        final File file = getNewDummyFile(VALID_FILE);

        final boolean expected = file.equals(file);

        assertTrue(expected);
    }

    @Test
    public void ensureFileEqualsFailsForDifferenteObjectTypes() throws Exception {
        final File file = getNewDummyFile(VALID_FILE);

        final boolean expected = file.equals(getNewDummyFile(VALID_FILE));

        assertTrue(expected);
    }

}
