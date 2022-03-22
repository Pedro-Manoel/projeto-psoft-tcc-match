package com.ufcg.psoft.tccMatch.mapper;

import com.ufcg.psoft.tccMatch.dto.OrientacaoTccDTO;
import com.ufcg.psoft.tccMatch.dto.usuario.UsuarioDTO;
import com.ufcg.psoft.tccMatch.model.OrientacaoTcc;
import com.ufcg.psoft.tccMatch.model.usuario.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(uses = {UsuarioMapper.class})
public interface OrientacaoTccMapper {
    OrientacaoTccDTO toDTO (OrientacaoTcc orientacaoTcc);

    @Mapping(target = "id", ignore = true)
    OrientacaoTcc toEntity (OrientacaoTccDTO orientacaoTccDTO);
}
