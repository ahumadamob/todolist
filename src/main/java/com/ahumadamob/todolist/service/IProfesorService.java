package com.ahumadamob.todolist.service;

import java.util.List;
import com.ahumadamob.todolist.entity.Profesor;
import com.ahumadamob.todolist.dto.ProfesorRequestDto;

public interface IProfesorService {
    Profesor create(ProfesorRequestDto dto);
    Profesor update(Long id, ProfesorRequestDto dto);
    List<Profesor> findAll();
    Profesor findById(Long id);
    void deleteById(Long id);
}
