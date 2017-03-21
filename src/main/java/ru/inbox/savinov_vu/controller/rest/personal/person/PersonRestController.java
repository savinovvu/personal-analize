package ru.inbox.savinov_vu.controller.rest.personal.person;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.inbox.savinov_vu.model.personal.Person;
import ru.inbox.savinov_vu.service.personal.person.PersonService;

import java.util.List;

@RestController
@RequestMapping(value = "/personal/person", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class PersonRestController {


    @Autowired
    PersonService service;

    @GetMapping(value = "/all")
    public List<Person> getAllPerson() {
        log.debug("\nget all persons");
        return service.getAllPersons();

    }

    @GetMapping("/{id}")
    public List<Person> getPersonWithGroup(@PathVariable("id") Integer id) {
        log.debug("\nget all persons where group id= {}", id);
        return service.getPersonWithGroup(id);

    }


    @PutMapping
    public List<Person> putPerson(@RequestBody Person person) {
        log.debug("\nput person {}", person);
        service.addPerson(person);
        return service.getAllPersons();

    }

    @DeleteMapping
    public List<Person> deletePerson(@RequestBody Person person) {
        log.debug("\ndelete person {}", person);
        service.deletePerson(person);
        return service.getAllPersons();

    }


}
