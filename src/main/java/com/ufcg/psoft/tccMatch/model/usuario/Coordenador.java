package com.ufcg.psoft.tccMatch.model.usuario;

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

    //private List<Tcc> tccs;
    @OneToMany (cascade = CascadeType.ALL)
	private List<ProblemaOrientacaoTcc> problemasOrientacaoTcc;

    public void adicionarProblemaOrientacaoTcc(ProblemaOrientacaoTcc problemaOrientacaoTcc) {
        problemasOrientacaoTcc.add(problemaOrientacaoTcc);
    }
}
