package ru.inbox.savinov_vu.service.personal.person;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.inbox.savinov_vu.model.personal.Person;
import ru.inbox.savinov_vu.repository.personal.GroupRepository;
import ru.inbox.savinov_vu.repository.personal.PersonRepository;

import java.util.List;


@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    PersonRepository repository;

    @Autowired
    GroupRepository groupRepository;

    @Override
    public List<Person> getAll() {
        return repository.findAll();
    }

    @Override
    public List<Person> getPersonWithGroup(Integer id) {
        return repository.getPersonWithGroup(id);
    }

    @Override
    public void addPerson(Person person) {
        repository.saveAndFlush(person);
    }

    @Override
    public void deletePerson(Person person) {
        repository.delete(person.getId());
    }
}
