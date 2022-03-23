package com.ufcg.psoft.tccMatch.model.usuario;

import com.ufcg.psoft.tccMatch.security.util.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Aluno extends UsuarioTcc {
    private String matricula;
    
    private String periodoPrevistoConclusao;

    public String getAutoridade() { return Role.USER_ALUNO; }
}
