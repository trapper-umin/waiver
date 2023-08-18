package dev.waiver.com.services.DB;

import dev.waiver.com.models.Person;
import dev.waiver.com.repositories.PeopleRepository;
import dev.waiver.com.services.PeopleService;
import dev.waiver.com.services.common.CommonCRUDService;
import dev.waiver.com.util.exception.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class PeopleDBService implements CommonCRUDService<Person> {

    private final PeopleRepository peopleRepository;

    public PeopleDBService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    @Override
    public Person get(int id) {
        return peopleRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Person with ID " + id + " not found"));
    }


    @Override
    public List<Person> getAll() {
        return null;
    }

    @Override
    public void create(Person entity) {

    }

    @Override
    public void update(int id, Person entity) {

    }

    @Override
    public void delete(int id) {

    }
}
