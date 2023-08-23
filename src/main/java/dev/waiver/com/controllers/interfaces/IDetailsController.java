package dev.waiver.com.controllers.interfaces;

import dev.waiver.com.dto.responses.DetailsDTOResp;
import dev.waiver.com.models.Details;
import io.swagger.v3.oas.annotations.Parameter;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;


public interface IDetailsController {

    @PatchMapping("/{user_id}")
    ResponseEntity<DetailsDTOResp>update(
            @Parameter(description = "user's ID") @PathVariable("user_id") int id,
            @RequestBody Map<String,Object> updates);
}
