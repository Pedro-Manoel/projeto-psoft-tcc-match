package com.ufcg.psoft.tccMatch.mapper.tcc;

import com.ufcg.psoft.tccMatch.dto.tcc.OrientacaoTccDTO;
import com.ufcg.psoft.tccMatch.mapper.usuario.UsuarioMapper;
import com.ufcg.psoft.tccMatch.model.tcc.OrientacaoTcc;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(uses = {UsuarioMapper.class})
public interface OrientacaoTccMapper {
    OrientacaoTccDTO toDTO (OrientacaoTcc orientacaoTcc);

    @Mapping(target = "id", ignore = true)
    OrientacaoTcc toEntity (OrientacaoTccDTO orientacaoTccDTO);

    List<OrientacaoTccDTO> toDTOs (List<OrientacaoTcc> orientacoesTcc);
}
