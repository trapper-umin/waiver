package dev.waiver.com.services;

import dev.waiver.com.models.Person;
import dev.waiver.com.repositories.PeopleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class PeopleValidationService {

    private final PeopleRepository peopleRepository;

    public PeopleValidationService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public Optional<Person> getByUsername(String username){
        return peopleRepository.findByUsername(username);
    }
}
