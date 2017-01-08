package ru.inbox.savinov_vu.service.personal.department;

import ru.inbox.savinov_vu.model.personal.Department;

import java.util.List;

public interface DepartmentService {
    List<Department> getAllDepartments();

    void addDepartment(Department department);

    void deleteDepartment(Department department);

}
