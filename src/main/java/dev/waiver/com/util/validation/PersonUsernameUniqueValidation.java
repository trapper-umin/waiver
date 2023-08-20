package dev.waiver.com.util.validation;

import dev.waiver.com.dto.requests.PersonDTOReqst;
import dev.waiver.com.services.PeopleValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class PersonUsernameUniqueValidation implements Validator {

    private final PeopleValidationService peopleValidationService;

    @Autowired
    public PersonUsernameUniqueValidation(PeopleValidationService peopleValidationService) {
        this.peopleValidationService = peopleValidationService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(PersonDTOReqst.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        PersonDTOReqst person=(PersonDTOReqst) target;

        if(peopleValidationService.getByUsername(person.getUsername()).isPresent())
            errors.rejectValue("username","","username should be unique");
    }
}
