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
import com.ahumadamob.todolist.dto.AnioAcademicoRequestDto;
import com.ahumadamob.todolist.dto.AnioAcademicoResponseDto;
import com.ahumadamob.todolist.dto.SuccessResponseDto;
import com.ahumadamob.todolist.entity.AnioAcademico;
import com.ahumadamob.todolist.mapper.AnioAcademicoMapper;
import com.ahumadamob.todolist.service.IAnioAcademicoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/anios-academicos")
public class AnioAcademicoController {
    @Autowired
    private IAnioAcademicoService anioAcademicoService;

    @Autowired
    private AnioAcademicoMapper anioAcademicoMapper;

    @GetMapping
    public ResponseEntity<SuccessResponseDto<List<AnioAcademicoResponseDto>>> findAll() {
        List<AnioAcademico> anios = anioAcademicoService.findAll();
        List<AnioAcademicoResponseDto> dtos = anios.stream()
                .map(anioAcademicoMapper::toDto)
                .toList();
        return ResponseEntity.ok(new SuccessResponseDto<>("Años académicos retrieved", dtos));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        AnioAcademico anio = anioAcademicoService.findById(id);
        if (anio == null) {
            ErrorDetailDto detail = new ErrorDetailDto("anioAcademicoId", "Año académico no encontrado");
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ErrorResponseDto(Collections.singletonList(detail)));
        }
        return ResponseEntity.ok(new SuccessResponseDto<>("Año académico found", anioAcademicoMapper.toDto(anio)));
    }

    @PostMapping
    public ResponseEntity<SuccessResponseDto<AnioAcademicoResponseDto>> create(@Valid @RequestBody AnioAcademicoRequestDto dto) {
        AnioAcademico saved = anioAcademicoService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new SuccessResponseDto<>("Año académico created", anioAcademicoMapper.toDto(saved)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SuccessResponseDto<AnioAcademicoResponseDto>> update(@PathVariable Long id,
            @Valid @RequestBody AnioAcademicoRequestDto dto) {
        AnioAcademico saved = anioAcademicoService.update(id, dto);
        return ResponseEntity.ok(new SuccessResponseDto<>("Año académico updated", anioAcademicoMapper.toDto(saved)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SuccessResponseDto<Void>> delete(@PathVariable Long id) {
        anioAcademicoService.deleteById(id);
        return ResponseEntity.ok(new SuccessResponseDto<>("Año académico deleted", null));
    }
}
