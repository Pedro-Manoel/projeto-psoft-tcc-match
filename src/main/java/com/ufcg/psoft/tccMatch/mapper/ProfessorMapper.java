package com.ufcg.psoft.tccMatch.mapper;

import com.ufcg.psoft.tccMatch.dto.usuario.AlunoDTO;
import com.ufcg.psoft.tccMatch.dto.usuario.ProfessorDTO;
import com.ufcg.psoft.tccMatch.model.usuario.Aluno;
import com.ufcg.psoft.tccMatch.model.usuario.Professor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProfessorMapper {
    ProfessorMapper INSTANCE = Mappers.getMapper(ProfessorMapper.class);

    ProfessorDTO toDTO (Professor professor);

    @Mapping(target = "id", ignore = true)
    Professor toEntity (ProfessorDTO professorDTO);

    default Professor toEntity (Professor professor, ProfessorDTO professorDTO) {
        Professor entity = this.toEntity(professorDTO);
        entity.setId(professor.getId());
        return entity;
    }
}
