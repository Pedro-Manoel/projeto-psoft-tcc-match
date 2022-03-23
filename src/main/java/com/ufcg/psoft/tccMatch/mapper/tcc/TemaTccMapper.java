package com.ufcg.psoft.tccMatch.mapper.tcc;

import com.ufcg.psoft.tccMatch.dto.tcc.tema.TemaTccDTO;
import com.ufcg.psoft.tccMatch.mapper.AreaEstudoMapper;
import com.ufcg.psoft.tccMatch.model.tcc.TemaTcc;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(uses = { AreaEstudoMapper.class })
public interface TemaTccMapper {
    TemaTccDTO toDTO (TemaTcc temaTcc);

    @Mapping(target = "id", ignore = true)
    TemaTcc toEntity (TemaTccDTO temaTccDTO);

    List<TemaTccDTO> toDTOs (List<TemaTcc> temasTcc);
}

