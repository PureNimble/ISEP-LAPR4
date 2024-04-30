package lapr4.jobs4u.recruitmentprocessmanagement.domain;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Phase {

    @Embedded
    @AttributeOverride(name = "date", column = @Column(name = "initial_date"))
    private Date initialDate;

    @Embedded
    @AttributeOverride(name = "date", column = @Column(name = "final_date"))
    private Date finalDate;

    private final State state;
    
    protected Phase(final String initialDate, final String finalDate) {
        Date initialDateTemp = Date.valueOf(initialDate);
        Date finalDateTemp = Date.valueOf(finalDate);
        Date.valueOf(finalDate);
        if (initialDateTemp.isAfter(finalDateTemp)) {
            throw new IllegalArgumentException("Initial date cannot be after final date");
        }
        this.initialDate = initialDateTemp;
        this.finalDate = finalDateTemp;
        this.state = State.valueOf(ActivityState.CLOSED.toString());
    }

    protected Phase() {
        this.initialDate = null;
        this.finalDate = null;
        this.state = null;
    }

    public Date initialDate() {
        return initialDate;
    }

    public Date finalDate() {
        return finalDate;
    }
}
