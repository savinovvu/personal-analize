package ru.inbox.savinov_vu.service.personal.person;

import ru.inbox.savinov_vu.model.personal.Person;

import java.util.List;

public interface PersonService {

    List<Person> getAllPersons();

    List<Person> getPersonWithGroup(Integer id);


    void addPerson(Person person);

    void deletePerson(Person person);
}
