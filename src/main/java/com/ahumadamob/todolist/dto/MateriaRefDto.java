package com.ahumadamob.todolist.dto;

/**
 * DTO simple para representar una materia como referencia.
 */
public class MateriaRefDto {
    private Long id;
    private String nombre;

    public MateriaRefDto() {
    }

    public MateriaRefDto(Long id, String nombre) {
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
