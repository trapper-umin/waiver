package dev.waiver.com.services;

import dev.waiver.com.dto.requests.PersonDTOForPatchReqst;
import dev.waiver.com.dto.requests.PersonDTOReqst;
import dev.waiver.com.dto.responses.PersonDTOResp;
import dev.waiver.com.dto.responses.errors.ValidationErrorResponse;
import dev.waiver.com.models.Person;
import dev.waiver.com.services.DB.PeopleDBService;
import dev.waiver.com.services.mapper.Mapper;
import dev.waiver.com.util.exception.NotValidException;
import dev.waiver.com.util.response.ResponseWithStatusAndDate;
import org.modelmapper.Conditions;
import dev.waiver.com.util.validation.PersonAllFieldsValidation;
import dev.waiver.com.util.validation.PersonUsernameUniqueValidation;
import org.modelmapper.ModelMapper;
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
    private final ModelMapper modelMapper;
    private final PersonUsernameUniqueValidation personUsernameUniqueValidation;
    private final PersonAllFieldsValidation personAllFieldsValidation;


    public PeopleService(PeopleDBService peopleDBService,
                         Mapper mapper,
                         PersonUsernameUniqueValidation personUsernameUniqueValidation,
                         ModelMapper modelMapper,
                         PersonAllFieldsValidation personAllFieldsValidation) {

        this.peopleDBService = peopleDBService;
        this.mapper = mapper;
        this.modelMapper = modelMapper;
        this.personUsernameUniqueValidation = personUsernameUniqueValidation;
        this.personAllFieldsValidation = personAllFieldsValidation;
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
        validation(bindingResult);

        peopleDBService.create(mapper.map(personDTOReqst,Person.class));

        ResponseWithStatusAndDate<PersonDTOResp>response=new ResponseWithStatusAndDate<>(
                HttpStatus.OK,
                LocalDateTime.now(),
                List.of(mapper.map(personDTOReqst,PersonDTOResp.class))
        );

        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    public ResponseEntity<ResponseWithStatusAndDate<PersonDTOResp>>updatePutMethod(int id,PersonDTOReqst personDTOReqst,BindingResult bindingResult){
        personUsernameUniqueValidation.validate(personDTOReqst,bindingResult);
        validation(bindingResult);

        peopleDBService.update(id,mapper.map(personDTOReqst,Person.class));

        ResponseWithStatusAndDate<PersonDTOResp>response=new ResponseWithStatusAndDate<>(
                HttpStatus.OK,
                LocalDateTime.now(),
                List.of(mapper.map(personDTOReqst,PersonDTOResp.class))
        );

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public ResponseEntity<ResponseWithStatusAndDate<PersonDTOResp>>updatePatchMethod(int id, PersonDTOForPatchReqst personDTOForPatchReqst,
                                                                                     BindingResult bindingResult){
        Person person=peopleDBService.get(id);

        modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
        modelMapper.map(personDTOForPatchReqst,person);
        personAllFieldsValidation.validate(person,bindingResult);
        validation(bindingResult);
        peopleDBService.updatePatchMethod(person);

        ResponseWithStatusAndDate<PersonDTOResp>response=new ResponseWithStatusAndDate<>(
                HttpStatus.OK,
                LocalDateTime.now(),
                List.of(mapper.map(person,PersonDTOResp.class))
        );
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    private void validation(BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            List<ValidationErrorResponse> errors=new ArrayList<>();
            List<FieldError>fieldErrors=bindingResult.getFieldErrors();
            for (FieldError error : fieldErrors)
                errors.add(new ValidationErrorResponse(error.getField(),error.getDefaultMessage()));
            throw new NotValidException(errors);
        }
    }

}
