package ru.inbox.savinov_vu.controller.rest.personal.group;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.inbox.savinov_vu.model.personal.Group;
import ru.inbox.savinov_vu.service.personal.group.GroupService;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/personal/group", produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class GroupRestController {
    @Autowired
    GroupService service;

    @GetMapping(value = "/all")
    public List<Group> getAllGroups() {
        log.debug("\nget all groups");
        return service.getAllGroups();

    }

    @GetMapping("/{id}")
    public List<Group> getGroupsWithDepartment(@PathVariable("id") Integer id) {
        log.debug("\nget all groups where department id= {}", id);
        return service.getGroupsWithDepartment(id);

    }


    @PutMapping
    public List<Group> putGroup(@RequestBody Group group) throws IOException {
        log.debug("\nput group {}", group);
        service.addGroup(group);
        return service.getAllGroups();

    }


    @DeleteMapping
    public List<Group> deleteGroup(@RequestBody Group group) throws IOException {
        log.debug("\ndelete group {}", group);
        service.deleteGroup(group);
        return service.getAllGroups();

    }


}
