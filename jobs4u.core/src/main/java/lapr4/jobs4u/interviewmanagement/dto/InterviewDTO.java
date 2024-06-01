package lapr4.jobs4u.interviewmanagement.dto;

import eapli.framework.representations.dto.DTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 2DI2
 */
@DTO
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InterviewDTO {

    private String applicationCode;
    private String candidateEmail;
    private String grade;
}
