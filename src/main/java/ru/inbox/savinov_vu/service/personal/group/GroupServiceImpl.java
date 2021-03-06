package ru.inbox.savinov_vu.service.personal.group;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.inbox.savinov_vu.model.personal.Group;
import ru.inbox.savinov_vu.repository.personal.GroupRepository;

import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {
    @Autowired
    GroupRepository repository;

    @Override
    public List<Group> getAll() {
        return repository.findAll();
    }

    @Override
    public List<Group> getGroupsWithDepartment(Integer id) {
        return repository.getGroupWithDepartment(id);
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
