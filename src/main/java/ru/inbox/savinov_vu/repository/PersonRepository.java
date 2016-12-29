package ru.inbox.savinov_vu.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.inbox.savinov_vu.model.personal.Group;
import ru.inbox.savinov_vu.model.personal.Person;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

    @Query()
    List<Person> getPersonWithGroup(Group group) ;
}
