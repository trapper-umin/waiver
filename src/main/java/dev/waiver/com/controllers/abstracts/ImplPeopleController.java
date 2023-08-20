package dev.waiver.com.controllers.abstracts;

import dev.waiver.com.controllers.interfaces.IPeopleController;
import dev.waiver.com.dto.requests.PersonDTOReqst;
import dev.waiver.com.dto.responses.PersonDTOResp;
import dev.waiver.com.services.PeopleService;
import dev.waiver.com.util.response.ResponseWithStatusAndDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import java.util.Map;

public class ImplPeopleController implements IPeopleController {

    private final PeopleService peopleService;

    @Autowired
    public ImplPeopleController(PeopleService peopleService){
        this.peopleService=peopleService;
    }

    @Override
    public ResponseEntity<ResponseWithStatusAndDate<PersonDTOResp>> get(int id) {
        return peopleService.get(id);
    }

    @Override
    public ResponseEntity<ResponseWithStatusAndDate<PersonDTOResp>> getAll() {
        return peopleService.getAll();
    }

    @Override
    public ResponseEntity<ResponseWithStatusAndDate<PersonDTOResp>> create(
            PersonDTOReqst personDTOReqst, BindingResult bindingResult) {
        return peopleService.create(personDTOReqst,bindingResult);
    }

    @Override
    public ResponseEntity<ResponseWithStatusAndDate<PersonDTOResp>> updatePutMethod(
            int id, PersonDTOReqst personDTOReqst, BindingResult bindingResult) {
        return peopleService.updatePutMethod(id,personDTOReqst,bindingResult);
    }

    @Override
    public ResponseEntity<ResponseWithStatusAndDate<PersonDTOResp>> updatePatchMethod(
            int id, Map<String,Object> updates, BindingResult bindingResult) {
        return peopleService.updatePatchMethod(id,updates, bindingResult);
    }

    @Override
    public HttpStatus delete(int id) {
        return null;
    }
}
