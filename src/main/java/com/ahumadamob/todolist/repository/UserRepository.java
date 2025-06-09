package com.ahumadamob.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ahumadamob.todolist.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByUsername(String username);
}
