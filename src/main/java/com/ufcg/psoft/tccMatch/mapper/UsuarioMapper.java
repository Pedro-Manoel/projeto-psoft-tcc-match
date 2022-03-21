package com.ufcg.psoft.tccMatch.mapper;

import com.ufcg.psoft.tccMatch.dto.TemaTccDTO;
import com.ufcg.psoft.tccMatch.dto.usuario.AlunoDTO;
import com.ufcg.psoft.tccMatch.dto.usuario.UsuarioDTO;
import com.ufcg.psoft.tccMatch.model.TemaTcc;
import com.ufcg.psoft.tccMatch.model.usuario.Aluno;
import com.ufcg.psoft.tccMatch.model.usuario.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface UsuarioMapper {
    @Mapping(target = "senha", ignore = true)
    UsuarioDTO toDTO (Usuario usuario);

    @Mapping(target = "id", ignore = true)
    Usuario toEntity (UsuarioDTO usuarioDTO);

    List<UsuarioDTO> toDTOs (List<Usuario> usuarios);
}
