package com.ahumadamob.todolist.dto;

/**
 * DTO utilizado para crear o actualizar un alumno.
 */
public class AlumnoRequestDto {
    private String nombre;
    private String apellido;
    private String fotoPerfil;

    public AlumnoRequestDto() {
    }

    public AlumnoRequestDto(String nombre, String apellido, String fotoPerfil) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fotoPerfil = fotoPerfil;
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
