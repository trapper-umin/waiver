package dev.waiver.com.controllers.abstracts;

import dev.waiver.com.controllers.interfaces.IPeopleController;
import dev.waiver.com.dto.responses.PersonDTOResp;
import dev.waiver.com.services.PeopleService;
import dev.waiver.com.util.response.ResponseWithStatusAndDate;
import org.springframework.http.ResponseEntity;

public abstract class ImplPeopleController implements IPeopleController {

    private final PeopleService peopleService;

    public ImplPeopleController(PeopleService peopleService){
        this.peopleService=peopleService;
    }

    @Override
    public ResponseEntity<ResponseWithStatusAndDate<PersonDTOResp>> get(int id) {
        return peopleService.get(id);
    }
}
