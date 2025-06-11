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

import com.ahumadamob.todolist.dto.AlumnoRequestDto;
import com.ahumadamob.todolist.dto.AlumnoResponseDto;
import com.ahumadamob.todolist.dto.ErrorDetailDto;
import com.ahumadamob.todolist.dto.ErrorResponseDto;
import com.ahumadamob.todolist.dto.SuccessResponseDto;
import com.ahumadamob.todolist.entity.Alumno;
import com.ahumadamob.todolist.mapper.AlumnoMapper;
import com.ahumadamob.todolist.service.IAlumnoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/alumnos")
public class AlumnoController {
    @Autowired
    private IAlumnoService alumnoService;

    @Autowired
    private AlumnoMapper alumnoMapper;

    @GetMapping
    public ResponseEntity<SuccessResponseDto<List<AlumnoResponseDto>>> findAll() {
        List<Alumno> alumnos = alumnoService.findAll();
        List<AlumnoResponseDto> dtos = alumnos.stream()
                .map(alumnoMapper::toDto)
                .toList();
        return ResponseEntity.ok(new SuccessResponseDto<>("Alumnos retrieved", dtos));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Alumno alumno = alumnoService.findById(id);
        if (alumno == null) {
            ErrorDetailDto detail = new ErrorDetailDto("alumnoId", "Alumno no encontrado");
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ErrorResponseDto(Collections.singletonList(detail)));
        }
        return ResponseEntity.ok(new SuccessResponseDto<>("Alumno found", alumnoMapper.toDto(alumno)));
    }

    @PostMapping
    public ResponseEntity<SuccessResponseDto<AlumnoResponseDto>> create(@Valid @RequestBody AlumnoRequestDto dto) {
        Alumno saved = alumnoService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new SuccessResponseDto<>("Alumno created", alumnoMapper.toDto(saved)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SuccessResponseDto<AlumnoResponseDto>> update(@PathVariable Long id, @Valid @RequestBody AlumnoRequestDto dto) {
        Alumno saved = alumnoService.update(id, dto);
        return ResponseEntity.ok(new SuccessResponseDto<>("Alumno updated", alumnoMapper.toDto(saved)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SuccessResponseDto<Void>> delete(@PathVariable Long id) {
        alumnoService.deleteById(id);
        return ResponseEntity.ok(new SuccessResponseDto<>("Alumno deleted", null));
    }
}
