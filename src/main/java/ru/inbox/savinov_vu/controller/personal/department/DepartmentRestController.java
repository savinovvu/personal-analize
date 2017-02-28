package ru.inbox.savinov_vu.controller.personal.department;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.inbox.savinov_vu.model.personal.Department;
import ru.inbox.savinov_vu.service.personal.department.DepartmentService;

import java.util.List;

@RestController
@RequestMapping(value = "/personal/department", produces = MediaType.APPLICATION_JSON_VALUE)
public class DepartmentRestController {

    @Autowired
    DepartmentService service;

    private static final Logger LOG = LoggerFactory.getLogger(DepartmentRestController.class);

    @GetMapping(value = "/all")
    public List<Department> getAllDepartments() {
        LOG.debug("get all departments");
        return service.getAllDepartments();

    }

    @PutMapping
    public List<Department> addDepartment(@RequestBody Department department) {
        LOG.debug("put department {}", department);
        service.addDepartment(department);
        return service.getAllDepartments();

    }

    @DeleteMapping
    public List<Department> deleteDepartment(@RequestBody Department department) {
        LOG.debug("delete department {}", department);
        service.deleteDepartment(department);
        return service.getAllDepartments();

    }

}
