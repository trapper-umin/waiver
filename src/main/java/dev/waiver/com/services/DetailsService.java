package dev.waiver.com.services;

import dev.waiver.com.dto.responses.DetailsDTOResp;
import dev.waiver.com.models.Details;
import dev.waiver.com.models.Person;
import dev.waiver.com.services.DB.DetailsDBService;
import dev.waiver.com.services.DB.PeopleDBService;
import dev.waiver.com.util.exception.ForbiddenFieldException;
import org.modelmapper.Condition;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DetailsService {

    private final ModelMapper modelMapper;
    private final PeopleDBService peopleDBService;

    public DetailsService(ModelMapper modelMapper,
                          PeopleDBService peopleDBService) {
        this.modelMapper = modelMapper;
        this.peopleDBService = peopleDBService;
    }

    //person_id
    public ResponseEntity<DetailsDTOResp>updateViaPatch(int id, Map<String,Object>updates){

        List<String> forbiddenFields = updates.keySet().stream()
                .filter(key -> {
                    String[] forbiddenKeys = {"points", "missedTasks", "completedTasks", "createdAt", "updatedAt"};
                    return Arrays.asList(forbiddenKeys).contains(key);
                })
                .collect(Collectors.toList());

        if (!forbiddenFields.isEmpty()) {
            throw new ForbiddenFieldException(forbiddenFields);
        }

        Person person=peopleDBService.get(id);
        Details details=person.getDetails();

        modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
        modelMapper.map(updates,details);

        person.setDetails(details);
        peopleDBService.updatePatchMethod(person);

        return new ResponseEntity<>(modelMapper.map(details,DetailsDTOResp.class), HttpStatus.OK);
    }

    //TODO validation
    public void validation(Map<String,Object> updates){
        //проверяем то ли это поле
        //проверяем условия на поле
        //не валид добавляем в List<ValidationErrorResponse> новый объект ValidationErrorResponse с поле, ошибка
        //если мапа с ошибками не пуста выбрасываем исключение NotValidException
    }
}
