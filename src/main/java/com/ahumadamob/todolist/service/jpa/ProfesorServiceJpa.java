package com.ahumadamob.todolist.service.jpa;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.ahumadamob.todolist.entity.Profesor;
import com.ahumadamob.todolist.repository.ProfesorRepository;
import com.ahumadamob.todolist.service.IProfesorService;
import com.ahumadamob.todolist.exception.RecordNotFoundException;
import com.ahumadamob.todolist.dto.ProfesorRequestDto;
import com.ahumadamob.todolist.mapper.ProfesorMapper;

@Service
public class ProfesorServiceJpa implements IProfesorService {

    @Autowired
    private ProfesorRepository profesorRepository;

    @Autowired
    private ProfesorMapper profesorMapper;

    @Override
    public Profesor create(ProfesorRequestDto dto) {
        Profesor profesor = profesorMapper.toEntity(dto);
        return profesorRepository.save(profesor);
    }

    @Override
    public Profesor update(Long id, ProfesorRequestDto dto) {
        Profesor existing = profesorRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("profesorId", "Profesor no encontrado"));
        profesorMapper.applyToEntity(dto, existing);
        return profesorRepository.save(existing);
    }

    @Override
    public List<Profesor> findAll() {
        return profesorRepository.findAll();
    }

    @Override
    public Profesor findById(Long id) {
        return profesorRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        profesorRepository.deleteById(id);
    }
}
