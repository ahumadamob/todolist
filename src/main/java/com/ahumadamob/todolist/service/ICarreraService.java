package com.ahumadamob.todolist.service;

import java.util.List;
import com.ahumadamob.todolist.entity.Carrera;
import com.ahumadamob.todolist.dto.CarreraRequestDto;

public interface ICarreraService {
    Carrera create(CarreraRequestDto dto);
    Carrera update(Long id, CarreraRequestDto dto);
    List<Carrera> findAll();
    Carrera findById(Long id);
    void deleteById(Long id);
}
