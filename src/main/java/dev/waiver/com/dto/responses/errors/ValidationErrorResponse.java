package dev.waiver.com.dto.responses.errors;

import dev.waiver.com.dto.AbstractDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ValidationErrorResponse extends AbstractDTO {

    private String field;
    private String message;
}
