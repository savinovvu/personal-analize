package ru.inbox.savinov_vu.controller.rest.personal.department;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.inbox.savinov_vu.model.personal.Department;
import ru.inbox.savinov_vu.service.personal.department.DepartmentService;

import java.util.List;

@RestController
@RequestMapping(value = "/personal/department", produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class DepartmentRestController {

    @Autowired
    DepartmentService service;


    @GetMapping(value = "/all")
    public List<Department> getAllDepartments() {
        log.debug("\nget all departments");
        return service.getAll();

    }

    @PutMapping
    public List<Department> addDepartment(@RequestBody Department department) {
        log.debug("\nput department {}", department);
        service.addDepartment(department);
        return service.getAll();

    }

    @DeleteMapping
    public List<Department> deleteDepartment(@RequestBody Department department) {
        log.debug("\ndelete department {}", department);
        service.deleteDepartment(department);
        return service.getAll();

    }

}
