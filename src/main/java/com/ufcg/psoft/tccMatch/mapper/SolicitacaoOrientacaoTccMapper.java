package com.ufcg.psoft.tccMatch.mapper;

import com.ufcg.psoft.tccMatch.dto.SolicitacaoOrientacaoTccDTO;
import com.ufcg.psoft.tccMatch.dto.TemaTccDTO;
import com.ufcg.psoft.tccMatch.model.SolicitacaoOrientacaoTcc;
import com.ufcg.psoft.tccMatch.model.TemaTcc;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(uses = { UsuarioMapper.class })
public interface SolicitacaoOrientacaoTccMapper {
    @Mapping(target = "temaTcc", source = "solicitacaoOrientacaoTcc.temaTcc.titulo")
    SolicitacaoOrientacaoTccDTO toDTO (SolicitacaoOrientacaoTcc solicitacaoOrientacaoTcc);

//    @Mapping(target = "id", ignore = true)
//    @Mapping(target = "aluno", ignore = true)
//    @Mapping(target = "resposta", ignore = true)
//    SolicitacaoOrientacaoTcc toEntity (SolicitacaoOrientacaoTccDTO solicitacaoOrientacaoTccDTO);

    List<SolicitacaoOrientacaoTccDTO> toDTOs (List<SolicitacaoOrientacaoTcc> solicitacoesOrientacaoTcc);
}
