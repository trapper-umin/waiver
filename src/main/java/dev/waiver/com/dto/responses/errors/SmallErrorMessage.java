package dev.waiver.com.dto.responses.errors;

import dev.waiver.com.dto.AbstractDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SmallErrorMessage extends AbstractDTO {

    private String message;
}
