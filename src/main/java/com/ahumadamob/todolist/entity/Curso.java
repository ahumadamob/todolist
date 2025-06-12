package com.ahumadamob.todolist.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "curso")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer anioCursado;

    private String division;

    @ManyToOne
    @JoinColumn(name = "anio_academico_id")
    private AnioAcademico anioAcademico;

    public Curso() {
    }

    public Curso(Long id, Integer anioCursado, String division, AnioAcademico anioAcademico) {
        this.id = id;
        this.anioCursado = anioCursado;
        this.division = division;
        this.anioAcademico = anioAcademico;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAnioCursado() {
        return anioCursado;
    }

    public void setAnioCursado(Integer anioCursado) {
        this.anioCursado = anioCursado;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public AnioAcademico getAnioAcademico() {
        return anioAcademico;
    }

    public void setAnioAcademico(AnioAcademico anioAcademico) {
        this.anioAcademico = anioAcademico;
    }
}
