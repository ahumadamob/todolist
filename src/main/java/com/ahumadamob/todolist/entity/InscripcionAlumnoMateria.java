package com.ahumadamob.todolist.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
public class InscripcionAlumnoMateria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "alumno_id")
    private Alumno alumno;

    @ManyToOne
    @JoinColumn(name = "curso_materia_id")
    private CursoMateria cursoMateria;

    private LocalDate fechaInscripcion;

    private String estado;

    public InscripcionAlumnoMateria() {
    }

    public InscripcionAlumnoMateria(Long id, Alumno alumno, CursoMateria cursoMateria,
                                    LocalDate fechaInscripcion, String estado) {
        this.id = id;
        this.alumno = alumno;
        this.cursoMateria = cursoMateria;
        this.fechaInscripcion = fechaInscripcion;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public CursoMateria getCursoMateria() {
        return cursoMateria;
    }

    public void setCursoMateria(CursoMateria cursoMateria) {
        this.cursoMateria = cursoMateria;
    }

    public LocalDate getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(LocalDate fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
