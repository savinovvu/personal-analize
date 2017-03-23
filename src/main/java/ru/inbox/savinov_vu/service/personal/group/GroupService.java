package ru.inbox.savinov_vu.service.personal.group;

import ru.inbox.savinov_vu.model.personal.Group;
import ru.inbox.savinov_vu.service.ParentService;

import java.util.List;

public interface GroupService extends ParentService<Group> {

    List<Group> getAll();

    List<Group> getGroupsWithDepartment(Integer department);

    void addGroup(Group Group);

    void deleteGroup(Group group);

}
