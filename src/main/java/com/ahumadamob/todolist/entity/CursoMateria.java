package com.ahumadamob.todolist.entity;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.util.ArrayList;
import java.util.List;

@Entity
public class CursoMateria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    @ManyToOne
    @JoinColumn(name = "materia_id")
    private Materia materia;

    @ManyToOne
    @JoinColumn(name = "profesor_id")
    private Profesor profesor;

    @ManyToOne
    @JoinColumn(name = "aula_id")
    private Aula aula;

    @ElementCollection
    @CollectionTable(name = "curso_materia_dias", joinColumns = @JoinColumn(name = "curso_materia_id"))
    @Column(name = "dia_semana")
    @Enumerated(EnumType.STRING)
    private List<DiaSemana> diasSemana = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "modulo_hora_id")
    private ModuloHora moduloHora;

    @ManyToOne
    @JoinColumn(name = "modalidad_id")
    private Modalidad modalidad;

    public CursoMateria() {
    }

    public CursoMateria(Long id, Curso curso, Materia materia, Profesor profesor, Aula aula,
                        List<DiaSemana> diasSemana, ModuloHora moduloHora, Modalidad modalidad) {
        this.id = id;
        this.curso = curso;
        this.materia = materia;
        this.profesor = profesor;
        this.aula = aula;
        this.diasSemana = diasSemana;
        this.moduloHora = moduloHora;
        this.modalidad = modalidad;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public Aula getAula() {
        return aula;
    }

    public void setAula(Aula aula) {
        this.aula = aula;
    }

    public List<DiaSemana> getDiasSemana() {
        return diasSemana;
    }

    public void setDiasSemana(List<DiaSemana> diasSemana) {
        this.diasSemana = diasSemana;
    }

    public ModuloHora getModuloHora() {
        return moduloHora;
    }

    public void setModuloHora(ModuloHora moduloHora) {
        this.moduloHora = moduloHora;
    }

    public Modalidad getModalidad() {
        return modalidad;
    }

    public void setModalidad(Modalidad modalidad) {
        this.modalidad = modalidad;
    }
}
