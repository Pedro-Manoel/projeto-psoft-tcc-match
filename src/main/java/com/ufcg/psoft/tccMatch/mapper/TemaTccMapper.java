package com.ufcg.psoft.tccMatch.mapper;

import com.ufcg.psoft.tccMatch.dto.TemaTccDTO;
import com.ufcg.psoft.tccMatch.model.TemaTcc;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = {AreaEstudoMapper.class})
public interface TemaTccMapper {
    TemaTccDTO toDTO (TemaTcc temaTcc);

    @Mapping(target = "id", ignore = true)
    TemaTcc toEntity (TemaTccDTO temaTccDTO);
}

