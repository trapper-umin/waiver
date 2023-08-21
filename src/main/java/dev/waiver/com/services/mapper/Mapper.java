package dev.waiver.com.services.mapper;

import dev.waiver.com.dto.responses.PersonDTOResp;
import dev.waiver.com.models.Person;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class Mapper {

    private final ModelMapper modelMapper;

    public Mapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public PersonDTOResp personDTOResp(Person person){
        return modelMapper.map(person, PersonDTOResp.class);
    }

    public <S, D> D map(S source, Class<D> destinationType) {
        return modelMapper.map(source, destinationType);
    }
}
