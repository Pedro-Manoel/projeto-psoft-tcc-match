package com.ufcg.psoft.tccMatch.mapper.tcc;

import com.ufcg.psoft.tccMatch.dto.tcc.ProblemaOrientacaoTccDTO;
import com.ufcg.psoft.tccMatch.mapper.usuario.UsuarioMapper;
import com.ufcg.psoft.tccMatch.model.tcc.ProblemaOrientacaoTcc;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = { UsuarioMapper.class })
public interface ProblemaOrientacaoTccMapper {
    ProblemaOrientacaoTccDTO toDTO (ProblemaOrientacaoTcc problemaOrientacaoTcc);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "usuario", ignore = true)
    ProblemaOrientacaoTcc toEntity (ProblemaOrientacaoTccDTO problemaOrientacaoTccDTO);
}
