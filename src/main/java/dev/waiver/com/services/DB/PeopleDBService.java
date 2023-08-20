package dev.waiver.com.services.DB;

import dev.waiver.com.common.Role;
import dev.waiver.com.models.Person;
import dev.waiver.com.repositories.PeopleRepository;
import dev.waiver.com.services.common.CommonCRUDService;
import dev.waiver.com.services.mapper.Mapper;
import dev.waiver.com.util.exception.NotFoundException;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.Map;

@Service
@Transactional(readOnly = true)
public class PeopleDBService implements CommonCRUDService<Person> {

    private final PeopleRepository peopleRepository;
    private final ModelMapper modelMapper;

    public PeopleDBService(PeopleRepository peopleRepository,
                           ModelMapper modelMapper) {
        this.peopleRepository = peopleRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Person get(int id) {
        return peopleRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("user with ID " + id + " not found"));
    }

    @Override
    public List<Person> getAll() {
        List<Person> people=peopleRepository.findAll();
        if(people.isEmpty())
            throw new NotFoundException("database is empty");
        return people;
    }

    @Override
    @Transactional
    public void create(Person entity) {
        entity.setRole(Role.USER);
        peopleRepository.save(entity);
    }

    @Override
    @Transactional
    public void update(int id, Person entity) {
         Person person=peopleRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("user with ID "+id+" not found"));

         entity.setId(id);
         entity.setRole(person.getRole());

         peopleRepository.save(entity);
    }


    //TODO
    @Transactional
    public Person updatePatchMethod(Person person){



        return person;
    }

    @Override
    @Transactional
    public void delete(int id) {
        peopleRepository.findById(id).orElseThrow(()->new NotFoundException("user with ID "+id+" not found"));
        peopleRepository.deleteById(id);
    }


}