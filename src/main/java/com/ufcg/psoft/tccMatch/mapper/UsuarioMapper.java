package com.ufcg.psoft.tccMatch.mapper;

import com.ufcg.psoft.tccMatch.dto.usuario.AlunoDTO;
import com.ufcg.psoft.tccMatch.dto.usuario.UsuarioDTO;
import com.ufcg.psoft.tccMatch.model.usuario.Aluno;
import com.ufcg.psoft.tccMatch.model.usuario.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface UsuarioMapper {
    @Mapping(target = "senha", ignore = true)
    UsuarioDTO toDTO (Usuario usuario);

    @Mapping(target = "id", ignore = true)
    Usuario toEntity (UsuarioDTO usuarioDTO);
}
