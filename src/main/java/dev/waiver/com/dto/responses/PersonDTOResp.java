package dev.waiver.com.dto.responses;

import dev.waiver.com.dto.AbstractDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonDTOResp extends AbstractDTO {

    private String username;

    private String password;
}
