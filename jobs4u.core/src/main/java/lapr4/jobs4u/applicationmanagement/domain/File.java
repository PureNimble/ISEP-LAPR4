package lapr4.jobs4u.applicationmanagement.domain;

import jakarta.persistence.Embeddable;

import java.util.regex.Pattern;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

@Embeddable
public class File implements ValueObject, Comparable<File> {

    private static final long serialVersionUID = 1L;

    private final String path;
    private static final Pattern VALID_PATTERN = Pattern.compile("^[a-zA-Z0-9_/\\.\\-]+$");

    protected File(final String file) {
        Preconditions.nonEmpty(file, "File should neither be null nor empty");
        Preconditions.matches(VALID_PATTERN, file, "Invalid File: " + file);
        this.path = file;
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
}