package dev.waiver.com.services.DB;

import dev.waiver.com.common.Role;
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
        List<Person> people=peopleRepository.findAll();
        if(people.isEmpty())
            throw new NotFoundException("Database is empty");
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

    }

    @Override
    @Transactional
    public void delete(int id) {
        peopleRepository.findById(id).orElseThrow(()->new NotFoundException("user with ID "+id+" not found"));
        peopleRepository.deleteById(id);
    }
}