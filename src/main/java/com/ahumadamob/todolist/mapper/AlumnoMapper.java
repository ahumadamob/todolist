package com.ahumadamob.todolist.mapper;

import org.springframework.stereotype.Component;

import com.ahumadamob.todolist.dto.AlumnoRequestDto;
import com.ahumadamob.todolist.dto.AlumnoResponseDto;
import com.ahumadamob.todolist.entity.Alumno;

@Component
public class AlumnoMapper {

    public Alumno toEntity(AlumnoRequestDto dto) {
        Alumno alumno = new Alumno();
        applyToEntity(dto, alumno);
        return alumno;
    }

    public void applyToEntity(AlumnoRequestDto dto, Alumno alumno) {
        alumno.setNombre(dto.getNombre());
        alumno.setApellido(dto.getApellido());
        alumno.setFotoPerfil(dto.getFotoPerfil());
    }

    public AlumnoResponseDto toDto(Alumno alumno) {
        return new AlumnoResponseDto(alumno.getId(), alumno.getNombre(), alumno.getApellido(), alumno.getFotoPerfil());
    }
}
