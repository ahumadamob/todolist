package com.ahumadamob.todolist.mapper;

import org.springframework.stereotype.Component;

import com.ahumadamob.todolist.dto.AnioAcademicoRequestDto;
import com.ahumadamob.todolist.dto.AnioAcademicoResponseDto;
import com.ahumadamob.todolist.entity.AnioAcademico;

@Component
public class AnioAcademicoMapper {

    public AnioAcademico toEntity(AnioAcademicoRequestDto dto) {
        AnioAcademico anio = new AnioAcademico();
        applyToEntity(dto, anio);
        return anio;
    }

    public void applyToEntity(AnioAcademicoRequestDto dto, AnioAcademico anio) {
        anio.setAnio(dto.getAnio());
        anio.setActivo(dto.getActivo());
    }

    public AnioAcademicoResponseDto toDto(AnioAcademico anio) {
        return new AnioAcademicoResponseDto(anio.getId(), anio.getAnio(), anio.getActivo());
    }
}
