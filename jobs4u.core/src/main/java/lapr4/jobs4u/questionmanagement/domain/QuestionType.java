package lapr4.jobs4u.questionmanagement.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.representations.dto.DTOable;
import eapli.framework.validations.Preconditions;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Version;
import lapr4.jobs4u.questionmanagement.dto.QuestionTypeDTO;

@Entity
public class QuestionType implements AggregateRoot<String>, DTOable<QuestionTypeDTO> {

    private static final long serialVersionUID = 1L;

    @Version
    private Long version;

    @EmbeddedId
    @Column(nullable = false)
    private String type;

    private boolean active;

    protected QuestionType() {
        // for ORM
    }

    public QuestionType(final String type) {
        Preconditions.nonEmpty(type);
        this.active = true;
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

    public boolean toogleState() {

        this.active = !this.active;
        return isActive();
    }

    @Override
    public boolean hasIdentity(final String type) {
        return type.equalsIgnoreCase(this.type);
    }

    @Override
    public String identity() {
        return this.type;
    }

    @Override
    public boolean sameAs(final Object other) {
        final QuestionType questionType = (QuestionType) other;
        return this.equals(questionType) && isActive() == questionType.isActive();
    }

    @Override
    public int hashCode() {
        return DomainEntities.hashCode(this);
    }

    @Override
    public boolean equals(final Object o) {
        return DomainEntities.areEqual(this, o);
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
