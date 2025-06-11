package com.ahumadamob.todolist.entity;

import jakarta.persistence.Entity;

@Entity
public class Alumno extends Persona {
    public Alumno() {
    }

    public Alumno(Long id, String nombre, String apellido, String fotoPerfil) {
        super(id, nombre, apellido, fotoPerfil);
    }
}
