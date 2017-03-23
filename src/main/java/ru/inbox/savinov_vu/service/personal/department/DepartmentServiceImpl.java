package ru.inbox.savinov_vu.service.personal.department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.inbox.savinov_vu.model.personal.Department;
import ru.inbox.savinov_vu.repository.personal.DepartmentRepository;

import java.util.List;


@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    DepartmentRepository repository;

    @Override
    public List<Department> getAll() {
        return repository.findAll();
    }

    @Override
    public void addDepartment(Department department) {
        repository.saveAndFlush(department);

    }

    @Override
    public void deleteDepartment(Department department) {
        repository.delete(department.getId());
    }
}
