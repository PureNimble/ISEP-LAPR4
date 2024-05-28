package lapr4.jobs4u.interviewmanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;
import jakarta.persistence.Embeddable;

/**
 * @author 2DI2
 */
@Embeddable
public class Grade implements ValueObject, Comparable<Grade> {

    private static final long serialVersionUID = 1L;

    private final Double grade;

    protected Grade(final String grade) {
        Preconditions.nonEmpty(grade, "Grade should neither be null nor empty");
        Preconditions.ensure(grade.matches("^100([.,]0+)?|0([.,][0-9]+)?|([1-9][0-9]?([.,][0-9]+)?)$"),
                "Grade should be a number between 0 and 100");
        this.grade = Double.parseDouble(grade.replace(',', '.'));
    }

    protected Grade() {
        this.grade = null;
    }

    public static Grade valueOf(final String grade) {
        return new Grade(grade);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Grade)) {
            return false;
        }

        final Grade that = (Grade) o;
        return this.grade.equals(that.grade);
    }

    @Override
    public String toString() {
        return grade.toString();
    }

    @Override
    public int compareTo(final Grade arg0) {
        return grade.compareTo(arg0.grade);
    }

}