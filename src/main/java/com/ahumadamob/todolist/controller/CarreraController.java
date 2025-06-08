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
import com.ahumadamob.todolist.dto.CarreraRequestDto;
import com.ahumadamob.todolist.dto.CarreraResponseDto;
import com.ahumadamob.todolist.entity.Carrera;
import com.ahumadamob.todolist.service.ICarreraService;
import com.ahumadamob.todolist.mapper.CarreraMapper;
import org.springframework.beans.factory.annotation.Autowired;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/carreras")
public class CarreraController {
    @Autowired
    private ICarreraService carreraService;

    @Autowired
    private CarreraMapper carreraMapper;

    @GetMapping
    public ResponseEntity<SuccessResponseDto<List<CarreraResponseDto>>> findAll() {
        List<Carrera> carreras = carreraService.findAll();
        List<CarreraResponseDto> dtos = carreras.stream()
                .map(carreraMapper::toDto)
                .toList();
        return ResponseEntity.ok(new SuccessResponseDto<>("Carreras retrieved", dtos));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Carrera carrera = carreraService.findById(id);
        if (carrera == null) {
            ErrorDetailDto detail = new ErrorDetailDto("carreraId", "Carrera no encontrada");
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ErrorResponseDto(Collections.singletonList(detail)));
        }
        return ResponseEntity.ok(new SuccessResponseDto<>("Carrera found", carreraMapper.toDto(carrera)));
    }

    @PostMapping
    public ResponseEntity<SuccessResponseDto<CarreraResponseDto>> create(@Valid @RequestBody CarreraRequestDto dto) {
        Carrera saved = carreraService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new SuccessResponseDto<>("Carrera created", carreraMapper.toDto(saved)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SuccessResponseDto<CarreraResponseDto>> update(@PathVariable Long id, @Valid @RequestBody CarreraRequestDto dto) {
        Carrera saved = carreraService.update(id, dto);
        return ResponseEntity.ok(new SuccessResponseDto<>("Carrera updated", carreraMapper.toDto(saved)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SuccessResponseDto<Void>> delete(@PathVariable Long id) {
        carreraService.deleteById(id);
        return ResponseEntity.ok(new SuccessResponseDto<>("Carrera deleted", null));
    }

}
