package com.ahumadamob.todolist.mapper;

import org.springframework.stereotype.Component;

import com.ahumadamob.todolist.dto.ProfesorRequestDto;
import com.ahumadamob.todolist.dto.ProfesorResponseDto;
import com.ahumadamob.todolist.entity.Profesor;

@Component
public class ProfesorMapper {

    public Profesor toEntity(ProfesorRequestDto dto) {
        Profesor profesor = new Profesor();
        applyToEntity(dto, profesor);
        return profesor;
    }

    public void applyToEntity(ProfesorRequestDto dto, Profesor profesor) {
        profesor.setNombre(dto.getNombre());
        profesor.setApellido(dto.getApellido());
        profesor.setFotoPerfil(dto.getFotoPerfil());
    }

    public ProfesorResponseDto toDto(Profesor profesor) {
        return new ProfesorResponseDto(profesor.getId(), profesor.getNombre(), profesor.getApellido(), profesor.getFotoPerfil());
    }
}
