package dev.waiver.com.dto.requests;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonDTOReqst {

    @NotBlank(message = "username should be not blank")
    @Size(min = 3, max = 255, message = "username size should be between 3 and 255")
    //UNIQUE
    private String username;

    @NotBlank(message = "password should be not blank")
    @Size(min=3,max = 255,message = "password size should be between 3 and 255")
    private String password;
}
