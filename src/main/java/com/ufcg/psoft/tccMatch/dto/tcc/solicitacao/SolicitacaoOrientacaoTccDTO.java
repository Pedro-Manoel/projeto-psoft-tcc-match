package com.ufcg.psoft.tccMatch.dto.tcc.solicitacao;

import com.ufcg.psoft.tccMatch.dto.ModelDTO;
import com.ufcg.psoft.tccMatch.dto.tcc.tema.TemaTccDTO;
import com.ufcg.psoft.tccMatch.dto.usuario.UsuarioDTO;
import io.swagger.v3.oas.annotations.Hidden;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SolicitacaoOrientacaoTccDTO extends ModelDTO {
    @Hidden
    private UsuarioDTO aluno;
    
    private Long idProfessor;

    @Hidden
    private TemaTccDTO temaTcc;

    private String tituloTemaTcc;

    @Hidden
    private RespostaSolicitacaoOrientacaoTccDTO resposta;
}
