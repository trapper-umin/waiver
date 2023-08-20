package dev.waiver.com.util.validation;

import dev.waiver.com.models.Person;
import dev.waiver.com.services.PeopleValidationService;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class PersonAllValidation implements Validator {

    private final PeopleValidationService peopleValidationService;

    public PersonAllValidation(PeopleValidationService peopleValidationService) {
        this.peopleValidationService = peopleValidationService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(Person.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Person person=(Person) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "","username should be not blank");


    }
}
