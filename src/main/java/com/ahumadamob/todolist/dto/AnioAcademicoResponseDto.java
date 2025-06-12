package com.ahumadamob.todolist.dto;

/**
 * DTO enviado al cliente para representar un año académico.
 */
public class AnioAcademicoResponseDto {
    private Long id;
    private Integer anio;
    private Boolean activo;

    public AnioAcademicoResponseDto() {
    }

    public AnioAcademicoResponseDto(Long id, Integer anio, Boolean activo) {
        this.id = id;
        this.anio = anio;
        this.activo = activo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
