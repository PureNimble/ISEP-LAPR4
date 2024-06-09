package lapr4.jobs4u.applicationmanagement.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Map;

import org.junit.Test;

import eapli.framework.io.util.Files;

/**
 * @author 2DI2
 * 
 */

public class FileTest {
    String valid_format = "SCOMP/sprintc/resources/input/";
    String VALID_FILE = valid_format + "3-file-1.txt";
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

    @Test
    public void ensureAllFilesGetTopWords() throws Exception {
        final File file = getNewDummyFile(VALID_FILE);
        Thread t = new Thread(file);
        t.start();
        t.join();
        Map<String, Integer> output = file.getTopWords();
        assertFalse(output.isEmpty());
        assertTrue(output.get("numerous").equals(1));
        assertEquals(378, output.size());
    }

    @Test
    public void ensureBigFileTakesLessThan3seconds() throws Exception {
        long startTime = System.nanoTime();

        final File file = dummyFile("1-big-file-1.txt");
        Thread t = new Thread(file);
        t.start();
        t.join();

        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        assertTrue(duration / 1000000000 < 2);

    }

}