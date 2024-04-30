package lapr4.jobs4u.applicationmanagement.domain;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;

public class FileTest {

    static final String FILE = "sharedfolder/temp";
    static final String FILE2 = "temo/sharedfolder";

    public static File dummyFile(final String file) {

        return File.valueOf(file);
    }

    private File getNewDummyFile(final String file) {
        return dummyFile(file);
    }

    @Test
    public void ensureFileEqualsPassesForTheSameFileValues() throws Exception {

        final File aFile = getNewDummyFile(FILE);

        final File anotherFile = getNewDummyFile(FILE);

        final boolean expected = aFile.equals(anotherFile);

        assertTrue(expected);
    }

    @Test
    public void ensureFileEqualsFailsForDifferenteFileValues() throws Exception {

        final File aFile = getNewDummyFile(FILE);

        final File anotherFile = getNewDummyFile(FILE2);

        final boolean expected = aFile.equals(anotherFile);

        assertFalse(expected);
    }

    @Test
    public void ensureFileEqualsAreTheSameForTheSameInstance() throws Exception {
        final File file = getNewDummyFile(FILE);

        final boolean expected = file.equals(file);

        assertTrue(expected);
    }

    @Test
    public void ensureFileEqualsFailsForDifferenteObjectTypes() throws Exception {
        final File file = getNewDummyFile(FILE);

        final boolean expected = file.equals(getNewDummyFile(FILE2));

        assertFalse(expected);
    }

    /* @Test(expected = Exception.class)
    public void testInvalidFile() throws Exception {
        final File file = getNewDummyFile("boas");
    } */

}
