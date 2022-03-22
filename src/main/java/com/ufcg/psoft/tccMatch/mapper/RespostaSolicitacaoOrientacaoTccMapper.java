package com.ufcg.psoft.tccMatch.mapper;

import com.ufcg.psoft.tccMatch.dto.RespostaSolicitacaoOrientacaoTccDTO;
import com.ufcg.psoft.tccMatch.dto.SolicitacaoOrientacaoTccDTO;
import com.ufcg.psoft.tccMatch.model.RespostaSolicitacaoOrientacaoTcc;
import com.ufcg.psoft.tccMatch.model.SolicitacaoOrientacaoTcc;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface RespostaSolicitacaoOrientacaoTccMapper {
    RespostaSolicitacaoOrientacaoTccDTO toDTO (RespostaSolicitacaoOrientacaoTcc respostaSolicitacaoOrientacaoTcc);

    @Mapping(target = "id", ignore = true)
    RespostaSolicitacaoOrientacaoTcc toEntity (RespostaSolicitacaoOrientacaoTccDTO respostaSolicitacaoOrientacaoTccDTO);

}