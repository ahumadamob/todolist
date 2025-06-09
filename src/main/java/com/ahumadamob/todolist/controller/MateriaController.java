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
import com.ahumadamob.todolist.dto.MateriaRequestDto;
import com.ahumadamob.todolist.dto.MateriaResponseDto;
import com.ahumadamob.todolist.dto.SuccessResponseDto;
import com.ahumadamob.todolist.entity.Materia;
import com.ahumadamob.todolist.mapper.MateriaMapper;
import com.ahumadamob.todolist.service.IMateriaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/materias")
public class MateriaController {
    @Autowired
    private IMateriaService materiaService;

    @Autowired
    private MateriaMapper materiaMapper;

    @GetMapping
    public ResponseEntity<SuccessResponseDto<List<MateriaResponseDto>>> findAll() {
        List<Materia> materias = materiaService.findAll();
        List<MateriaResponseDto> dtos = materias.stream()
                .map(materiaMapper::toDto)
                .toList();
        return ResponseEntity.ok(new SuccessResponseDto<>("Materias retrieved", dtos));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Materia materia = materiaService.findById(id);
        if (materia == null) {
            ErrorDetailDto detail = new ErrorDetailDto("materiaId", "Materia no encontrada");
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ErrorResponseDto(Collections.singletonList(detail)));
        }
        return ResponseEntity.ok(new SuccessResponseDto<>("Materia found", materiaMapper.toDto(materia)));
    }

    @PostMapping
    public ResponseEntity<SuccessResponseDto<MateriaResponseDto>> create(@Valid @RequestBody MateriaRequestDto dto) {
        Materia saved = materiaService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new SuccessResponseDto<>("Materia created", materiaMapper.toDto(saved)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SuccessResponseDto<MateriaResponseDto>> update(@PathVariable Long id,
            @Valid @RequestBody MateriaRequestDto dto) {
        Materia saved = materiaService.update(id, dto);
        return ResponseEntity.ok(new SuccessResponseDto<>("Materia updated", materiaMapper.toDto(saved)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SuccessResponseDto<Void>> delete(@PathVariable Long id) {
        materiaService.deleteById(id);
        return ResponseEntity.ok(new SuccessResponseDto<>("Materia deleted", null));
    }
}
