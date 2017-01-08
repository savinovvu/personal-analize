package ru.inbox.savinov_vu.service.personal.group;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.inbox.savinov_vu.model.personal.Department;
import ru.inbox.savinov_vu.model.personal.Group;
import ru.inbox.savinov_vu.repository.personal.GroupRepository;

import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {
    @Autowired
    GroupRepository repository;

    @Override
    public List<Group> getAllGroups() {
        return repository.findAll();
    }

    @Override
    public List<Group> getDepartmentWithGroups(Department department) {
        return repository.getGroupWithDepartment(department);
    }

    @Override
    public void addGroup(Group group) {
        repository.saveAndFlush(group);

    }

    @Override
    public void deleteGroup(Group group) {
        repository.delete(group.getId());
    }
}
