package com.ahumadamob.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ahumadamob.todolist.entity.Materia;

public interface MateriaRepository extends JpaRepository<Materia, Long> {
}
