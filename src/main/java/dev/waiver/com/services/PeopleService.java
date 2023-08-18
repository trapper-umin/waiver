package dev.waiver.com.services;

import dev.waiver.com.dto.responses.PersonDTOResp;
import dev.waiver.com.services.DB.PeopleDBService;
import dev.waiver.com.services.mapper.ConvertTo;
import dev.waiver.com.util.response.ResponseWithStatusAndDate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PeopleService {

    private final PeopleDBService peopleDBService;
    private final ConvertTo convertTo;

    public PeopleService(PeopleDBService peopleDBService, ConvertTo convertTo) {
        this.peopleDBService = peopleDBService;
        this.convertTo = convertTo;
    }

    public ResponseEntity<ResponseWithStatusAndDate<PersonDTOResp>> get(int id){
        ResponseWithStatusAndDate<PersonDTOResp> response=new ResponseWithStatusAndDate<>(
                HttpStatus.OK,
                LocalDateTime.now(),
                List.of(convertTo.personDTOResp(peopleDBService.get(id)))
        );

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
