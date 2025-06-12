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
import com.ahumadamob.todolist.dto.CursoRequestDto;
import com.ahumadamob.todolist.dto.CursoResponseDto;
import com.ahumadamob.todolist.dto.SuccessResponseDto;
import com.ahumadamob.todolist.entity.Curso;
import com.ahumadamob.todolist.mapper.CursoMapper;
import com.ahumadamob.todolist.service.ICursoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/cursos")
public class CursoController {
    @Autowired
    private ICursoService cursoService;

    @Autowired
    private CursoMapper cursoMapper;

    @GetMapping
    public ResponseEntity<SuccessResponseDto<List<CursoResponseDto>>> findAll() {
        List<Curso> cursos = cursoService.findAll();
        List<CursoResponseDto> dtos = cursos.stream()
                .map(cursoMapper::toDto)
                .toList();
        return ResponseEntity.ok(new SuccessResponseDto<>("Cursos retrieved", dtos));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Curso curso = cursoService.findById(id);
        if (curso == null) {
            ErrorDetailDto detail = new ErrorDetailDto("cursoId", "Curso no encontrado");
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ErrorResponseDto(Collections.singletonList(detail)));
        }
        return ResponseEntity.ok(new SuccessResponseDto<>("Curso found", cursoMapper.toDto(curso)));
    }

    @PostMapping
    public ResponseEntity<SuccessResponseDto<CursoResponseDto>> create(@Valid @RequestBody CursoRequestDto dto) {
        Curso saved = cursoService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new SuccessResponseDto<>("Curso created", cursoMapper.toDto(saved)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SuccessResponseDto<CursoResponseDto>> update(@PathVariable Long id,
            @Valid @RequestBody CursoRequestDto dto) {
        Curso saved = cursoService.update(id, dto);
        return ResponseEntity.ok(new SuccessResponseDto<>("Curso updated", cursoMapper.toDto(saved)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SuccessResponseDto<Void>> delete(@PathVariable Long id) {
        cursoService.deleteById(id);
        return ResponseEntity.ok(new SuccessResponseDto<>("Curso deleted", null));
    }
}
