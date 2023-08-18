package dev.waiver.com.repositories;

import dev.waiver.com.models.Person;
import dev.waiver.com.repositories.common.CommonRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeopleRepository extends CommonRepository<Person> {
}
