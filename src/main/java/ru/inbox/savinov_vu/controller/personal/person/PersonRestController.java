package ru.inbox.savinov_vu.controller.personal.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.inbox.savinov_vu.model.personal.Person;
import ru.inbox.savinov_vu.service.personal.person.PersonService;

import java.util.List;

@RestController
@RequestMapping(value = "/personal/person", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class PersonRestController {

    @Autowired
    PersonService service;

    @GetMapping(value = "/all")
    public List<Person> getAllPerson() {
        return service.getAllPersons();
    }



    @PostMapping
    public List<Person> putPerson(@RequestBody Person person) {
        service.addPerson(person);
        return service.getAllPersons();

    }


}
