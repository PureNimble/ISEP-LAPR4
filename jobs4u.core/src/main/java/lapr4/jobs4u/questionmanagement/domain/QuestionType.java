package lapr4.jobs4u.questionmanagement.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.representations.dto.DTOable;
import eapli.framework.validations.Preconditions;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lapr4.jobs4u.questionmanagement.dto.QuestionTypeDTO;

/**
 * @author 2DI2
 */
@XmlRootElement
@Entity
@Table(name = "T_QUESTION_TYPE")
public class QuestionType implements AggregateRoot<String>, DTOable<QuestionTypeDTO> {

    private static final long serialVersionUID = 1L;

    @Version
    private Long version;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long pk;

    @XmlElement
    @JsonProperty
    @Column(nullable = false, unique = true)
    private String type;
    
    @Column(nullable = false)
    private boolean active;

    QuestionType(final String type) {
        Preconditions.nonEmpty(type);
        this.type = type;
        this.active = true;
    }


    protected QuestionType() {
        // for ORM
    }

    public static QuestionType valueOf(final String type) {
        return new QuestionType(type);
    }

    /**
     * @return
     */
    public boolean isActive() {
        return this.active;
    }

    public boolean toggleState() {
        this.active = !this.active;
        return isActive();
    }
    
    @Override
    public String identity() {
        return this.type;
    }

    @Override
    public int hashCode() {
        return DomainEntities.hashCode(this);
    }

    @Override
    public boolean equals(final Object o) {
        return DomainEntities.areEqual(this, o);
    }

    @Override
    public boolean sameAs(final Object other) {
        return DomainEntities.areEqual(this, other);
    }

    /**
     * @return
     */
    @Override
    public QuestionTypeDTO toDTO() {
        return new QuestionTypeDTO(type);
    }

    @Override
    public String toString() {
        return identity();
    }
}
