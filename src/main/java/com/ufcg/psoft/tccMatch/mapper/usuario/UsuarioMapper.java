package com.ufcg.psoft.tccMatch.mapper.usuario;

import com.ufcg.psoft.tccMatch.dto.usuario.UsuarioDTO;
import com.ufcg.psoft.tccMatch.model.usuario.Usuario;
import com.ufcg.psoft.tccMatch.model.usuario.UsuarioTcc;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface UsuarioMapper {
    @Mapping(target = "senha", ignore = true)
    UsuarioDTO toDTO (Usuario usuario);

    List<UsuarioDTO> toDTOs (List<Usuario> usuarios);
}
