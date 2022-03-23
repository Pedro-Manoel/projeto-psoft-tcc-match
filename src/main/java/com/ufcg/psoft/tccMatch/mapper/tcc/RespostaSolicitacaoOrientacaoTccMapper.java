package com.ufcg.psoft.tccMatch.mapper.tcc;

import com.ufcg.psoft.tccMatch.dto.tcc.solicitacao.RespostaSolicitacaoOrientacaoTccDTO;
import com.ufcg.psoft.tccMatch.model.tcc.RespostaSolicitacaoOrientacaoTcc;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface RespostaSolicitacaoOrientacaoTccMapper {
    RespostaSolicitacaoOrientacaoTccDTO toDTO (RespostaSolicitacaoOrientacaoTcc respostaSolicitacaoOrientacaoTcc);

    @Mapping(target = "id", ignore = true)
    RespostaSolicitacaoOrientacaoTcc toEntity (RespostaSolicitacaoOrientacaoTccDTO respostaSolicitacaoOrientacaoTccDTO);
}
