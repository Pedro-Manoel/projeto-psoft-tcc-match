package com.ufcg.psoft.tccMatch.model.usuario;

import com.ufcg.psoft.tccMatch.model.ProblemaOrientacaoTCC;
import com.ufcg.psoft.tccMatch.model.TemaTCC;
import com.ufcg.psoft.tccMatch.security.util.Role;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import java.util.List;

@Entity
public class Coordenador extends Usuario{

    //@Transient
    public String getAutoridade() { return Role.USER_ADMIN; }

    //private List<TCC> tccs;
    @OneToMany (cascade = CascadeType.ALL)
	private List<ProblemaOrientacaoTCC> problemasOrientacaoTCC;

    public void adicionarProblemaOrientacaoTCC(ProblemaOrientacaoTCC problemaOrientacaoTCC) {
        problemasOrientacaoTCC.add(problemaOrientacaoTCC);
    }
}
