package ru.inbox.savinov_vu.controller.personal.person;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.inbox.savinov_vu.model.personal.Person;
import ru.inbox.savinov_vu.service.personal.person.PersonService;

import java.util.ArrayList;
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


    @GetMapping
    public List<Person> getAllActivePersons(Model model) throws JsonProcessingException {
        return service.getAllPersons();

    }


    @PostMapping
    public List<Person> putPerson(@RequestBody String str) {

        System.out.println(str);
        return new ArrayList<Person>();

    }


}
