package com.ufcg.psoft.tccMatch.model.usuario;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ufcg.psoft.tccMatch.model.AreaEstudo;
import com.ufcg.psoft.tccMatch.model.TemaTCC;
import com.ufcg.psoft.tccMatch.model.usuario.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.awt.geom.Area;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Aluno extends UsuarioTCC {
    private String matricula;
    
    private String periodoPrevistoConclusao;
}
