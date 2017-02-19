package ru.inbox.savinov_vu.controller.personal.person;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.inbox.savinov_vu.model.personal.Person;
import ru.inbox.savinov_vu.service.personal.person.PersonService;

import java.util.List;

@RestController
@RequestMapping(value = "/personal/person", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class PersonRestController {

    private static final Logger LOG = LoggerFactory.getLogger(PersonRestController.class);

    @Autowired
    PersonService service;

    @GetMapping(value = "/all")
    public List<Person> getAllPerson() {
        LOG.info("get all persons");
        return service.getAllPersons();

    }

    @GetMapping("/{id}")
    public List<Person> getPersonWithGroup(@PathVariable("id") Integer id) {
        LOG.info("get all persons where group id= {}", id);
        return service.getPersonWithGroup(id);

    }


    @PutMapping
    public List<Person> putPerson(@RequestBody Person person) {
        LOG.info("put person {}", person);
        service.addPerson(person);
        return service.getAllPersons();

    }

    @DeleteMapping
    public List<Person> deletePerson(@RequestBody Person person) {
        LOG.info("delete person {}", person);
        service.deletePerson(person);
        return service.getAllPersons();

    }


}
