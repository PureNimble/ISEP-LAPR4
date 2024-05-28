package lapr4.jobs4u.applicationmanagement.domain;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Transient;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.io.util.Files;
import eapli.framework.validations.Preconditions;

/**
 * @author 2DI2
 */
@Embeddable
public class File implements ValueObject, Comparable<File>, Runnable {

    private static final long serialVersionUID = 1L;
    private static final String EXTENSION = ".txt";

    private final String path;
    @Transient
    private Map<String, Integer> topWords;

    protected File(final String file) {
        Preconditions.nonEmpty(file, "File should neither be null nor empty");
        //Preconditions.ensure(isFileValid(file), "File does not exist");
        this.path = Files.ensureExtension(file, EXTENSION);
    }

    protected File() {
        this.path = "";
    }

    public static File valueOf(final String file) {
        return new File(file);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof File)) {
            return false;
        }

        final File that = (File) o;
        return this.path.equals(that.path);
    }

    @Override
    public int hashCode() {
        return this.path.hashCode();
    }

    @Override
    public String toString() {
        return this.path;
    }

    @Override
    public int compareTo(final File arg0) {
        return path.compareTo(arg0.path);
    }

    /* private static boolean isFileValid(final String file) {
        return java.nio.file.Files.exists(java.nio.file.Paths.get(file));
    } */

    public String fileName() {
        return this.path.substring(this.path.lastIndexOf('/') + 1);
    }

    /**
     * Gets the full content of an input stream as a single String encoded as
     * UTF-8. The input stream is still active and open after calling this
     * method.
     *
     * @param is the input stream
     * @return the correspondent UTF-8 String
     * @throws IOException
     */
    public String textFrom() {
        try {
            InputStream inputStream = new FileInputStream(this.path);
            return Files.textFrom(inputStream, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
            return null; // Return null or some default value in case of an exception
        }
    }

    /**
     * Simple utility to call the default OS application to open a file.
     *
     * @param path
     * @return the return code of the spawned process
     * @throws IOException
     * @throws InterruptedException
     */
    public static int openInOSViewer(final String path) throws IOException, InterruptedException {
        return Files.openInOSViewer(path);
    }

    @Override
    public void run() {
        topWords = new HashMap<>();
        String text = textFrom();
        String[] words = text.split("\\s+");
        Integer value;
        for (String word : words) {
            value = 1;
            if (topWords.containsKey(word))
                value = topWords.get(word) + 1;

            addCount(word, value);
        }
    }

    private synchronized void addCount(String word, Integer value) {
        topWords.put(word, value);
    }

    public Map<String, Integer> getTopWords() {
        return topWords;
    }
}