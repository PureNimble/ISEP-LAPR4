package lapr4.jobs4u.applicationmanagement.domain;

import jakarta.persistence.Embeddable;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.regex.Pattern;
import eapli.framework.domain.model.ValueObject;
import eapli.framework.io.util.Files;
import eapli.framework.validations.Preconditions;

@Embeddable
public class File implements ValueObject, Comparable<File> {

    private static final long serialVersionUID = 1L;
    private static final String EXTENSION = ".txt";

    private final String path;
    private static final Pattern VALID_PATTERN = Pattern.compile("^[a-zA-Z0-9_/\\.\\-]+$");

    protected File(final String file) {
        Preconditions.nonEmpty(file, "File should neither be null nor empty");
        Preconditions.matches(VALID_PATTERN, file, "Invalid File: " + file);
        // Preconditions.ensure(isFileValid(file), "File does not exist");
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

    private boolean isFileValid(final String file) {
        // check if path exists
        return java.nio.file.Files.exists(Paths.get(file));
    }

    /**
     * Gets the full content of an input stream as a single String encoded as UTF-8.
     * The input
     * stream
     * is still active and open after calling this method.
     *
     * @param is
     *           the input stream
     * @return the correspondent UTF-8 String
     * @throws IOException
     */
    public static String textFrom(final InputStream is) throws IOException {
        return Files.textFrom(is);
    }

    /**
     * Simple utility to call the default OS application to open a file.
     *
     * @param path
     * @return the return code of the spawned process
     * @throws IOException
     * @throws InterruptedException
     */
    public static String textFrom(final InputStream is, final String encoding) throws IOException {
        return Files.textFrom(is, encoding);
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
}