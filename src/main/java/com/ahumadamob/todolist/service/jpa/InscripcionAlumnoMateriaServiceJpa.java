package com.ahumadamob.todolist.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahumadamob.todolist.entity.InscripcionAlumnoMateria;
import com.ahumadamob.todolist.repository.InscripcionAlumnoMateriaRepository;
import com.ahumadamob.todolist.service.IInscripcionAlumnoMateriaService;
import com.ahumadamob.todolist.exception.RecordNotFoundException;
import com.ahumadamob.todolist.dto.InscripcionAlumnoMateriaRequestDto;
import com.ahumadamob.todolist.mapper.InscripcionAlumnoMateriaMapper;

@Service
public class InscripcionAlumnoMateriaServiceJpa implements IInscripcionAlumnoMateriaService {

    @Autowired
    private InscripcionAlumnoMateriaRepository inscripcionRepository;

    @Autowired
    private InscripcionAlumnoMateriaMapper inscripcionMapper;

    @Override
    public InscripcionAlumnoMateria create(InscripcionAlumnoMateriaRequestDto dto) {
        InscripcionAlumnoMateria ins = inscripcionMapper.toEntity(dto);
        return inscripcionRepository.save(ins);
    }

    @Override
    public InscripcionAlumnoMateria update(Long id, InscripcionAlumnoMateriaRequestDto dto) {
        InscripcionAlumnoMateria existing = inscripcionRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("inscripcionId", "Inscripción no encontrada"));
        inscripcionMapper.applyToEntity(dto, existing);
        return inscripcionRepository.save(existing);
    }

    @Override
    public List<InscripcionAlumnoMateria> findAll() {
        return inscripcionRepository.findAll();
    }

    @Override
    public InscripcionAlumnoMateria findById(Long id) {
        return inscripcionRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        inscripcionRepository.deleteById(id);
    }
}
