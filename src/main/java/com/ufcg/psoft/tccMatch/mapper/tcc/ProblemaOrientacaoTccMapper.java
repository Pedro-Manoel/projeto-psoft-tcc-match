package com.ufcg.psoft.tccMatch.mapper.tcc;

import com.ufcg.psoft.tccMatch.dto.tcc.ProblemaOrientacaoTccDTO;
import com.ufcg.psoft.tccMatch.mapper.usuario.UsuarioMapper;
import com.ufcg.psoft.tccMatch.model.tcc.ProblemaOrientacaoTcc;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(uses = { UsuarioMapper.class })
public interface ProblemaOrientacaoTccMapper {
    @Mapping(target = "idOrientacaoTcc", source = "problemaOrientacaoTcc.orientacaoTcc.id")
    ProblemaOrientacaoTccDTO toDTO (ProblemaOrientacaoTcc problemaOrientacaoTcc);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "usuario", ignore = true)
    ProblemaOrientacaoTcc toEntity (ProblemaOrientacaoTccDTO problemaOrientacaoTccDTO);

    List<ProblemaOrientacaoTccDTO> toDTOs (List<ProblemaOrientacaoTcc> problemasOrientacaoTcc);
}
