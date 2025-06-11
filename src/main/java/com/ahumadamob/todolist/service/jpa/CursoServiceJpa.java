package com.ahumadamob.todolist.service.jpa;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.ahumadamob.todolist.entity.Curso;
import com.ahumadamob.todolist.repository.CursoRepository;
import com.ahumadamob.todolist.service.ICursoService;
import com.ahumadamob.todolist.exception.RecordNotFoundException;
import com.ahumadamob.todolist.dto.CursoRequestDto;
import com.ahumadamob.todolist.mapper.CursoMapper;

@Service
public class CursoServiceJpa implements ICursoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private CursoMapper cursoMapper;

    @Override
    public Curso create(CursoRequestDto dto) {
        Curso curso = cursoMapper.toEntity(dto);
        return cursoRepository.save(curso);
    }

    @Override
    public Curso update(Long id, CursoRequestDto dto) {
        Curso existing = cursoRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("cursoId", "Curso no encontrado"));
        cursoMapper.applyToEntity(dto, existing);
        return cursoRepository.save(existing);
    }

    @Override
    public List<Curso> findAll() {
        return cursoRepository.findAll();
    }

    @Override
    public Curso findById(Long id) {
        return cursoRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        cursoRepository.deleteById(id);
    }
}
