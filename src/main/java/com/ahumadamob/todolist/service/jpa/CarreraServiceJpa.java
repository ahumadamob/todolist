package com.ahumadamob.todolist.service.jpa;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.ahumadamob.todolist.entity.Carrera;
import com.ahumadamob.todolist.repository.CarreraRepository;
import com.ahumadamob.todolist.service.ICarreraService;
import com.ahumadamob.todolist.exception.RecordNotFoundException;
import com.ahumadamob.todolist.dto.CarreraRequestDto;
import com.ahumadamob.todolist.mapper.CarreraMapper;

@Service
public class CarreraServiceJpa implements ICarreraService {

    @Autowired
    private CarreraRepository carreraRepository;

    @Autowired
    private CarreraMapper carreraMapper;

    @Override
    public Carrera create(CarreraRequestDto dto) {
        Carrera carrera = carreraMapper.toEntity(dto);
        return carreraRepository.save(carrera);
    }

    @Override
    public Carrera update(Long id, CarreraRequestDto dto) {
        Carrera existing = carreraRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("carreraId", "Carrera no encontrada"));
        carreraMapper.applyToEntity(dto, existing);
        return carreraRepository.save(existing);
    }

    @Override
    public List<Carrera> findAll() {
        return carreraRepository.findAll();
    }

    @Override
    public Carrera findById(Long id) {
        return carreraRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        carreraRepository.deleteById(id);
    }
}
