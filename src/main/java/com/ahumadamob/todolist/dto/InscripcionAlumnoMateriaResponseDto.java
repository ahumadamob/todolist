package com.ahumadamob.todolist.dto;

import java.time.LocalDate;

public class InscripcionAlumnoMateriaResponseDto {
    private Long id;
    private AlumnoResponseDto alumno;
    private CursoMateriaResponseDto cursoMateria;
    private LocalDate fechaInscripcion;
    private String estado;

    public InscripcionAlumnoMateriaResponseDto() {
    }

    public InscripcionAlumnoMateriaResponseDto(Long id, AlumnoResponseDto alumno,
            CursoMateriaResponseDto cursoMateria, LocalDate fechaInscripcion, String estado) {
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

    public AlumnoResponseDto getAlumno() {
        return alumno;
    }

    public void setAlumno(AlumnoResponseDto alumno) {
        this.alumno = alumno;
    }

    public CursoMateriaResponseDto getCursoMateria() {
        return cursoMateria;
    }

    public void setCursoMateria(CursoMateriaResponseDto cursoMateria) {
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
