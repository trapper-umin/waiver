package dev.waiver.com.services.DB;

import dev.waiver.com.common.Role;
import dev.waiver.com.models.Details;
import dev.waiver.com.models.Person;
import dev.waiver.com.repositories.DetailsRepository;
import dev.waiver.com.repositories.PeopleRepository;
import dev.waiver.com.services.common.CommonCRUDService;
import dev.waiver.com.util.exception.NotFoundException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class PeopleDBService implements CommonCRUDService<Person> {

    private final PeopleRepository peopleRepository;
    private final DetailsRepository detailsRepository;

    public PeopleDBService(PeopleRepository peopleRepository, DetailsRepository detailsRepository) {
        this.peopleRepository = peopleRepository;
        this.detailsRepository = detailsRepository;
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

    public List<Person>getAll(int page,int size){
        List<Person>people=peopleRepository.findAll(PageRequest.of(page,size)).getContent();
        if(people.isEmpty())
            throw new NotFoundException("there were no users on the PAGE "+page+" with the SIZE "+size);
        return people;
    }

    public List<Person>getAll(String fieldName){
        List<Person>people=peopleRepository.findAll(Sort.by(fieldName));
        if(people.isEmpty())
            throw new NotFoundException("database is empty");
        return people;
    }

    public List<Person>getAll(String fieldName, int page,int size){
        List<Person>people=peopleRepository.findAll(PageRequest.of(page,size,Sort.by(fieldName))).getContent();
        if(people.isEmpty())
            throw new NotFoundException("there were no users on the PAGE "+page+" with the SIZE "+size+ "and sorting by FIELD "+fieldName);
        return people;
    }

    public List<Person>getAllWhoseUsernameStartingWith(String search){
        List<Person>people=peopleRepository.findByUsernameStartingWith(search);
        if(people.isEmpty())
            throw new NotFoundException("there are no users whose username STARTING WITH "+search);
        return people;
    }

    @Override
    @Transactional
    public Person create(Person entity) {
        entity.setRole(Role.USER);

        Details details=new Details(
                entity,
                0,
                0,
                0,
                LocalDateTime.now(),
                LocalDateTime.now()
        );
        entity.setDetails(details);

        detailsRepository.save(details);
        peopleRepository.save(entity);
        return entity;
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

    @Transactional
    public void updatePatchMethod(Person person){
        peopleRepository.save(person);
    }

    @Override
    @Transactional
    public void delete(int id) {
        peopleRepository.findById(id).orElseThrow(()->new NotFoundException("user with ID "+id+" not found"));
        peopleRepository.deleteById(id);
    }
}