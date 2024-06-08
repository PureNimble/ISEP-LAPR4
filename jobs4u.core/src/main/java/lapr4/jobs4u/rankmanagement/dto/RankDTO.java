package lapr4.jobs4u.rankmanagement.dto;

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
public class RankDTO {
    private String id;
    private String applicationCode;
    private String placement;
    private String candidateEmail;
    private String candidateName;
}
