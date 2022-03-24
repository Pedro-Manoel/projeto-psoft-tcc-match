package com.ufcg.psoft.tccMatch.notification.dto;

import com.ufcg.psoft.tccMatch.dto.ModelDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmailDTO extends ModelDTO {
    private String mensagem;

    private String data;
}
