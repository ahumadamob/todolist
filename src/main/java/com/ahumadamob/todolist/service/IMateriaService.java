package com.ahumadamob.todolist.service;

import java.util.List;
import com.ahumadamob.todolist.entity.Materia;
import com.ahumadamob.todolist.dto.MateriaRequestDto;

public interface IMateriaService {
    Materia create(MateriaRequestDto dto);
    Materia update(Long id, MateriaRequestDto dto);
    List<Materia> findAll();
    Materia findById(Long id);
    void deleteById(Long id);
}
