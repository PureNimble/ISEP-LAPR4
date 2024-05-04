package lapr4.jobs4u.questionmanagement.domain;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;
import lapr4.jobs4u.questionmanagement.dto.QuestionDTO;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.representations.dto.DTOable;
import eapli.framework.validations.Preconditions;

@XmlRootElement(name = "Question")
@Entity
@Table(name = "T_QUESTION")
public class Question implements AggregateRoot<Long>, DTOable<QuestionDTO> {

    private static final long serialVersionUID = 1L;

    @Version
    private Long version;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "QUESTION_ID")
    private Long id;

    @XmlElement
    @JsonProperty
    @ManyToOne
    private QuestionType type;

    @XmlElement
    @JsonProperty
    @Column(nullable = false)
    private QuestionBody body;

    @XmlElementWrapper(name = "possibleAnswersList")
    @XmlElement(name = "possibleAnswers")
    @JsonProperty
    @ElementCollection
    private List<Answer> possibleAnswers;

    @Column(nullable = false)
    private boolean active;

    @Column(nullable = false)
    private String importerPlugin;

    Question(final QuestionType type, final QuestionBody body, final List<Answer> possibleAnswers,
            final String importerPlugin) {
        Preconditions.noneNull(new Object[] { type, body, possibleAnswers, importerPlugin });
        this.type = type;
        this.body = body;
        this.possibleAnswers = possibleAnswers;
        this.active = true;
        this.importerPlugin = importerPlugin;
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

    public String importerPlugin() {
        return this.importerPlugin;
    }

    @Override
    public String toString() {
        return id.toString() + " - " + body.toString();
    }

    @Override
    public QuestionDTO toDTO() {
        return new QuestionDTO(this.type.toString(), this.body.toString(), this.possibleAnswers,
                this.importerPlugin.toString());
    }
}