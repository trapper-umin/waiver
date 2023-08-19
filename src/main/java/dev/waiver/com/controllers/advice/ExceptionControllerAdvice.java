package dev.waiver.com.controllers.advice;

import dev.waiver.com.dto.responses.errors.SmallErrorMessage;
import dev.waiver.com.util.exception.NotFoundException;
import dev.waiver.com.util.response.ResponseWithStatusAndDate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.List;

@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(NotFoundException.class)
    private ResponseEntity<ResponseWithStatusAndDate<SmallErrorMessage>> handleException(NotFoundException e){

        ResponseWithStatusAndDate<SmallErrorMessage> response=new ResponseWithStatusAndDate<>(
                HttpStatus.NOT_FOUND,
                LocalDateTime.now(),
                List.of(new SmallErrorMessage(e.getMessage()))
        );

        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);

    }
}
