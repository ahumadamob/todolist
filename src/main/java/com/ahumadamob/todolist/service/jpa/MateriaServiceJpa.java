package com.ahumadamob.todolist.service.jpa;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahumadamob.todolist.entity.Materia;
import com.ahumadamob.todolist.repository.MateriaRepository;
import com.ahumadamob.todolist.service.IMateriaService;
import com.ahumadamob.todolist.exception.RecordNotFoundException;
import com.ahumadamob.todolist.exception.ValidationException;
import com.ahumadamob.todolist.dto.MateriaRequestDto;
import com.ahumadamob.todolist.mapper.MateriaMapper;

@Service
public class MateriaServiceJpa implements IMateriaService {

    @Autowired
    private MateriaRepository materiaRepository;

    @Autowired
    private MateriaMapper materiaMapper;

    @Override
    public Materia create(MateriaRequestDto dto) {
        Materia materia = materiaMapper.toEntity(dto);
        validateCorrelativas(materia, null);
        return materiaRepository.save(materia);
    }

    @Override
    public Materia update(Long id, MateriaRequestDto dto) {
        Materia existing = materiaRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("materiaId", "Materia no encontrada"));
        materiaMapper.applyToEntity(dto, existing);
        validateCorrelativas(existing, id);
        return materiaRepository.save(existing);
    }

    @Override
    public List<Materia> findAll() {
        return materiaRepository.findAll();
    }

    @Override
    public Materia findById(Long id) {
        return materiaRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        materiaRepository.deleteById(id);
    }

    private void validateCorrelativas(Materia materia, Long id) {
        Long targetId = id != null ? id : materia.getId();
        for (Materia m : materia.getCorrelativas()) {
            if (targetId != null && targetId.equals(m.getId())) {
                throw new ValidationException("correlativaIds", "La materia no puede ser correlativa de sí misma");
            }
            if (createsCycle(m, targetId, new HashSet<>())) {
                throw new ValidationException("correlativaIds", "Las materias correlativas no pueden generar ciclos");
            }
        }
    }

    private boolean createsCycle(Materia current, Long targetId, Set<Long> visited) {
        if (current.getId() == null) {
            return false;
        }
        if (!visited.add(current.getId())) {
            return false;
        }
        if (targetId != null && current.getId().equals(targetId)) {
            return true;
        }
        for (Materia sub : current.getCorrelativas()) {
            if (createsCycle(sub, targetId, visited)) {
                return true;
            }
        }
        return false;
    }
}
