package com.ufcg.psoft.tccMatch.mapper.tcc;

import com.ufcg.psoft.tccMatch.dto.tcc.solicitacao.SolicitacaoOrientacaoTccDTO;
import com.ufcg.psoft.tccMatch.mapper.usuario.UsuarioMapper;
import com.ufcg.psoft.tccMatch.model.tcc.SolicitacaoOrientacaoTcc;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(uses = { UsuarioMapper.class, RespostaSolicitacaoOrientacaoTccMapper.class })
public interface SolicitacaoOrientacaoTccMapper {
    SolicitacaoOrientacaoTccDTO toDTO (SolicitacaoOrientacaoTcc solicitacaoOrientacaoTcc);

    List<SolicitacaoOrientacaoTccDTO> toDTOs (List<SolicitacaoOrientacaoTcc> solicitacoesOrientacaoTcc);
}
