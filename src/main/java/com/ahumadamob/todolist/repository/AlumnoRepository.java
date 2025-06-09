package com.ahumadamob.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ahumadamob.todolist.entity.Alumno;

public interface AlumnoRepository extends JpaRepository<Alumno, Long> {
}
