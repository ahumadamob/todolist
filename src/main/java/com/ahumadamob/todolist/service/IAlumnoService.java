package com.ahumadamob.todolist.service;

import java.util.List;
import com.ahumadamob.todolist.entity.Alumno;
import com.ahumadamob.todolist.dto.AlumnoRequestDto;

public interface IAlumnoService {
    Alumno create(AlumnoRequestDto dto);
    Alumno update(Long id, AlumnoRequestDto dto);
    List<Alumno> findAll();
    Alumno findById(Long id);
    void deleteById(Long id);
}
