package dev.waiver.com.services;

import dev.waiver.com.dto.requests.PersonDTOReqst;
import dev.waiver.com.dto.responses.PersonDTOResp;
import dev.waiver.com.dto.responses.errors.ValidationErrorResponse;
import dev.waiver.com.models.Person;
import dev.waiver.com.services.DB.PeopleDBService;
import dev.waiver.com.services.mapper.Mapper;
import dev.waiver.com.util.exception.NotValidException;
import dev.waiver.com.util.response.ResponseWithStatusAndDate;
import dev.waiver.com.util.validation.PersonUsernameUniqueValidation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class PeopleService {

    private final PeopleDBService peopleDBService;
    private final Mapper mapper;
    private final PersonUsernameUniqueValidation personUsernameUniqueValidation;

    public PeopleService(PeopleDBService peopleDBService,
                         Mapper mapper,
                         PersonUsernameUniqueValidation personUsernameUniqueValidation) {
        this.peopleDBService = peopleDBService;
        this.mapper = mapper;
        this.personUsernameUniqueValidation = personUsernameUniqueValidation;
    }

    public ResponseEntity<ResponseWithStatusAndDate<PersonDTOResp>> get(int id){
        ResponseWithStatusAndDate<PersonDTOResp> response=new ResponseWithStatusAndDate<>(
                HttpStatus.OK,
                LocalDateTime.now(),
                List.of(mapper.map(peopleDBService.get(id),PersonDTOResp.class))
        );

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public ResponseEntity<ResponseWithStatusAndDate<PersonDTOResp>>getAll(){
        ResponseWithStatusAndDate<PersonDTOResp>response=new ResponseWithStatusAndDate<>(
                HttpStatus.OK,
                LocalDateTime.now(),
                iterateByArrayOfPeopleAndConvertToDTO(peopleDBService.getAll())
        );

        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    public List<PersonDTOResp> iterateByArrayOfPeopleAndConvertToDTO(List<Person> people){
        List<PersonDTOResp> peopleDTO=new ArrayList<>();
        for(Person person : people)
            peopleDTO.add(mapper.map(person,PersonDTOResp.class));
        return peopleDTO;
    }

    public ResponseEntity<ResponseWithStatusAndDate<PersonDTOResp>>create(PersonDTOReqst personDTOReqst, BindingResult bindingResult){
        personUsernameUniqueValidation.validate(personDTOReqst,bindingResult);
        if(bindingResult.hasErrors()){
            List<ValidationErrorResponse> errors=new ArrayList<>();
            List<FieldError>fieldErrors=bindingResult.getFieldErrors();
            for (FieldError error : fieldErrors)
                errors.add(new ValidationErrorResponse(error.getField(),error.getDefaultMessage()));
            throw new NotValidException(errors);
        }

        peopleDBService.create(mapper.map(personDTOReqst,Person.class));

        ResponseWithStatusAndDate<PersonDTOResp>response=new ResponseWithStatusAndDate<>(
                HttpStatus.OK,
                LocalDateTime.now(),
                List.of(mapper.map(personDTOReqst,PersonDTOResp.class))
        );

        return new ResponseEntity<>(response,HttpStatus.OK);
    }

}
