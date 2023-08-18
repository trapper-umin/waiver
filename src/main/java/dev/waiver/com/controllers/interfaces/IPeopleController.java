package dev.waiver.com.controllers.interfaces;

import dev.waiver.com.dto.responses.PersonDTOResp;
import dev.waiver.com.util.response.ResponseWithStatusAndDate;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface IPeopleController {

    @Operation(summary = "get user by ID")
    @GetMapping("/{id}")
    ResponseEntity<ResponseWithStatusAndDate<PersonDTOResp>> get(@Parameter(description = "user's ID") @PathVariable("id") int id);
}
