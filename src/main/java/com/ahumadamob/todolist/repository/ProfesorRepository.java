package com.ahumadamob.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ahumadamob.todolist.entity.Profesor;

public interface ProfesorRepository extends JpaRepository<Profesor, Long> {
}
