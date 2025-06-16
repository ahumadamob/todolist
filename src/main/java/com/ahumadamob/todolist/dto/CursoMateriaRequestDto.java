package com.ahumadamob.todolist.dto;

import java.util.List;
import com.ahumadamob.todolist.entity.DiaSemana;

public class CursoMateriaRequestDto {
    private Long cursoId;
    private Long materiaId;
    private Long profesorId;
    private Long aulaId;
    private List<DiaSemana> diasSemana;
    private Long moduloHoraId;
    private Long modalidadId;

    public CursoMateriaRequestDto() {
    }

    public CursoMateriaRequestDto(Long cursoId, Long materiaId, Long profesorId, Long aulaId,
            List<DiaSemana> diasSemana, Long moduloHoraId, Long modalidadId) {
        this.cursoId = cursoId;
        this.materiaId = materiaId;
        this.profesorId = profesorId;
        this.aulaId = aulaId;
        this.diasSemana = diasSemana;
        this.moduloHoraId = moduloHoraId;
        this.modalidadId = modalidadId;
    }

    public Long getCursoId() {
        return cursoId;
    }

    public void setCursoId(Long cursoId) {
        this.cursoId = cursoId;
    }

    public Long getMateriaId() {
        return materiaId;
    }

    public void setMateriaId(Long materiaId) {
        this.materiaId = materiaId;
    }

    public Long getProfesorId() {
        return profesorId;
    }

    public void setProfesorId(Long profesorId) {
        this.profesorId = profesorId;
    }

    public Long getAulaId() {
        return aulaId;
    }

    public void setAulaId(Long aulaId) {
        this.aulaId = aulaId;
    }

    public List<DiaSemana> getDiasSemana() {
        return diasSemana;
    }

    public void setDiasSemana(List<DiaSemana> diasSemana) {
        this.diasSemana = diasSemana;
    }

    public Long getModuloHoraId() {
        return moduloHoraId;
    }

    public void setModuloHoraId(Long moduloHoraId) {
        this.moduloHoraId = moduloHoraId;
    }

    public Long getModalidadId() {
        return modalidadId;
    }

    public void setModalidadId(Long modalidadId) {
        this.modalidadId = modalidadId;
    }
}
