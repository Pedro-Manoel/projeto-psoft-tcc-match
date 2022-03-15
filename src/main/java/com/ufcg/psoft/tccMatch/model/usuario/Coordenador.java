package com.ufcg.psoft.tccMatch.model.usuario;

import com.ufcg.psoft.tccMatch.security.util.Role;

import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
public class Coordenador extends Usuario{

    @Transient
    public String getAutoridade() { return Role.USER_ADMIN; }

    //private List<TCC> tccs;
	//private List<ProblemaOrientacaoTCC> problemasOrientacaoTCC;
}
