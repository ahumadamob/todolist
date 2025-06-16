package com.ahumadamob.todolist.service;

import java.util.List;
import com.ahumadamob.todolist.entity.InscripcionAlumnoMateria;
import com.ahumadamob.todolist.dto.InscripcionAlumnoMateriaRequestDto;

public interface IInscripcionAlumnoMateriaService {
    InscripcionAlumnoMateria create(InscripcionAlumnoMateriaRequestDto dto);
    InscripcionAlumnoMateria update(Long id, InscripcionAlumnoMateriaRequestDto dto);
    List<InscripcionAlumnoMateria> findAll();
    InscripcionAlumnoMateria findById(Long id);
    void deleteById(Long id);
}
