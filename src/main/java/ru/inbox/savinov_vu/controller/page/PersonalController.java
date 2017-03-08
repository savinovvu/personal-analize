package ru.inbox.savinov_vu.controller.page;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PersonalController {

    private static final Logger LOG = LoggerFactory.getLogger(PersonalController.class);

    @GetMapping("editDepartment")
    public String personalDepartment() {
        LOG.debug("get editDepartment page");
        return "personal/department/department";
    }

    @GetMapping("editGroup")
    public String personalGroup() {
        LOG.debug("get editGroup page");
        return "personal/group/group";
    }

    @GetMapping("editPerson")
    public String personalPerson() {
        LOG.debug("get editPerson page");
        return "personal/person/person";
    }
}