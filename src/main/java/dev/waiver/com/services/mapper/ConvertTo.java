package dev.waiver.com.services.mapper;

import dev.waiver.com.dto.responses.PersonDTOResp;
import dev.waiver.com.models.Person;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ConvertTo {

    private final ModelMapper modelMapper;

    public ConvertTo(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public PersonDTOResp personDTOResp(Person person){
        return modelMapper.map(person, PersonDTOResp.class);
    }
}
