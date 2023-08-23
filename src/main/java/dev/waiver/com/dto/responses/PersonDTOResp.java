package dev.waiver.com.dto.responses;

import dev.waiver.com.dto.AbstractDTO;
import dev.waiver.com.models.Details;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PersonDTOResp extends AbstractDTO {

    private String username;

    private String password;

    private DetailsDTOResp details;
}
