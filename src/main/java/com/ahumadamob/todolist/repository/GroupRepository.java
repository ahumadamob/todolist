package com.ahumadamob.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ahumadamob.todolist.entity.Group;

public interface GroupRepository extends JpaRepository<Group, Long> {
}
