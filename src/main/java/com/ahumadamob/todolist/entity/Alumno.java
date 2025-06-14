package com.ahumadamob.todolist.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import com.ahumadamob.todolist.entity.EstadoAlumno;
import java.time.LocalDate;

@Entity
public class Alumno extends Persona {

    private String legajo;

    private LocalDate fechaIngreso;

    @Enumerated(EnumType.STRING)
    private EstadoAlumno estado;

    public Alumno() {
    }

    public Alumno(Long id, String nombre, String apellido, String fotoPerfil,
                   String legajo, LocalDate fechaIngreso, EstadoAlumno estado) {
        super(id, nombre, apellido, fotoPerfil);
        this.legajo = legajo;
        this.fechaIngreso = fechaIngreso;
        this.estado = estado;
    }

    public String getLegajo() {
        return legajo;
    }

    public void setLegajo(String legajo) {
        this.legajo = legajo;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public EstadoAlumno getEstado() {
        return estado;
    }

    public void setEstado(EstadoAlumno estado) {
        this.estado = estado;
    }
}
