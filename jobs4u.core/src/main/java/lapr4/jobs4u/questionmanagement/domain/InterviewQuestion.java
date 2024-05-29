package lapr4.jobs4u.questionmanagement.domain;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;
import lapr4.jobs4u.integration.questions.importer.domain.QuestionImporterPlugin;
import lapr4.jobs4u.questionmanagement.dto.InterviewQuestionDTO;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.representations.dto.DTOable;
import eapli.framework.validations.Preconditions;

/**
 * @author 2DI2
 */
@XmlRootElement(name = "InterviewQuestion")
@Entity
@Table(name = "T_INTERVIEW_QUESTION")
public class InterviewQuestion implements AggregateRoot<Long>, DTOable<InterviewQuestionDTO> {

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
    private Cotation cotation;

    @XmlElement
    @JsonProperty
    private CotationType cotationType;

    @XmlElement
    @JsonProperty
    @Column(nullable = false)
    private QuestionBody body;

    @XmlElementWrapper(name = "possibleAnswersList")
    @XmlElement(name = "possibleAnswers")
    @JsonProperty
    @CollectionTable(name = "T_INTERVIEW_QUESTION_POSSIBLE_ANSWERS")
    @ElementCollection
    private List<InterviewAnswer> possibleAnswers;

    @ManyToOne
    @JoinColumn(name = "plugin")
    private QuestionImporterPlugin importerPlugin;

    InterviewQuestion(final QuestionType type, final Cotation cotation, final CotationType cotationType,
            final QuestionBody body, final List<InterviewAnswer> possibleAnswers,
            final QuestionImporterPlugin importerPlugin) {
        Preconditions.noneNull(new Object[] { type, body, possibleAnswers, importerPlugin });
        this.type = type;
        this.body = body;
        this.possibleAnswers = possibleAnswers;
        this.importerPlugin = importerPlugin;
        this.cotation = cotation;
        this.cotationType = cotationType;
    }

    protected InterviewQuestion() {
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

    public QuestionImporterPlugin importerPlugin() {
        return this.importerPlugin;
    }

    public QuestionType questionType() {
        return this.type;
    }

    public Cotation cotation() {
        return this.cotation;
    }

    public CotationType cotationType() {
        return this.cotationType;
    }

    public QuestionBody questionBody() {
        return this.body;
    }

    public List<InterviewAnswer> possibleAnswers() {
        return this.possibleAnswers;
    }

    @Override
    public String toString() {
        return body.toString();
    }

    @Override
    public InterviewQuestionDTO toDTO() {
        return new InterviewQuestionDTO(this.type.toString(), this.cotation.toString(), this.cotationType.toString(),
                this.body.toString(), this.possibleAnswers,
                this.importerPlugin);
    }
}