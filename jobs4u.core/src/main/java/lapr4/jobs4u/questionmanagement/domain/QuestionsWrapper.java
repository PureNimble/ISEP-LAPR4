package lapr4.jobs4u.questionmanagement.domain;

import java.util.List;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lapr4.jobs4u.questionmanagement.dto.QuestionDTO;

@XmlRootElement(name = "Questions")
public class QuestionsWrapper {
    private List<QuestionDTO> questions;

    @XmlElement(name = "Question")
    public List<QuestionDTO> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionDTO> questions) {
        this.questions = questions;
    }
}