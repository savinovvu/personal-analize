package ru.inbox.savinov_vu.repository;

import org.hibernate.validator.internal.engine.groups.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<Group, Integer> {
}
