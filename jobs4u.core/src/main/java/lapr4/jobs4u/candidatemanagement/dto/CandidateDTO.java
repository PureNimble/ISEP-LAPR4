package lapr4.jobs4u.candidatemanagement.dto;

import eapli.framework.representations.dto.DTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@DTO
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidateDTO {
    private String email;
    private String name;
    private String phoneNumber;
}
