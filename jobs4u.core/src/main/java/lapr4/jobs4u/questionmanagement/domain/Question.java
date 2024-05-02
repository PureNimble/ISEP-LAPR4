package lapr4.jobs4u.questionmanagement.domain;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lapr4.jobs4u.questionmanagement.dto.QuestionDTO;

import java.util.List;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.representations.dto.DTOable;
import eapli.framework.validations.Preconditions;

@Entity
@Table(name = "T_QUESTION")
public class Question implements AggregateRoot<Long>, DTOable<QuestionDTO> {

    private static final long serialVersionUID = 1L;

    @Version
    private Long version;

    @EmbeddedId
    @GeneratedValue
    @Column(name="QUESTION_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "QUESTION_TYPE_ID")
    private QuestionType type;

    @Column(nullable = false)
    private QuestionBody body;

    @ElementCollection
    private List<Answer> possibleAnswers;

    @Column(nullable = false)
    private boolean active;

    Question(final QuestionType type, final QuestionBody body, final List<Answer> possibleAnswers) {
        Preconditions.noneNull(new Object[] {type, body, possibleAnswers});
        this.type = type;
        this.body = body;
        this.possibleAnswers = possibleAnswers;
        this.active = true;
    }

    protected Question() {
        // for ORM only
    }

    /**
     * @return
     */
    public boolean isActive() {
        return this.active;
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

    public Long ofIdentity() {
        return identity();
    }

    @Override
    public Long identity() {
        return this.id;
    }

    @Override
    public String toString() {
        return id.toString() + " - " + body.toString();
    }

    @Override
    public QuestionDTO toDTO() {
        return new QuestionDTO(this.type.identity(), this.body.toString(), this.possibleAnswers);
    }
}