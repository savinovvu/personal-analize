package ru.inbox.savinov_vu.controller.personal.department;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.inbox.savinov_vu.model.personal.Group;
import ru.inbox.savinov_vu.service.personal.group.GroupService;

import java.util.List;

@RestController
@RequestMapping(value = "/personal/department", produces = MediaType.APPLICATION_JSON_VALUE)
public class DepartmentRestController {

    @Autowired
    GroupService service;

    @GetMapping(value = "/all")
    public List<Group> getAllPerson(){
        return service.getAllGroups();
    }

}
