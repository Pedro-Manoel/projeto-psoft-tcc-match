package com.ufcg.psoft.tccMatch.mapper;

import com.ufcg.psoft.tccMatch.dto.AreaEstudoDTO;
import com.ufcg.psoft.tccMatch.model.AreaEstudo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AreaEstudoMapper {
    AreaEstudoDTO toDTO (AreaEstudo areaEstudo);

    @Mapping(target = "id", ignore = true)
    AreaEstudo toEntity (AreaEstudoDTO areaEstudoDTO);
}
