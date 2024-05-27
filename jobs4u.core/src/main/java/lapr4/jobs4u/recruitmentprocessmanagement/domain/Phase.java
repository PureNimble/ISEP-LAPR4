package lapr4.jobs4u.recruitmentprocessmanagement.domain;

import eapli.framework.validations.Preconditions;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.MappedSuperclass;

/**
 * @author 2DI2
 */
@MappedSuperclass
public abstract class Phase {
    
    @Embedded
    @AttributeOverride(name = "date", column = @Column(name = "initial_date"))
    private Date initialDate;

    @Embedded
    @AttributeOverride(name = "date", column = @Column(name = "final_date"))
    private Date finalDate;
    
    @Embedded
    private State state;

    @Column(name = "in_progress")
    private boolean inProgress;
    
    protected Phase(final String initialDate, final String finalDate) {
        Preconditions.noneNull(new Object[] { initialDate, finalDate});
        Date initialDateTemp = Date.valueOf(initialDate);
        Date finalDateTemp = Date.valueOf(finalDate);
        if (initialDateTemp.isAfter(finalDateTemp)) {
            throw new IllegalArgumentException("Initial date cannot be after final date");
        }
        this.initialDate = initialDateTemp;
        this.finalDate = finalDateTemp;
        this.state = State.valueOf(ActivityState.CLOSED.toString());
        this.inProgress = false;
    }

    protected Phase(final String initialDate, final String finalDate, final String minDate) {
        Preconditions.noneNull(new Object[] { initialDate, finalDate, minDate });
        Date initialDateTemp = Date.valueOf(initialDate);
        Date finalDateTemp = Date.valueOf(finalDate);
        Date minDateTemp = Date.valueOf(minDate);
        if (initialDateTemp.isAfter(finalDateTemp) || initialDateTemp.isBefore(minDateTemp)){
            throw new IllegalArgumentException("Initial date cannot be after final date or before min date");
        }
        this.initialDate = initialDateTemp;
        this.finalDate = finalDateTemp;
        this.state = State.valueOf(ActivityState.CLOSED.toString());
        this.inProgress = false;
    }

    protected Phase() {
        this.initialDate = null;
        this.finalDate = null;
        this.state = null;
        this.inProgress = false;
    }

    public Date initialDate() {
        return initialDate;
    }

    public Date finalDate() {
        return finalDate;
    }

    public State state() {
        return state;
    }

    public boolean inProgress() {
        return inProgress;
    }

    public void open() {
        if (this.state.equals(State.valueOf(ActivityState.CLOSED.toString()))) {
            this.state = State.valueOf(ActivityState.OPEN.toString());
        }
        else {
            throw new IllegalStateException("Phase is already open");
        }
    }

    public void close() {
        if (this.state.equals(State.valueOf(ActivityState.OPEN.toString()))) {
            this.state = State.valueOf(ActivityState.CLOSED.toString());
        }
        else {
            throw new IllegalStateException("Phase is already closed");
        }
    }
}
