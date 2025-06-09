package com.ahumadamob.todolist.mapper;

import org.springframework.stereotype.Component;

import com.ahumadamob.todolist.dto.CarreraRequestDto;
import com.ahumadamob.todolist.dto.CarreraResponseDto;
import com.ahumadamob.todolist.entity.Carrera;

@Component
public class CarreraMapper {

    public Carrera toEntity(CarreraRequestDto dto) {
        Carrera carrera = new Carrera();
        applyToEntity(dto, carrera);
        return carrera;
    }

    public void applyToEntity(CarreraRequestDto dto, Carrera carrera) {
        carrera.setNombre(dto.getNombre());
    }

    public CarreraResponseDto toDto(Carrera carrera) {
        return new CarreraResponseDto(carrera.getId(), carrera.getNombre());
    }
}
