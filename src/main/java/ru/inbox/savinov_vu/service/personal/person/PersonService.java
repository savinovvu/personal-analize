package ru.inbox.savinov_vu.service.personal.person;

import org.springframework.data.repository.query.Param;
import ru.inbox.savinov_vu.model.personal.Group;
import ru.inbox.savinov_vu.model.personal.Person;

import java.util.List;

public interface PersonService {

    List<Person> getAllPersons();

    List<Person> getPersonWithGroup(Group group);


    void addPerson(Person person);

    void deletePerson(Person person);
}
