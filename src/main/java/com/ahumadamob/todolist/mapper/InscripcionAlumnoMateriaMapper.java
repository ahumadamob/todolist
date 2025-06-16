package com.ahumadamob.todolist.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ahumadamob.todolist.dto.AlumnoResponseDto;
import com.ahumadamob.todolist.dto.CursoMateriaResponseDto;
import com.ahumadamob.todolist.dto.InscripcionAlumnoMateriaRequestDto;
import com.ahumadamob.todolist.dto.InscripcionAlumnoMateriaResponseDto;
import com.ahumadamob.todolist.entity.Alumno;
import com.ahumadamob.todolist.entity.CursoMateria;
import com.ahumadamob.todolist.entity.InscripcionAlumnoMateria;
import com.ahumadamob.todolist.exception.RecordNotFoundException;
import com.ahumadamob.todolist.repository.AlumnoRepository;
import com.ahumadamob.todolist.repository.CursoMateriaRepository;

@Component
public class InscripcionAlumnoMateriaMapper {

    @Autowired
    private AlumnoRepository alumnoRepository;

    @Autowired
    private CursoMateriaRepository cursoMateriaRepository;

    @Autowired
    private AlumnoMapper alumnoMapper;

    @Autowired
    private CursoMateriaMapper cursoMateriaMapper;

    public InscripcionAlumnoMateria toEntity(InscripcionAlumnoMateriaRequestDto dto) {
        InscripcionAlumnoMateria ins = new InscripcionAlumnoMateria();
        applyToEntity(dto, ins);
        return ins;
    }

    public void applyToEntity(InscripcionAlumnoMateriaRequestDto dto, InscripcionAlumnoMateria ins) {
        if (dto.getAlumnoId() != null) {
            Alumno alumno = alumnoRepository.findById(dto.getAlumnoId())
                    .orElseThrow(() -> new RecordNotFoundException("alumnoId", "Alumno no encontrado"));
            ins.setAlumno(alumno);
        } else {
            ins.setAlumno(null);
        }

        if (dto.getCursoMateriaId() != null) {
            CursoMateria cm = cursoMateriaRepository.findById(dto.getCursoMateriaId())
                    .orElseThrow(() -> new RecordNotFoundException("cursoMateriaId", "CursoMateria no encontrada"));
            ins.setCursoMateria(cm);
        } else {
            ins.setCursoMateria(null);
        }

        ins.setFechaInscripcion(dto.getFechaInscripcion());
        ins.setEstado(dto.getEstado());
    }

    public InscripcionAlumnoMateriaResponseDto toDto(InscripcionAlumnoMateria ins) {
        AlumnoResponseDto alumnoDto = null;
        if (ins.getAlumno() != null) {
            alumnoDto = alumnoMapper.toDto(ins.getAlumno());
        }
        CursoMateriaResponseDto cmDto = null;
        if (ins.getCursoMateria() != null) {
            cmDto = cursoMateriaMapper.toDto(ins.getCursoMateria());
        }
        return new InscripcionAlumnoMateriaResponseDto(ins.getId(), alumnoDto, cmDto,
                ins.getFechaInscripcion(), ins.getEstado());
    }
}
