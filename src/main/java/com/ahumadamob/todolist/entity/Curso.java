package com.ahumadamob.todolist.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "curso")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "El año cursado es obligatorio")
    @Digits(integer = 1, fraction = 0, message = "El año cursado debe ser de un único dígito")
    private Integer anioCursado;

    @NotBlank(message = "La división es obligatoria")
    @Size(min = 1, max = 1, message = "La división debe tener solo 1 carácter")
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
