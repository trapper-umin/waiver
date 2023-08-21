package dev.waiver.com.util.validation;

import dev.waiver.com.models.Person;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class PersonAllFieldsValidation implements Validator {


    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(Person.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Person person=(Person) target;

        /*
        UNIQUE DOESN'T EXIST
        Если приходит только password без usename, получается что в модели остается старый username
        Таким образом при сравнении username получаетсяс ошибка UNIQUE
        */

        int usernameLength=person.getUsername().length();
        if(usernameLength<=3 || usernameLength>=255)
            errors.rejectValue("username","","username size should be between 4 and 254");
        if(person.getUsername().isEmpty())
            errors.rejectValue("username","","username should be not blank");

        int passwordLength=person.getPassword().length();
        if(passwordLength<=3 || passwordLength>=255)
            errors.rejectValue("password","","password size should be between 4 and 254");
        if(person.getPassword().isEmpty())
            errors.rejectValue("password","","password should be not blank");
    }
}
