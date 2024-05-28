package lapr4.jobs4u.questionmanagement.domain;

import java.util.List;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

/**
 * @author 2DI2
 */
@XmlRootElement(name = "Questions")
public class QuestionWrapper<T> {
    private List<T> questions;

    @XmlElement(name = "Question")
    public List<T> getQuestions() {
        return questions;
    }

    public void setQuestions(List<T> questions) {
        this.questions = questions;
    }
}