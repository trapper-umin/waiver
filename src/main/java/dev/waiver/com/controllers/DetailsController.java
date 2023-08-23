package dev.waiver.com.controllers;

import dev.waiver.com.controllers.abstracts.ImplDetailsController;
import dev.waiver.com.services.DetailsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1.0/details")
public class DetailsController extends ImplDetailsController {

    public DetailsController(DetailsService detailsService) {
        super(detailsService);
    }
}
