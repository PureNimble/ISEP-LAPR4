package lapr4.jobs4u.applicationmanagement.domain;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Map;

import org.junit.Test;

public class FilePartitionTest {

    @Test
    public void simpleExampleTest() throws Exception {

        final FilePartition afile = new FilePartition("This is a example of a text file");

        Thread t = new Thread(afile);
        t.start();

        t.join();
        Map<String, Integer> output = afile.getTopWords();
        assertFalse(output.isEmpty());
        assertTrue(output.get("a").equals(2));
        assertTrue(output.get("is").equals(1));
        assertTrue(output.get("example").equals(1));
        assertTrue(output.get("of").equals(1));
        assertTrue(output.get("text").equals(1));
        assertTrue(output.get("file").equals(1));

    }

    @Test
    public void NonWordsTest() throws Exception {

        final FilePartition afile = new FilePartition("This is a email@gmail.com");

        Thread t = new Thread(afile);
        t.start();

        t.join();
        Map<String, Integer> output = afile.getTopWords();
        assertFalse(output.isEmpty());
        assertTrue(output.get("gmail").equals(1));
        assertTrue(output.get("email").equals(1));
        assertTrue(output.get("com").equals(1));
    }

    @Test
    public void insertNumbersTest() throws Exception {

        final FilePartition afile = new FilePartition("238901");

        Thread t = new Thread(afile);
        t.start();

        t.join();
        Map<String, Integer> output = afile.getTopWords();
        assertFalse(output.isEmpty());
        assertTrue(output.containsKey("238901"));

    }

    @Test
    public void insertEmojisTest() throws Exception {

        final FilePartition afile = new FilePartition("🍷🗿🍷🗿👌🤷‍♂️🤷‍♀️😎");

        Thread t = new Thread(afile);
        t.start();
        t.join();
        Map<String, Integer> output = afile.getTopWords();
        assertTrue(output.isEmpty());

    }

    @Test
    public void insertSymbolsTest() throws Exception {

        final FilePartition afile = new FilePartition("! @#$%^&*()_+{}|:\"<>?`-=[]\\; ', ./~");

        Thread t = new Thread(afile);
        t.start();
        t.join();
        Map<String, Integer> output = afile.getTopWords();
        assertTrue(output.isEmpty());

    }
}