package com.ahumadamob.todolist.service;

import java.util.List;
import com.ahumadamob.todolist.entity.AnioAcademico;
import com.ahumadamob.todolist.dto.AnioAcademicoRequestDto;

public interface IAnioAcademicoService {
    AnioAcademico create(AnioAcademicoRequestDto dto);
    AnioAcademico update(Long id, AnioAcademicoRequestDto dto);
    List<AnioAcademico> findAll();
    AnioAcademico findById(Long id);
    void deleteById(Long id);
}
