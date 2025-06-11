package com.ahumadamob.todolist.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahumadamob.todolist.entity.Alumno;
import com.ahumadamob.todolist.repository.AlumnoRepository;
import com.ahumadamob.todolist.service.IAlumnoService;
import com.ahumadamob.todolist.exception.RecordNotFoundException;
import com.ahumadamob.todolist.dto.AlumnoRequestDto;
import com.ahumadamob.todolist.mapper.AlumnoMapper;

@Service
public class AlumnoServiceJpa implements IAlumnoService {

    @Autowired
    private AlumnoRepository alumnoRepository;

    @Autowired
    private AlumnoMapper alumnoMapper;

    @Override
    public Alumno create(AlumnoRequestDto dto) {
        Alumno alumno = alumnoMapper.toEntity(dto);
        return alumnoRepository.save(alumno);
    }

    @Override
    public Alumno update(Long id, AlumnoRequestDto dto) {
        Alumno existing = alumnoRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("alumnoId", "Alumno no encontrado"));
        alumnoMapper.applyToEntity(dto, existing);
        return alumnoRepository.save(existing);
    }

    @Override
    public List<Alumno> findAll() {
        return alumnoRepository.findAll();
    }

    @Override
    public Alumno findById(Long id) {
        return alumnoRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        alumnoRepository.deleteById(id);
    }
}
