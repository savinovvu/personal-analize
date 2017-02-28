package ru.inbox.savinov_vu.controller.personal.group;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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

    private static final Logger LOG = LoggerFactory.getLogger(GroupRestController.class);

    @GetMapping(value = "/all")
    public List<Group> getAllGroups() {
        LOG.debug("get all groups");
        return service.getAllGroups();

    }

    @GetMapping("/{id}")
    public List<Group> getGroupsWithDepartment(@PathVariable("id") Integer id) {
        LOG.debug("get all groups where department id= {}", id);
        return service.getGroupsWithDepartment(id);

    }


    @PutMapping
    public List<Group> putGroup(@RequestBody Group group) throws IOException {
        LOG.debug("put group {}", group);
        service.addGroup(group);
        return service.getAllGroups();

    }


    @DeleteMapping
    public List<Group> deleteGroup(@RequestBody Group group) throws IOException {
        LOG.debug("delete group {}", group);
        service.deleteGroup(group);
        return service.getAllGroups();

    }


}
