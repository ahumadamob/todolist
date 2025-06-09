package com.ahumadamob.todolist.dto;

import java.util.List;

/**
 * DTO enviado al cliente para representar una materia.
 */
public class MateriaResponseDto {
    private Long id;
    private String nombre;
    private CarreraResponseDto carrera;
    private List<MateriaRefDto> correlativas;

    public MateriaResponseDto() {
    }

    public MateriaResponseDto(Long id, String nombre, CarreraResponseDto carrera, List<MateriaRefDto> correlativas) {
        this.id = id;
        this.nombre = nombre;
        this.carrera = carrera;
        this.correlativas = correlativas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public CarreraResponseDto getCarrera() {
        return carrera;
    }

    public void setCarrera(CarreraResponseDto carrera) {
        this.carrera = carrera;
    }

    public List<MateriaRefDto> getCorrelativas() {
        return correlativas;
    }

    public void setCorrelativas(List<MateriaRefDto> correlativas) {
        this.correlativas = correlativas;
    }
}
