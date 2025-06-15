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
import com.ahumadamob.todolist.dto.CursoMateriaRequestDto;
import com.ahumadamob.todolist.dto.CursoMateriaResponseDto;
import com.ahumadamob.todolist.dto.SuccessResponseDto;
import com.ahumadamob.todolist.entity.CursoMateria;
import com.ahumadamob.todolist.mapper.CursoMateriaMapper;
import com.ahumadamob.todolist.service.ICursoMateriaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/cursos-materia")
public class CursoMateriaController {
    @Autowired
    private ICursoMateriaService cursoMateriaService;

    @Autowired
    private CursoMateriaMapper cursoMateriaMapper;

    @GetMapping
    public ResponseEntity<SuccessResponseDto<List<CursoMateriaResponseDto>>> findAll() {
        List<CursoMateria> list = cursoMateriaService.findAll();
        List<CursoMateriaResponseDto> dtos = list.stream()
                .map(cursoMateriaMapper::toDto)
                .toList();
        return ResponseEntity.ok(new SuccessResponseDto<>("CursoMateria retrieved", dtos));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        CursoMateria cm = cursoMateriaService.findById(id);
        if (cm == null) {
            ErrorDetailDto detail = new ErrorDetailDto("cursoMateriaId", "CursoMateria no encontrada");
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ErrorResponseDto(Collections.singletonList(detail)));
        }
        return ResponseEntity.ok(new SuccessResponseDto<>("CursoMateria found", cursoMateriaMapper.toDto(cm)));
    }

    @PostMapping
    public ResponseEntity<SuccessResponseDto<CursoMateriaResponseDto>> create(@Valid @RequestBody CursoMateriaRequestDto dto) {
        CursoMateria saved = cursoMateriaService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new SuccessResponseDto<>("CursoMateria created", cursoMateriaMapper.toDto(saved)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SuccessResponseDto<CursoMateriaResponseDto>> update(@PathVariable Long id,
            @Valid @RequestBody CursoMateriaRequestDto dto) {
        CursoMateria saved = cursoMateriaService.update(id, dto);
        return ResponseEntity.ok(new SuccessResponseDto<>("CursoMateria updated", cursoMateriaMapper.toDto(saved)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SuccessResponseDto<Void>> delete(@PathVariable Long id) {
        cursoMateriaService.deleteById(id);
        return ResponseEntity.ok(new SuccessResponseDto<>("CursoMateria deleted", null));
    }
}
