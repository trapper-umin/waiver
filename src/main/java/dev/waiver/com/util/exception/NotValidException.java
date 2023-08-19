package dev.waiver.com.util.exception;

import dev.waiver.com.dto.responses.errors.ValidationErrorResponse;
import lombok.Getter;

import java.util.List;

@Getter
public class NotValidException extends RuntimeException{

    List<ValidationErrorResponse>errors;
    public NotValidException(List<ValidationErrorResponse>errors){
        this.errors=errors;
    }
}
