package lapr4.jobs4u.requirementmanagement.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

@Embeddable
public class Time implements ValueObject, Comparable<Time> {

    private static final long serialVersionUID = 1L;
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm");

    @Column(nullable = false)
    private final LocalTime time;

    protected Time(final String timeStr) {
        Preconditions.nonEmpty(timeStr, "Time should neither be null nor empty");
        Preconditions.nonNull(timeStr, "Time should neither be null nor empty");
        Preconditions.ensure(timeStr.matches("([01]?[0-9]|2[0-3]):[0-5][0-9]"), "Invalid time format");
        this.time = LocalTime.parse(timeStr, TIME_FORMATTER);
    }

    protected Time() {
        this.time = null;
    }

    public static Time valueOf(final String time) {
        return new Time(time);
    }

    public boolean isAfter(Time o) {
        return this.time.isAfter(o.time);
    }

    public boolean isBefore(Time o) {
        return this.time.isBefore(o.time);
    }

    public static Time now() {
        String formattedTime = LocalTime.now().format(TIME_FORMATTER);
        return valueOf(formattedTime);
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