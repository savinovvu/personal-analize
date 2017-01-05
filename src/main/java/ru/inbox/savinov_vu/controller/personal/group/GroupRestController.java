package ru.inbox.savinov_vu.controller.personal.group;


import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.inbox.savinov_vu.model.personal.Group;
import ru.inbox.savinov_vu.service.personal.group.GroupService;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/personal/group", produces = MediaType.APPLICATION_JSON_VALUE)
public class GroupRestController {
    @Autowired
    GroupService service;

    @GetMapping(value = "/all")
    public List<Group> getAllPerson(){
        return service.getAllGroups();
    }



    @GetMapping
    public List<Group> getAllActivePersons(Model model) throws JsonProcessingException {
        return service.getAllGroups();

    }



    @PutMapping
    public List<Group> putPerson(Model model, @RequestBody Group group) throws IOException {

        service.addGroup(group);
        return service.getAllGroups();

    }



    @PostMapping
    public List<Group> changeActiveUser(Model model, @RequestBody Group group) throws IOException {
        service.addGroup(group);
        return service.getAllGroups();
    }


}