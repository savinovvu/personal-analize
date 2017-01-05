package ru.inbox.savinov_vu.service.personal.person;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.inbox.savinov_vu.model.personal.Group;
import ru.inbox.savinov_vu.model.personal.Person;
import ru.inbox.savinov_vu.repository.PersonRepository;

import java.util.List;


@Service
public class PersonServiceImpl implements PersonService{
    @Autowired
    PersonRepository repository;

    @Override
    public List<Person> getAllPersons() {
        return repository.findAll();
    }

    @Override
    public List<Person> getPersonWithGroup(Group group) {
        return repository.getPersonWithGroup(group);
    }

    @Override
    public void addPerson(Person person) {
        repository.saveAndFlush(person);
    }

    @Override
    public void deletePerson(Person person) {
        repository.delete(person);
    }
}