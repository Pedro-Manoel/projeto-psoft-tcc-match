package com.ufcg.psoft.tccMatch.dto.tcc;

import com.ufcg.psoft.tccMatch.dto.ModelDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ManifestacaoOrientacaoTccDTO extends ModelDTO {
    private Long idAluno;

    private String tituloTemaTcc;
}
