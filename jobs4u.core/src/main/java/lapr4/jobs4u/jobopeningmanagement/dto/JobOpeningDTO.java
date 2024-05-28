package lapr4.jobs4u.jobopeningmanagement.dto;

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
public class JobOpeningDTO {

    private String jobReference;
    private String titleOrFunction;
    private String contractType;
    private String mode;
    private String address;
    private String customerCode;
    private String customerName;
    private String jobDescription;
    
}
