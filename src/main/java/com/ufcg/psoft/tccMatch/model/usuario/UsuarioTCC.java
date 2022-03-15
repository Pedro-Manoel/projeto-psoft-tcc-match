package com.ufcg.psoft.tccMatch.model.usuario;

import com.ufcg.psoft.tccMatch.model.AreaEstudo;
import com.ufcg.psoft.tccMatch.model.TemaTCC;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

// Escolher um nome melhor depois

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class UsuarioTCC extends Usuario {
    @OneToMany
    private List<AreaEstudo> areasEstudo;

    @OneToMany(cascade = CascadeType.ALL)
    private List<TemaTCC> temasTCC;

    public void adicionarAreaEstudo(AreaEstudo areaEstudo) {
        if (!this.areasEstudo.contains(areaEstudo)) {
            this.areasEstudo.add(areaEstudo);
        }
    }

    public void adicionarTemaTCC(TemaTCC temaTCC) {
        if (!this.temasTCC.contains(temaTCC)) {
            this.temasTCC.add(temaTCC);
        }
    }
}
