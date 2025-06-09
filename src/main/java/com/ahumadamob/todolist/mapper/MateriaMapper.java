package com.ahumadamob.todolist.mapper;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ahumadamob.todolist.dto.CarreraResponseDto;
import com.ahumadamob.todolist.dto.MateriaRefDto;
import com.ahumadamob.todolist.dto.MateriaRequestDto;
import com.ahumadamob.todolist.dto.MateriaResponseDto;
import com.ahumadamob.todolist.entity.Carrera;
import com.ahumadamob.todolist.entity.Materia;
import com.ahumadamob.todolist.exception.RecordNotFoundException;
import com.ahumadamob.todolist.repository.CarreraRepository;
import com.ahumadamob.todolist.repository.MateriaRepository;

@Component
public class MateriaMapper {

    @Autowired
    private CarreraRepository carreraRepository;

    @Autowired
    private MateriaRepository materiaRepository;

    public Materia toEntity(MateriaRequestDto dto) {
        Materia materia = new Materia();
        applyToEntity(dto, materia);
        return materia;
    }

    public void applyToEntity(MateriaRequestDto dto, Materia materia) {
        materia.setNombre(dto.getNombre());

        if (dto.getCarreraId() != null) {
            Carrera carrera = carreraRepository.findById(dto.getCarreraId())
                    .orElseThrow(() -> new RecordNotFoundException("carreraId", "Carrera no encontrada"));
            materia.setCarrera(carrera);
        } else {
            materia.setCarrera(null);
        }

        if (dto.getCorrelativaIds() != null) {
            List<Materia> correlativas = dto.getCorrelativaIds().stream()
                    .map(id -> materiaRepository.findById(id)
                            .orElseThrow(() -> new RecordNotFoundException("correlativaId", "Materia no encontrada")))
                    .collect(Collectors.toList());
            materia.setCorrelativas(correlativas);
        } else {
            materia.setCorrelativas(Collections.emptyList());
        }
    }

    public MateriaResponseDto toDto(Materia materia) {
        CarreraResponseDto carreraDto = null;
        if (materia.getCarrera() != null) {
            Carrera carrera = materia.getCarrera();
            carreraDto = new CarreraResponseDto(carrera.getId(), carrera.getNombre());
        }
        List<MateriaRefDto> correlativas = materia.getCorrelativas().stream()
                .map(m -> new MateriaRefDto(m.getId(), m.getNombre()))
                .toList();
        return new MateriaResponseDto(materia.getId(), materia.getNombre(), carreraDto, correlativas);
    }
}
