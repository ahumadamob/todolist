package com.ahumadamob.todolist.dto;

/**
 * DTO enviado al cliente para representar una carrera.
 */
public class CarreraResponseDto {
    private Long id;
    private String nombre;

    public CarreraResponseDto() {
    }

    public CarreraResponseDto(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
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
}
