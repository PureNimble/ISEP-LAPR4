package lapr4.jobs4u.questionmanagement.dto;

import java.util.List;

import eapli.framework.representations.dto.DTO;
import lapr4.jobs4u.questionmanagement.domain.Answer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@DTO
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionDTO {

    private String type;
    private String body;
    private List<Answer> possibleAnswers;

}
