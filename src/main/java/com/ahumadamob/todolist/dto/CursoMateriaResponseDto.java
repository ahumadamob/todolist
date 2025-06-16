package com.ahumadamob.todolist.dto;

import java.util.List;
import com.ahumadamob.todolist.entity.DiaSemana;

public class CursoMateriaResponseDto {
    private Long id;
    private CursoResponseDto curso;
    private MateriaResponseDto materia;
    private ProfesorResponseDto profesor;
    private AulaResponseDto aula;
    private List<DiaSemana> diasSemana;
    private ModuloHoraResponseDto moduloHora;
    private ModalidadResponseDto modalidad;

    public CursoMateriaResponseDto() {
    }

    public CursoMateriaResponseDto(Long id, CursoResponseDto curso, MateriaResponseDto materia,
            ProfesorResponseDto profesor, AulaResponseDto aula, List<DiaSemana> diasSemana,
            ModuloHoraResponseDto moduloHora, ModalidadResponseDto modalidad) {
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

    public CursoResponseDto getCurso() {
        return curso;
    }

    public void setCurso(CursoResponseDto curso) {
        this.curso = curso;
    }

    public MateriaResponseDto getMateria() {
        return materia;
    }

    public void setMateria(MateriaResponseDto materia) {
        this.materia = materia;
    }

    public ProfesorResponseDto getProfesor() {
        return profesor;
    }

    public void setProfesor(ProfesorResponseDto profesor) {
        this.profesor = profesor;
    }

    public AulaResponseDto getAula() {
        return aula;
    }

    public void setAula(AulaResponseDto aula) {
        this.aula = aula;
    }

    public List<DiaSemana> getDiasSemana() {
        return diasSemana;
    }

    public void setDiasSemana(List<DiaSemana> diasSemana) {
        this.diasSemana = diasSemana;
    }

    public ModuloHoraResponseDto getModuloHora() {
        return moduloHora;
    }

    public void setModuloHora(ModuloHoraResponseDto moduloHora) {
        this.moduloHora = moduloHora;
    }

    public ModalidadResponseDto getModalidad() {
        return modalidad;
    }

    public void setModalidad(ModalidadResponseDto modalidad) {
        this.modalidad = modalidad;
    }
}
