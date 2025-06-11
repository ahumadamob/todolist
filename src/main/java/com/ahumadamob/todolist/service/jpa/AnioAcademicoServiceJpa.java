package com.ahumadamob.todolist.service.jpa;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.ahumadamob.todolist.entity.AnioAcademico;
import com.ahumadamob.todolist.repository.AnioAcademicoRepository;
import com.ahumadamob.todolist.service.IAnioAcademicoService;
import com.ahumadamob.todolist.exception.RecordNotFoundException;
import com.ahumadamob.todolist.dto.AnioAcademicoRequestDto;
import com.ahumadamob.todolist.mapper.AnioAcademicoMapper;

@Service
public class AnioAcademicoServiceJpa implements IAnioAcademicoService {

    @Autowired
    private AnioAcademicoRepository anioAcademicoRepository;

    @Autowired
    private AnioAcademicoMapper anioAcademicoMapper;

    @Override
    public AnioAcademico create(AnioAcademicoRequestDto dto) {
        AnioAcademico anio = anioAcademicoMapper.toEntity(dto);
        return anioAcademicoRepository.save(anio);
    }

    @Override
    public AnioAcademico update(Long id, AnioAcademicoRequestDto dto) {
        AnioAcademico existing = anioAcademicoRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("anioAcademicoId", "Año académico no encontrado"));
        anioAcademicoMapper.applyToEntity(dto, existing);
        return anioAcademicoRepository.save(existing);
    }

    @Override
    public List<AnioAcademico> findAll() {
        return anioAcademicoRepository.findAll();
    }

    @Override
    public AnioAcademico findById(Long id) {
        return anioAcademicoRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        anioAcademicoRepository.deleteById(id);
    }
}
