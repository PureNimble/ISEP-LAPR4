package lapr4.jobs4u.jobopeningmanagement.domain;

import jakarta.persistence.Embeddable;
import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

@Embeddable
public class Mode implements ValueObject, Comparable<Mode> {

    private static final long serialVersionUID = 1L;

    private final String mode;

    protected Mode(final String mode) {
        Preconditions.nonEmpty(mode, "Mode should neither be null nor empty");
        Preconditions.ensure(ModeTypes.valueOf(mode) != null, "Mode must be one of the valid modes");
        this.mode = mode;
    }

    protected Mode() {
        this.mode = "";
    }

    public static Mode valueOf(final String mode) {
        return new Mode(mode);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Mode)) {
            return false;
        }

        final Mode that = (Mode) o;
        return this.mode.equals(that.mode);
    }

    @Override
    public int hashCode() {
        return this.mode.hashCode();
    }

    @Override
    public String toString() {
        return this.mode;
    }

    @Override
    public int compareTo(final Mode arg0) {
        return mode.compareTo(arg0.mode);
    }
}