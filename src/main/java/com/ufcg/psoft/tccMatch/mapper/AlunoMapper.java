package com.ufcg.psoft.tccMatch.mapper;

import com.ufcg.psoft.tccMatch.dto.usuario.AlunoDTO;
import com.ufcg.psoft.tccMatch.model.usuario.Aluno;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AlunoMapper {
    AlunoMapper INSTANCE = Mappers.getMapper(AlunoMapper.class);

    AlunoDTO toDTO (Aluno aluno);

    @Mapping(target = "id", ignore = true)
    Aluno toEntity (AlunoDTO alunoDTO);

    default Aluno toEntity (Aluno aluno, AlunoDTO alunoDTO) {
        Aluno entity = this.toEntity(alunoDTO);
        entity.setId(aluno.getId());
        return entity;
    }

    // List<AlunoDTO> toDTOs (List<Aluno> alunos);
}
