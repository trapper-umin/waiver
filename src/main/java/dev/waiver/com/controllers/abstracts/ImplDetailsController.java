package dev.waiver.com.controllers.abstracts;

import dev.waiver.com.controllers.interfaces.IDetailsController;
import dev.waiver.com.dto.responses.DetailsDTOResp;
import dev.waiver.com.models.Details;
import dev.waiver.com.services.DetailsService;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public class ImplDetailsController implements IDetailsController {

    private final DetailsService detailsService;

    public ImplDetailsController(DetailsService detailsService) {
        this.detailsService = detailsService;
    }


    @Override
    public ResponseEntity<DetailsDTOResp> update(int id, Map<String, Object> updates) {
        return detailsService.updateViaPatch(id,updates);
    }
}
