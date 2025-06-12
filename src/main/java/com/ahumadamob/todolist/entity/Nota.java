package com.ahumadamob.todolist.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Nota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "inscripcion_id")
    private InscripcionAlumnoMateria inscripcion;

    private String tipoEvaluacion;
    private String descripcion;
    private BigDecimal calificacion;
    private LocalDate fecha;
    private Boolean aprobado;

    public Nota() {
    }

    public Nota(Long id, InscripcionAlumnoMateria inscripcion, String tipoEvaluacion,
                String descripcion, BigDecimal calificacion, LocalDate fecha, Boolean aprobado) {
        this.id = id;
        this.inscripcion = inscripcion;
        this.tipoEvaluacion = tipoEvaluacion;
        this.descripcion = descripcion;
        this.calificacion = calificacion;
        this.fecha = fecha;
        this.aprobado = aprobado;
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

    public String getTipoEvaluacion() {
        return tipoEvaluacion;
    }

    public void setTipoEvaluacion(String tipoEvaluacion) {
        this.tipoEvaluacion = tipoEvaluacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(BigDecimal calificacion) {
        this.calificacion = calificacion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Boolean getAprobado() {
        return aprobado;
    }

    public void setAprobado(Boolean aprobado) {
        this.aprobado = aprobado;
    }
}
