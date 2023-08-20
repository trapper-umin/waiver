package dev.waiver.com.controllers.interfaces;

import dev.waiver.com.dto.requests.PersonDTOReqst;
import dev.waiver.com.dto.responses.PersonDTOResp;
import dev.waiver.com.util.response.ResponseWithStatusAndDate;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

public interface IPeopleController {

    @Operation(summary = "get user by ID")
    @GetMapping("/{id}")
    ResponseEntity<ResponseWithStatusAndDate<PersonDTOResp>> get(
            @Parameter(description = "user's ID") @PathVariable("id") int id);

    @Operation(summary = "get user's array")
    @GetMapping
    ResponseEntity<ResponseWithStatusAndDate<PersonDTOResp>> getAll();

    @Operation(summary = "create user")
    @PostMapping
    ResponseEntity<ResponseWithStatusAndDate<PersonDTOResp>>create(
            @RequestBody @Valid PersonDTOReqst personDTOReqst, BindingResult bindingResult);

    @Operation(summary = "full user update")
    @PutMapping("/{id}")
    ResponseEntity<ResponseWithStatusAndDate<PersonDTOResp>>updatePutMethod(
            @Parameter(description = "user's ID") @PathVariable("id") int id,
            @RequestBody @Valid PersonDTOReqst personDTOReqst, BindingResult bindingResult);

    @Operation(summary = "partial user update")
    @PatchMapping("/{id}")
    ResponseEntity<ResponseWithStatusAndDate<PersonDTOResp>>updatePatchMethod(
            @Parameter(description = "user's ID") @PathVariable("id") int id,
            @RequestBody Map<String, Object>updates, BindingResult bindingResult);

    @Operation(summary = "delete user")
    @DeleteMapping("/{id}")
    HttpStatus delete(
            @Parameter(description = "user's ID") @PathVariable("id") int id);
}
