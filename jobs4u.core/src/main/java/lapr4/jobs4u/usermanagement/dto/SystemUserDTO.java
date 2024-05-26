package lapr4.jobs4u.usermanagement.dto;

import java.io.Serializable;

import eapli.framework.representations.dto.DTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@DTO
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SystemUserDTO implements Serializable {
    private String username;
    private String name;
    private String email;
    private String role;
}
