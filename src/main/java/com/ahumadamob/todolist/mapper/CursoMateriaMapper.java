package com.ahumadamob.todolist.mapper;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ahumadamob.todolist.entity.DiaSemana;

import com.ahumadamob.todolist.dto.AulaResponseDto;
import com.ahumadamob.todolist.dto.CursoMateriaRequestDto;
import com.ahumadamob.todolist.dto.CursoMateriaResponseDto;
import com.ahumadamob.todolist.dto.CursoResponseDto;
import com.ahumadamob.todolist.dto.MateriaResponseDto;
import com.ahumadamob.todolist.dto.ModalidadResponseDto;
import com.ahumadamob.todolist.dto.ModuloHoraResponseDto;
import com.ahumadamob.todolist.dto.ProfesorResponseDto;
import com.ahumadamob.todolist.entity.Aula;
import com.ahumadamob.todolist.entity.Curso;
import com.ahumadamob.todolist.entity.CursoMateria;
import com.ahumadamob.todolist.entity.Materia;
import com.ahumadamob.todolist.entity.Modalidad;
import com.ahumadamob.todolist.entity.ModuloHora;
import com.ahumadamob.todolist.entity.Profesor;
import com.ahumadamob.todolist.exception.RecordNotFoundException;
import com.ahumadamob.todolist.repository.AulaRepository;
import com.ahumadamob.todolist.repository.CursoRepository;
import com.ahumadamob.todolist.repository.MateriaRepository;
import com.ahumadamob.todolist.repository.ModalidadRepository;
import com.ahumadamob.todolist.repository.ModuloHoraRepository;
import com.ahumadamob.todolist.repository.ProfesorRepository;

@Component
public class CursoMateriaMapper {

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private MateriaRepository materiaRepository;

    @Autowired
    private ProfesorRepository profesorRepository;

    @Autowired
    private AulaRepository aulaRepository;

    @Autowired
    private ModuloHoraRepository moduloHoraRepository;

    @Autowired
    private ModalidadRepository modalidadRepository;

    @Autowired
    private CursoMapper cursoMapper;

    @Autowired
    private MateriaMapper materiaMapper;

    @Autowired
    private ProfesorMapper profesorMapper;

    public CursoMateria toEntity(CursoMateriaRequestDto dto) {
        CursoMateria cm = new CursoMateria();
        applyToEntity(dto, cm);
        return cm;
    }

    public void applyToEntity(CursoMateriaRequestDto dto, CursoMateria cm) {
        if (dto.getCursoId() != null) {
            Curso curso = cursoRepository.findById(dto.getCursoId())
                    .orElseThrow(() -> new RecordNotFoundException("cursoId", "Curso no encontrado"));
            cm.setCurso(curso);
        } else {
            cm.setCurso(null);
        }

        if (dto.getMateriaId() != null) {
            Materia materia = materiaRepository.findById(dto.getMateriaId())
                    .orElseThrow(() -> new RecordNotFoundException("materiaId", "Materia no encontrada"));
            cm.setMateria(materia);
        } else {
            cm.setMateria(null);
        }

        if (dto.getProfesorId() != null) {
            Profesor profesor = profesorRepository.findById(dto.getProfesorId())
                    .orElseThrow(() -> new RecordNotFoundException("profesorId", "Profesor no encontrado"));
            cm.setProfesor(profesor);
        } else {
            cm.setProfesor(null);
        }

        if (dto.getAulaId() != null) {
            Aula aula = aulaRepository.findById(dto.getAulaId())
                    .orElseThrow(() -> new RecordNotFoundException("aulaId", "Aula no encontrada"));
            cm.setAula(aula);
        } else {
            cm.setAula(null);
        }

        List<DiaSemana> dias = dto.getDiasSemana();
        if (dias != null) {
            cm.setDiasSemana(new ArrayList<>(dto.getDiasSemana()));
        } else {
            cm.setDiasSemana(new ArrayList<>());
        }

        if (dto.getModuloHoraId() != null) {
            ModuloHora modulo = moduloHoraRepository.findById(dto.getModuloHoraId())
                    .orElseThrow(() -> new RecordNotFoundException("moduloHoraId", "Módulo hora no encontrado"));
            cm.setModuloHora(modulo);
        } else {
            cm.setModuloHora(null);
        }

        if (dto.getModalidadId() != null) {
            Modalidad mod = modalidadRepository.findById(dto.getModalidadId())
                    .orElseThrow(() -> new RecordNotFoundException("modalidadId", "Modalidad no encontrada"));
            cm.setModalidad(mod);
        } else {
            cm.setModalidad(null);
        }
    }

    public CursoMateriaResponseDto toDto(CursoMateria cm) {
        CursoResponseDto cursoDto = null;
        if (cm.getCurso() != null) {
            cursoDto = cursoMapper.toDto(cm.getCurso());
        }
        MateriaResponseDto materiaDto = null;
        if (cm.getMateria() != null) {
            materiaDto = materiaMapper.toDto(cm.getMateria());
        }
        ProfesorResponseDto profesorDto = null;
        if (cm.getProfesor() != null) {
            profesorDto = profesorMapper.toDto(cm.getProfesor());
        }
        AulaResponseDto aulaDto = null;
        if (cm.getAula() != null) {
            Aula a = cm.getAula();
            aulaDto = new AulaResponseDto(a.getId(), a.getNombre(), a.getUbicacion(), a.getCapacidad());
        }
        ModuloHoraResponseDto moduloHoraDto = null;
        if (cm.getModuloHora() != null) {
            ModuloHora m = cm.getModuloHora();
            moduloHoraDto = new ModuloHoraResponseDto(m.getId(), m.getNombre(), m.getHoraInicio(), m.getHoraFin());
        }
        ModalidadResponseDto modalidadDto = null;
        if (cm.getModalidad() != null) {
            Modalidad m = cm.getModalidad();
            modalidadDto = new ModalidadResponseDto(m.getId(), m.getNombre());
        }
        List<DiaSemana> diasSemana = cm.getDiasSemana() != null ? new ArrayList<>(cm.getDiasSemana()) : new ArrayList<>();
        return new CursoMateriaResponseDto(cm.getId(), cursoDto, materiaDto, profesorDto, aulaDto,
                diasSemana, moduloHoraDto, modalidadDto);
    }
}
