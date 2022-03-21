package com.ufcg.psoft.tccMatch.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.ufcg.psoft.tccMatch.dto.usuario.AlunoDTO;
import com.ufcg.psoft.tccMatch.dto.usuario.UsuarioDTO;
import com.ufcg.psoft.tccMatch.model.RespostaSolicitacaoOrientacaoTcc;
import com.ufcg.psoft.tccMatch.model.TemaTcc;
import com.ufcg.psoft.tccMatch.model.usuario.Aluno;
import com.ufcg.psoft.tccMatch.model.usuario.Professor;
import io.swagger.v3.oas.annotations.Hidden;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SolicitacaoOrientacaoTccDTO extends ModelDTO {
    @Hidden
    private UsuarioDTO aluno;

    private Long professorId;

    private String temaTcc;

    @Hidden
    private RespostaSolicitacaoOrientacaoTccDTO resposta;
}
