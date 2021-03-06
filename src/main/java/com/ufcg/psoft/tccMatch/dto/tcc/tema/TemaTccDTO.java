package com.ufcg.psoft.tccMatch.dto.tcc.tema;

import com.ufcg.psoft.tccMatch.dto.AreaEstudoDTO;
import com.ufcg.psoft.tccMatch.dto.ModelDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TemaTccDTO extends ModelDTO {
    private String titulo;

    private String descricao;

    private List<AreaEstudoDTO> areasEstudo;

    private String status;
}
