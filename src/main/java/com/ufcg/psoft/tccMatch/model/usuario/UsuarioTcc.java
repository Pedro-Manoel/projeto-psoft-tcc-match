package com.ufcg.psoft.tccMatch.model.usuario;

import com.ufcg.psoft.tccMatch.error.exception.TemaTccInvalidoUsuarioException;
import com.ufcg.psoft.tccMatch.model.AreaEstudo;
import com.ufcg.psoft.tccMatch.model.tcc.TemaTcc;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class UsuarioTcc extends Usuario {
    @ManyToMany
    private List<AreaEstudo> areasEstudo;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<TemaTcc> temasTcc;

    public void adicionarTemaTcc(TemaTcc temaTcc) {
        if (!this.temasTcc.contains(temaTcc)) {
            this.temasTcc.add(temaTcc);
        }
    }

    public TemaTcc getTemaTcc (Long id) {
        return this.temasTcc
                .stream()
                .filter(temaTcc -> temaTcc.getId().equals(id))
                .findAny()
                .orElseThrow(() -> new TemaTccInvalidoUsuarioException("id", id.toString()));
    }

    public TemaTcc getTemaTcc (String titulo) {
        return this.temasTcc
                .stream()
                .filter(temaTcc -> temaTcc.getTitulo().equals(titulo))
                .findAny()
                .orElseThrow(() -> new TemaTccInvalidoUsuarioException("título", titulo));
    }
}
