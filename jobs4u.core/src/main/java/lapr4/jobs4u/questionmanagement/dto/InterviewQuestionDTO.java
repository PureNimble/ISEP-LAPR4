package lapr4.jobs4u.questionmanagement.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import eapli.framework.representations.dto.DTO;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;
import lapr4.jobs4u.questionmanagement.domain.Answer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@DTO
@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement(name = "InterviewQuestion")
public class InterviewQuestionDTO {

    @XmlElement
    @JsonProperty
    private String type;

    @XmlElement
    @JsonProperty
    private String cotation;

    @XmlElement
    @JsonProperty
    private String cotationType;

    @XmlElement
    @JsonProperty
    private String body;

    @XmlElementWrapper(name = "possibleAnswersList")
    @JsonProperty()
    @XmlElement(name = "possibleAnswers")
    private List<Answer> possibleAnswers;

    private String questionImporterPlugin;
}
