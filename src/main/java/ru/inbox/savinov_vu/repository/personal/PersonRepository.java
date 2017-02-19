package ru.inbox.savinov_vu.repository.personal;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.inbox.savinov_vu.model.personal.Group;
import ru.inbox.savinov_vu.model.personal.Person;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

    @Query("SELECT p FROM Person p WHERE p.group.id=:group_id")
    List<Person> getPersonWithGroup(@Param("group_id") Integer id);



}
