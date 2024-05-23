package lapr4.jobs4u.questionmanagement.domain;

import java.util.List;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lapr4.jobs4u.questionmanagement.dto.RequirementsQuestionDTO;

@XmlRootElement(name = "Questions")
public class RequirementQuestionWrapper {
    private List<RequirementsQuestionDTO> questions;

    @XmlElement(name = "Question")
    public List<RequirementsQuestionDTO> getQuestions() {
        return questions;
    }

    public void setQuestions(List<RequirementsQuestionDTO> questions) {
        this.questions = questions;
    }
}
