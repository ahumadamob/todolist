package com.ahumadamob.todolist.entity;

import jakarta.persistence.Entity;
import java.time.LocalDate;

@Entity
public class Profesor extends Persona {

    private String titulo;

    private LocalDate fechaAlta;

    public Profesor() {
    }

    public Profesor(Long id, String nombre, String apellido, String fotoPerfil,
                     String titulo, LocalDate fechaAlta) {
        super(id, nombre, apellido, fotoPerfil);
        this.titulo = titulo;
        this.fechaAlta = fechaAlta;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDate fechaAlta) {
        this.fechaAlta = fechaAlta;
    }
}
