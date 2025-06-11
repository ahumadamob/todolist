package com.ahumadamob.todolist.controller;

import java.util.List;
import java.util.Collections;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
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
import com.ahumadamob.todolist.dto.ProfesorRequestDto;
import com.ahumadamob.todolist.dto.ProfesorResponseDto;
import com.ahumadamob.todolist.entity.Profesor;
import com.ahumadamob.todolist.service.IProfesorService;
import com.ahumadamob.todolist.mapper.ProfesorMapper;
import org.springframework.beans.factory.annotation.Autowired;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/profesores")
public class ProfesorController {
    @Autowired
    private IProfesorService profesorService;

    @Autowired
    private ProfesorMapper profesorMapper;

    @GetMapping
    public ResponseEntity<SuccessResponseDto<List<ProfesorResponseDto>>> findAll() {
        List<Profesor> profesores = profesorService.findAll();
        List<ProfesorResponseDto> dtos = profesores.stream()
                .map(profesorMapper::toDto)
                .toList();
        return ResponseEntity.ok(new SuccessResponseDto<>("Profesores retrieved", dtos));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Profesor profesor = profesorService.findById(id);
        if (profesor == null) {
            ErrorDetailDto detail = new ErrorDetailDto("profesorId", "Profesor no encontrado");
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ErrorResponseDto(Collections.singletonList(detail)));
        }
        return ResponseEntity.ok(new SuccessResponseDto<>("Profesor found", profesorMapper.toDto(profesor)));
    }

    @PostMapping
    public ResponseEntity<SuccessResponseDto<ProfesorResponseDto>> create(@Valid @RequestBody ProfesorRequestDto dto) {
        Profesor saved = profesorService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new SuccessResponseDto<>("Profesor created", profesorMapper.toDto(saved)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SuccessResponseDto<ProfesorResponseDto>> update(@PathVariable Long id, @Valid @RequestBody ProfesorRequestDto dto) {
        Profesor saved = profesorService.update(id, dto);
        return ResponseEntity.ok(new SuccessResponseDto<>("Profesor updated", profesorMapper.toDto(saved)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SuccessResponseDto<Void>> delete(@PathVariable Long id) {
        profesorService.deleteById(id);
        return ResponseEntity.ok(new SuccessResponseDto<>("Profesor deleted", null));
    }

}
