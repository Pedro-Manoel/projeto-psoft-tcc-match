package com.ufcg.psoft.tccMatch.model.usuario;

import com.ufcg.psoft.tccMatch.model.OrientacaoTcc;
import com.ufcg.psoft.tccMatch.model.ProblemaOrientacaoTcc;
import com.ufcg.psoft.tccMatch.security.util.Role;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import java.util.List;

@Entity
public class Coordenador extends Usuario{

    @Transient
    public String getAutoridade() { return Role.USER_ADMIN; }

    @OneToMany
    private List<OrientacaoTcc> orientacoesTcc;

    @OneToMany (cascade = CascadeType.ALL)
	private List<ProblemaOrientacaoTcc> problemasOrientacaoTcc;

    public void adicionarProblemaOrientacaoTcc(ProblemaOrientacaoTcc problemaOrientacaoTcc) {
        this.problemasOrientacaoTcc.add(problemaOrientacaoTcc);
    }

    public void adicionarOrientacaoTcc(OrientacaoTcc orientacaoTcc) {
        this.orientacoesTcc.add(orientacaoTcc);
    }
}
