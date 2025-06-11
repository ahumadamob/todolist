package com.ahumadamob.todolist.service;

import java.util.List;
import com.ahumadamob.todolist.entity.Curso;
import com.ahumadamob.todolist.dto.CursoRequestDto;

public interface ICursoService {
    Curso create(CursoRequestDto dto);
    Curso update(Long id, CursoRequestDto dto);
    List<Curso> findAll();
    Curso findById(Long id);
    void deleteById(Long id);
}
