package ru.inbox.savinov_vu.controller.page;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class PersonalController {

    @GetMapping("editDepartment")
    public String personalDepartment() {
        log.debug("\nget editDepartment page");
        return "personal/department/department";
    }

    @GetMapping("editGroup")
    public String personalGroup() {
        log.debug("\nget editGroup page");
        return "personal/group/group";
    }

    @GetMapping("editPerson")
    public String personalPerson() {
        log.debug("\nget editPerson page");
        return "personal/person/person";
    }
}
