package com.ahumadamob.todolist.dto;

import java.time.LocalDate;

public class InscripcionAlumnoMateriaRequestDto {
    private Long alumnoId;
    private Long cursoMateriaId;
    private LocalDate fechaInscripcion;
    private String estado;

    public InscripcionAlumnoMateriaRequestDto() {
    }

    public InscripcionAlumnoMateriaRequestDto(Long alumnoId, Long cursoMateriaId, LocalDate fechaInscripcion, String estado) {
        this.alumnoId = alumnoId;
        this.cursoMateriaId = cursoMateriaId;
        this.fechaInscripcion = fechaInscripcion;
        this.estado = estado;
    }

    public Long getAlumnoId() {
        return alumnoId;
    }

    public void setAlumnoId(Long alumnoId) {
        this.alumnoId = alumnoId;
    }

    public Long getCursoMateriaId() {
        return cursoMateriaId;
    }

    public void setCursoMateriaId(Long cursoMateriaId) {
        this.cursoMateriaId = cursoMateriaId;
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
