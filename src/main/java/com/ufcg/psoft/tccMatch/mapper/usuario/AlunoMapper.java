package com.ufcg.psoft.tccMatch.mapper.usuario;

import com.ufcg.psoft.tccMatch.dto.usuario.AlunoDTO;
import com.ufcg.psoft.tccMatch.model.usuario.Aluno;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper
public interface AlunoMapper {
    @Mapping(target = "senha", ignore = true)
    AlunoDTO toDTO (Aluno aluno);

    @Mapping(target = "id", ignore = true)
    Aluno toEntity (AlunoDTO alunoDTO);

    @Mapping(target = "id", ignore = true)
    void toUpdateEntity (AlunoDTO alunoDTO, @MappingTarget Aluno aluno);
}
