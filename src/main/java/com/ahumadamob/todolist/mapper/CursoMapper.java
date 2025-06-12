package com.ahumadamob.todolist.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ahumadamob.todolist.dto.AnioAcademicoResponseDto;
import com.ahumadamob.todolist.dto.CursoRequestDto;
import com.ahumadamob.todolist.dto.CursoResponseDto;
import com.ahumadamob.todolist.entity.AnioAcademico;
import com.ahumadamob.todolist.entity.Curso;
import com.ahumadamob.todolist.exception.RecordNotFoundException;
import com.ahumadamob.todolist.repository.AnioAcademicoRepository;

@Component
public class CursoMapper {

    @Autowired
    private AnioAcademicoRepository anioAcademicoRepository;

    public Curso toEntity(CursoRequestDto dto) {
        Curso curso = new Curso();
        applyToEntity(dto, curso);
        return curso;
    }

    public void applyToEntity(CursoRequestDto dto, Curso curso) {
        curso.setAnioCursado(dto.getAnioCursado());
        curso.setDivision(dto.getDivision());

        if (dto.getAnioAcademicoId() != null) {
            AnioAcademico anio = anioAcademicoRepository.findById(dto.getAnioAcademicoId())
                    .orElseThrow(() -> new RecordNotFoundException("anioAcademicoId", "Año académico no encontrado"));
            curso.setAnioAcademico(anio);
        } else {
            curso.setAnioAcademico(null);
        }
    }

    public CursoResponseDto toDto(Curso curso) {
        AnioAcademicoResponseDto anioDto = null;
        if (curso.getAnioAcademico() != null) {
            AnioAcademico anio = curso.getAnioAcademico();
            anioDto = new AnioAcademicoResponseDto(anio.getId(), anio.getAnio(), anio.getActivo());
        }
        return new CursoResponseDto(curso.getId(), curso.getAnioCursado(), curso.getDivision(), anioDto);
    }
}
