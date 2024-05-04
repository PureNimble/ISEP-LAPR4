package lapr4.jobs4u.questionmanagement.dto;

import java.util.List;

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
@XmlRootElement(name = "Question")
public class QuestionDTO {

    @XmlElement
    private String type;

    @XmlElement
    private String body;

    @XmlElementWrapper(name = "possibleAnswersList")
    @XmlElement(name = "possibleAnswers")
    private List<Answer> possibleAnswers;

    private String questionImporterPlugin;
}
