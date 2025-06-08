package com.ahumadamob.todolist.dto;

/**
 * DTO utilizado para crear o actualizar una carrera.
 */
public class CarreraRequestDto {
    private String nombre;

    public CarreraRequestDto() {
    }

    public CarreraRequestDto(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
