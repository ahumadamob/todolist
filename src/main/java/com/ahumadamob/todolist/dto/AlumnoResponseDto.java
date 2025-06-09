package com.ahumadamob.todolist.dto;

/**
 * DTO enviado al cliente para representar un alumno.
 */
public class AlumnoResponseDto {
    private Long id;
    private String nombre;
    private String apellido;
    private String fotoPerfil;

    public AlumnoResponseDto() {
    }

    public AlumnoResponseDto(Long id, String nombre, String apellido, String fotoPerfil) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fotoPerfil = fotoPerfil;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFotoPerfil() {
        return fotoPerfil;
    }

    public void setFotoPerfil(String fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }
}
