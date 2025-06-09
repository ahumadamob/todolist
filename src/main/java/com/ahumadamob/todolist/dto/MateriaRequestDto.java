package com.ahumadamob.todolist.dto;

import java.util.List;

/**
 * DTO utilizado para crear o actualizar una materia.
 */
public class MateriaRequestDto {
    private String nombre;
    private Long carreraId;
    private List<Long> correlativaIds;

    public MateriaRequestDto() {
    }

    public MateriaRequestDto(String nombre, Long carreraId, List<Long> correlativaIds) {
        this.nombre = nombre;
        this.carreraId = carreraId;
        this.correlativaIds = correlativaIds;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getCarreraId() {
        return carreraId;
    }

    public void setCarreraId(Long carreraId) {
        this.carreraId = carreraId;
    }

    public List<Long> getCorrelativaIds() {
        return correlativaIds;
    }

    public void setCorrelativaIds(List<Long> correlativaIds) {
        this.correlativaIds = correlativaIds;
    }
}
