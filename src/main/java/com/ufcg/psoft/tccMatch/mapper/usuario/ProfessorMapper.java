package com.ufcg.psoft.tccMatch.mapper.usuario;

import com.ufcg.psoft.tccMatch.dto.usuario.AlunoDTO;
import com.ufcg.psoft.tccMatch.dto.usuario.ProfessorDTO;
import com.ufcg.psoft.tccMatch.model.usuario.Aluno;
import com.ufcg.psoft.tccMatch.model.usuario.Professor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProfessorMapper {
    @Mapping(target = "senha", ignore = true)
    ProfessorDTO toDTO (Professor professor);

    @Mapping(target = "id", ignore = true)
    Professor toEntity (ProfessorDTO professorDTO);

    @Mapping(target = "id", ignore = true)
    void toUpdateEntity (ProfessorDTO professorDTO, @MappingTarget Professor professor);
}
