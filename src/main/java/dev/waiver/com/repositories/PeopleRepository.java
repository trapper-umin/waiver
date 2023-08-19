package dev.waiver.com.repositories;

import dev.waiver.com.models.Person;
import dev.waiver.com.repositories.common.CommonRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PeopleRepository extends CommonRepository<Person> {

    Optional<Person> findByUsername(String username);
}
