package lapr4.jobs4u.applicationmanagement.dto;

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
public class ApplicationDTO {

    private String applicationCode;
    private String candidate;

}
