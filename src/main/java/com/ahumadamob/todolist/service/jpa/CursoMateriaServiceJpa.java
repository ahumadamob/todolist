package com.ahumadamob.todolist.service.jpa;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahumadamob.todolist.entity.CursoMateria;
import com.ahumadamob.todolist.repository.CursoMateriaRepository;
import com.ahumadamob.todolist.service.ICursoMateriaService;
import com.ahumadamob.todolist.exception.RecordNotFoundException;
import com.ahumadamob.todolist.dto.CursoMateriaRequestDto;
import com.ahumadamob.todolist.mapper.CursoMateriaMapper;

@Service
public class CursoMateriaServiceJpa implements ICursoMateriaService {

    @Autowired
    private CursoMateriaRepository cursoMateriaRepository;

    @Autowired
    private CursoMateriaMapper cursoMateriaMapper;

    @Override
    public CursoMateria create(CursoMateriaRequestDto dto) {
        CursoMateria cm = cursoMateriaMapper.toEntity(dto);
        return cursoMateriaRepository.save(cm);
    }

    @Override
    public CursoMateria update(Long id, CursoMateriaRequestDto dto) {
        CursoMateria existing = cursoMateriaRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("cursoMateriaId", "CursoMateria no encontrada"));
        cursoMateriaMapper.applyToEntity(dto, existing);
        return cursoMateriaRepository.save(existing);
    }

    @Override
    public List<CursoMateria> findAll() {
        return cursoMateriaRepository.findAll();
    }

    @Override
    public CursoMateria findById(Long id) {
        return cursoMateriaRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        cursoMateriaRepository.deleteById(id);
    }
}
