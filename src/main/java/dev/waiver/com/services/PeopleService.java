package dev.waiver.com.services;

import dev.waiver.com.dto.responses.PersonDTOResp;
import dev.waiver.com.services.DB.PeopleDBService;
import dev.waiver.com.services.mapper.Mapper;
import dev.waiver.com.util.response.ResponseWithStatusAndDate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PeopleService {

    private final PeopleDBService peopleDBService;
    private final Mapper mapper;

    public PeopleService(PeopleDBService peopleDBService, Mapper mapper) {
        this.peopleDBService = peopleDBService;
        this.mapper = mapper;
    }

    public ResponseEntity<ResponseWithStatusAndDate<PersonDTOResp>> get(int id){
        ResponseWithStatusAndDate<PersonDTOResp> response=new ResponseWithStatusAndDate<>(
                HttpStatus.OK,
                LocalDateTime.now(),
                List.of(mapper.map(peopleDBService.get(id),PersonDTOResp.class))
        );

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
