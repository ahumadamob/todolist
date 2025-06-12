package com.ahumadamob.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ahumadamob.todolist.entity.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}
