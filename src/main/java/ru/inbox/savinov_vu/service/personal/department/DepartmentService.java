package ru.inbox.savinov_vu.service.personal.department;

import ru.inbox.savinov_vu.model.personal.Department;
import ru.inbox.savinov_vu.service.ParentService;

import java.util.List;

public interface DepartmentService extends ParentService<Department> {
    List<Department> getAll();

    void addDepartment(Department department);

    void deleteDepartment(Department department);

}
