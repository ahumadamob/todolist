package com.ahumadamob.todolist.dto;

/**
 * DTO utilizado para crear o actualizar un curso.
 */
public class CursoRequestDto {
    private Integer anioCursado;
    private String division;
    private Long anioAcademicoId;

    public CursoRequestDto() {
    }

    public CursoRequestDto(Integer anioCursado, String division, Long anioAcademicoId) {
        this.anioCursado = anioCursado;
        this.division = division;
        this.anioAcademicoId = anioAcademicoId;
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

    public Long getAnioAcademicoId() {
        return anioAcademicoId;
    }

    public void setAnioAcademicoId(Long anioAcademicoId) {
        this.anioAcademicoId = anioAcademicoId;
    }
}
