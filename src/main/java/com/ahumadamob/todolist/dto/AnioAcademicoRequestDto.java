package com.ahumadamob.todolist.dto;

/**
 * DTO utilizado para crear o actualizar un año académico.
 */
public class AnioAcademicoRequestDto {
    private Integer anio;
    private Boolean activo;

    public AnioAcademicoRequestDto() {
    }

    public AnioAcademicoRequestDto(Integer anio, Boolean activo) {
        this.anio = anio;
        this.activo = activo;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
}
