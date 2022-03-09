package com.ufcg.psoft.tccMatch.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ErrorMessageDTO { 
    public ErrorMessageDTO(String message) {
		// TODO Auto-generated constructor stub
	}

	private String error;
}
