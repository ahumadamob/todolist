package com.ahumadamob.todolist.service;

import java.util.List;
import com.ahumadamob.todolist.entity.CursoMateria;
import com.ahumadamob.todolist.dto.CursoMateriaRequestDto;

public interface ICursoMateriaService {
    CursoMateria create(CursoMateriaRequestDto dto);
    CursoMateria update(Long id, CursoMateriaRequestDto dto);
    List<CursoMateria> findAll();
    CursoMateria findById(Long id);
    void deleteById(Long id);
}
