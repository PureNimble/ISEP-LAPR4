package lapr4.jobs4u.questionmanagement.domain;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;
import lapr4.jobs4u.questionmanagement.dto.RequirementsQuestionDTO;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.representations.dto.DTOable;
import eapli.framework.validations.Preconditions;

@XmlRootElement(name = "RequirementsQuestion")
@Entity
@Table(name = "T_REQUIREMENTS_QUESTION")
public class RequirementsQuestion implements AggregateRoot<Long>, DTOable<RequirementsQuestionDTO> {

    private static final long serialVersionUID = 1L;

    @Version
    private Long version;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "QUESTION_ID")
    private Long id;

    @XmlElement
    @JsonProperty
    @Column(nullable = false)
    private QuestionBody body;

    @XmlElementWrapper(name = "possibleAnswersList")
    @XmlElement(name = "possibleAnswers")
    @JsonProperty
    @CollectionTable(name = "T_REQUIREMENTS_QUESTION_POSSIBLE_ANSWERS")
    @ElementCollection
    private List<Answer> possibleAnswers;

    @Column(nullable = false)
    private String importerPlugin;

    RequirementsQuestion(final QuestionBody body, final List<Answer> possibleAnswers, final String importerPlugin) {
        Preconditions.noneNull(new Object[] { body, possibleAnswers, importerPlugin });
        this.body = body;
        this.possibleAnswers = possibleAnswers;
        this.importerPlugin = importerPlugin;
    }

    protected RequirementsQuestion() {
        // for ORM only
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

    public QuestionBody questionBody() {
        return this.body;
    }

    public List<Answer> possibleAnswers() {
        return this.possibleAnswers;
    }

    @Override
    public String toString() {
        return body.toString();
    }

    @Override
    public RequirementsQuestionDTO toDTO() {
        return new RequirementsQuestionDTO(this.body.toString(), this.possibleAnswers, this.importerPlugin.toString());
    }
}