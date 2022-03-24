package com.ufcg.psoft.tccMatch.service.tcc;

import com.ufcg.psoft.tccMatch.dto.tcc.OrientacaoTccDTO;
import com.ufcg.psoft.tccMatch.dto.tcc.relatorio.RelatorioOrientacaoTccDTO;
import com.ufcg.psoft.tccMatch.model.tcc.OrientacaoTcc;

import java.util.List;

public interface OrientacaoTccService {
    OrientacaoTccDTO criarOrientacaoTcc (OrientacaoTccDTO orientacaoTccDTO);

    OrientacaoTcc getOrientacaoTcc (Long id);

    OrientacaoTccDTO finalizarOrientacaoTcc (Long id);

    List<OrientacaoTccDTO> listarOrientacoesTccEmCursoProfessor (Long id);

    List<OrientacaoTccDTO> listarOrientacoesTcc (Boolean concluida, String semestre);

    RelatorioOrientacaoTccDTO gerarRelatorio (String semestre);
}
