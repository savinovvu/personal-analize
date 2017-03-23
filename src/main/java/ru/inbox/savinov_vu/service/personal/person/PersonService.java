package ru.inbox.savinov_vu.service.personal.person;

import ru.inbox.savinov_vu.model.personal.Person;
import ru.inbox.savinov_vu.service.ParentService;

import java.util.List;

public interface PersonService extends ParentService<Person> {

    List<Person> getAll();

    List<Person> getPersonWithGroup(Integer id);


    void addPerson(Person person);

    void deletePerson(Person person);
}
