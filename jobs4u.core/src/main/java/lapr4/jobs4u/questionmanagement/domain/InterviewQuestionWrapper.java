package lapr4.jobs4u.questionmanagement.domain;

import java.util.List;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lapr4.jobs4u.questionmanagement.dto.InterviewQuestionDTO;

@XmlRootElement(name = "Questions")
public class InterviewQuestionWrapper {
    private List<InterviewQuestionDTO> questions;

    @XmlElement(name = "Question")
    public List<InterviewQuestionDTO> getQuestions() {
        return questions;
    }

    public void setQuestions(List<InterviewQuestionDTO> questions) {
        this.questions = questions;
    }
}