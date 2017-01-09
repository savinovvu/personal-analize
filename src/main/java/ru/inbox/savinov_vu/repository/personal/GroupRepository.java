package ru.inbox.savinov_vu.repository.personal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.inbox.savinov_vu.model.personal.Department;
import ru.inbox.savinov_vu.model.personal.Group;

import java.util.List;


@Repository
public interface GroupRepository extends JpaRepository<Group, Integer> {

    @Query("SELECT p FROM ru.inbox.savinov_vu.model.personal.Group p WHERE p.department.id=:department_id")
    List<Group> getGroupWithDepartment(@Param("department_id") Integer id);


}
