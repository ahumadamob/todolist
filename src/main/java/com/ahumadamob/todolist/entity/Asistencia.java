package com.ahumadamob.todolist.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
public class Asistencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "inscripcion_id")
    private InscripcionAlumnoMateria inscripcion;

    private LocalDate fecha;

    private Boolean presente;

    private Boolean justificada;

    private String observaciones;

    public Asistencia() {
    }

    public Asistencia(Long id, InscripcionAlumnoMateria inscripcion, LocalDate fecha,
                      Boolean presente, Boolean justificada, String observaciones) {
        this.id = id;
        this.inscripcion = inscripcion;
        this.fecha = fecha;
        this.presente = presente;
        this.justificada = justificada;
        this.observaciones = observaciones;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public InscripcionAlumnoMateria getInscripcion() {
        return inscripcion;
    }

    public void setInscripcion(InscripcionAlumnoMateria inscripcion) {
        this.inscripcion = inscripcion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Boolean getPresente() {
        return presente;
    }

    public void setPresente(Boolean presente) {
        this.presente = presente;
    }

    public Boolean getJustificada() {
        return justificada;
    }

    public void setJustificada(Boolean justificada) {
        this.justificada = justificada;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}
