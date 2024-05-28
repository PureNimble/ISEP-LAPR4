package lapr4.jobs4u.interviewmanagement.domain;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

/**
 * @author 2DI2
 */
@Embeddable
public class Time implements ValueObject, Comparable<Time> {

    private static final long serialVersionUID = 1L;
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm");

    @Temporal(TemporalType.TIME)
    private final LocalTime time;

    protected Time(final String timeStr) {
        Preconditions.nonEmpty(timeStr, "Time should neither be null nor empty");
        Preconditions.ensure(timeStr.matches("([01]?[0-9]|2[0-3]):[0-5][0-9]"), "Invalid time format");
        this.time = LocalTime.parse(timeStr, TIME_FORMATTER);
    }

    protected Time() {
        this.time = null;
    }

    public static Time valueOf(final String time) {
        return new Time(time);
    }

    public boolean isAfter(final Time o) {
        return this.time.isAfter(o.time);
    }

    public boolean isBefore(final Time o) {
        return this.time.isBefore(o.time);
    }

    public static Time now() {
        String formattedTime = LocalTime.now().format(TIME_FORMATTER);
        return valueOf(formattedTime);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Time)) {
            return false;
        }

        final Time that = (Time) o;
        return this.time.equals(that.time);
    }

    @Override
    public String toString() {
        return time.format(TIME_FORMATTER);
    }

    @Override
    public int compareTo(final Time arg0) {
        return time.compareTo(arg0.time);
    }

}