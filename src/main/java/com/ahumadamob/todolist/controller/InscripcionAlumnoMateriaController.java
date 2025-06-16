package com.ahumadamob.todolist.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ahumadamob.todolist.dto.ErrorDetailDto;
import com.ahumadamob.todolist.dto.ErrorResponseDto;
import com.ahumadamob.todolist.dto.SuccessResponseDto;
import com.ahumadamob.todolist.dto.InscripcionAlumnoMateriaRequestDto;
import com.ahumadamob.todolist.dto.InscripcionAlumnoMateriaResponseDto;
import com.ahumadamob.todolist.entity.InscripcionAlumnoMateria;
import com.ahumadamob.todolist.mapper.InscripcionAlumnoMateriaMapper;
import com.ahumadamob.todolist.service.IInscripcionAlumnoMateriaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/inscripciones")
public class InscripcionAlumnoMateriaController {
    @Autowired
    private IInscripcionAlumnoMateriaService inscripcionService;

    @Autowired
    private InscripcionAlumnoMateriaMapper inscripcionMapper;

    @GetMapping
    public ResponseEntity<SuccessResponseDto<List<InscripcionAlumnoMateriaResponseDto>>> findAll() {
        List<InscripcionAlumnoMateria> list = inscripcionService.findAll();
        List<InscripcionAlumnoMateriaResponseDto> dtos = list.stream()
                .map(inscripcionMapper::toDto)
                .toList();
        return ResponseEntity.ok(new SuccessResponseDto<>("Inscripciones retrieved", dtos));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        InscripcionAlumnoMateria ins = inscripcionService.findById(id);
        if (ins == null) {
            ErrorDetailDto detail = new ErrorDetailDto("inscripcionId", "Inscripción no encontrada");
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ErrorResponseDto(Collections.singletonList(detail)));
        }
        return ResponseEntity.ok(new SuccessResponseDto<>("Inscripción found", inscripcionMapper.toDto(ins)));
    }

    @PostMapping
    public ResponseEntity<SuccessResponseDto<InscripcionAlumnoMateriaResponseDto>> create(@Valid @RequestBody InscripcionAlumnoMateriaRequestDto dto) {
        InscripcionAlumnoMateria saved = inscripcionService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new SuccessResponseDto<>("Inscripción created", inscripcionMapper.toDto(saved)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SuccessResponseDto<InscripcionAlumnoMateriaResponseDto>> update(@PathVariable Long id,
            @Valid @RequestBody InscripcionAlumnoMateriaRequestDto dto) {
        InscripcionAlumnoMateria saved = inscripcionService.update(id, dto);
        return ResponseEntity.ok(new SuccessResponseDto<>("Inscripción updated", inscripcionMapper.toDto(saved)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SuccessResponseDto<Void>> delete(@PathVariable Long id) {
        inscripcionService.deleteById(id);
        return ResponseEntity.ok(new SuccessResponseDto<>("Inscripción deleted", null));
    }
}
