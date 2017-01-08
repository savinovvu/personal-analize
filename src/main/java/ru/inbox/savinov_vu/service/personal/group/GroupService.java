package ru.inbox.savinov_vu.service.personal.group;

import ru.inbox.savinov_vu.model.personal.Department;
import ru.inbox.savinov_vu.model.personal.Group;

import java.util.List;

public interface GroupService {

    List<Group> getAllGroups();

    List<Group> getDepartmentWithGroups(Department department);

    void addGroup(Group Group);

    void deleteGroup(Group group);

}
