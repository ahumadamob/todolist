package com.ahumadamob.todolist.entity;

import jakarta.persistence.Entity;

@Entity
public class Profesor extends Persona {
    public Profesor() {
    }

    public Profesor(Long id, String nombre, String apellido, String fotoPerfil) {
        super(id, nombre, apellido, fotoPerfil);
    }
}
