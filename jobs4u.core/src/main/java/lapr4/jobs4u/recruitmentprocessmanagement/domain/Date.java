package lapr4.jobs4u.recruitmentprocessmanagement.domain;

import jakarta.persistence.Embeddable;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

@Embeddable
public class Date implements ValueObject, Comparable<Date> {

    private static final long serialVersionUID = 1L;
    private static final Pattern VALID_DATE_REGEX = Pattern
            .compile("^(0[1-9]|[12][0-9]|3[01])[-](0[1-9]|1[012])[-](19|20)\\d\\d$");
    private final String date;

    protected Date(final String date) {
        Preconditions.nonEmpty(date, "Dates should neither be null nor empty");
        Preconditions.matches(VALID_DATE_REGEX, date, "Invalid Dates: " + date);
        this.date = date;
    }

    protected Date() {
        this.date = null;
    }

    public static Date valueOf(final String date) {
        return new Date(date);
    }

    public boolean isAfter(Date o) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate thisDate = LocalDate.parse(this.date, formatter);
        LocalDate otherDate = LocalDate.parse(o.date, formatter);
        return thisDate.isAfter(otherDate);
    }

    public boolean isBefore(Date o) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate thisDate = LocalDate.parse(this.date, formatter);
        LocalDate otherDate = LocalDate.parse(o.date, formatter);
        return thisDate.isBefore(otherDate);
    }

    public static Date today() {
        return new Date(LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Date)) {
            return false;
        }

        final Date that = (Date) o;
        return this.date.equals(that.date);
    }

    @Override
    public int hashCode() {
        return this.date.hashCode();
    }

    @Override
    public String toString() {
        return this.date;
    }

    @Override
    public int compareTo(final Date arg0) {
        return date.compareTo(arg0.date);
    }
}
