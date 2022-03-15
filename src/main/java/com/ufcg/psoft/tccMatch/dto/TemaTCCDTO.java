package com.ufcg.psoft.tccMatch.dto;

import com.ufcg.psoft.tccMatch.model.AreaEstudo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TemaTCCDTO {
    private String titulo;

    private String descricao;

    private List<String> areasEstudo;

    private String status;
}
