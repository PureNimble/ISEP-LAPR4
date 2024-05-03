package lapr4.jobs4u.recruitmentprocessmanagement.domain;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.regex.Pattern;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.time.util.CurrentTimeCalendars;
import eapli.framework.validations.Preconditions;

@Embeddable
public class Date implements ValueObject, Comparable<Date> {

    private static final long serialVersionUID = 1L;
    private static final Pattern DATE_PATTERN = Pattern.compile("^\\d{2}-\\d{2}-\\d{4}$");

    @Temporal(TemporalType.DATE)
    private final Calendar date;

    protected Date(final String dateStr) {
        Preconditions.nonNull(dateStr, "Dates should not be null");
        Preconditions.matches(DATE_PATTERN, dateStr, "Date must be in the format dd-MM-yyyy");
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        sdf.setLenient(false);
        this.date = Calendar.getInstance();
        try {
            this.date.setTime(sdf.parse(dateStr));
        } catch (ParseException e) {
            throw new IllegalArgumentException("Invalid date format", e);
        }
    }

    protected Date() {
        this.date = null;
    }

    public static Date valueOf(final String date) {
        return new Date(date);
    }

    public boolean isAfter(Date o) {
        return this.date.after(o.date);
    }

    public boolean isBefore(Date o) {
        return this.date.before(o.date);
    }

    public static Date today() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String formattedDate = sdf.format(CurrentTimeCalendars.now().getTime());
        return valueOf(formattedDate);
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        return sdf.format(date.getTime());
    }

    @Override
    public int compareTo(final Date arg0) {
        return date.compareTo(arg0.date);
    }
}