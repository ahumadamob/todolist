package com.ahumadamob.todolist.dto;

/**
 * DTO enviado al cliente para representar un curso.
 */
public class CursoResponseDto {
    private Long id;
    private Integer anioCursado;
    private String division;
    private AnioAcademicoResponseDto anioAcademico;

    public CursoResponseDto() {
    }

    public CursoResponseDto(Long id, Integer anioCursado, String division, AnioAcademicoResponseDto anioAcademico) {
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

    public AnioAcademicoResponseDto getAnioAcademico() {
        return anioAcademico;
    }

    public void setAnioAcademico(AnioAcademicoResponseDto anioAcademico) {
        this.anioAcademico = anioAcademico;
    }
}
