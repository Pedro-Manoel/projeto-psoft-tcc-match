package com.ufcg.psoft.tccMatch.model.usuario;

import com.ufcg.psoft.tccMatch.model.tcc.OrientacaoTcc;
import com.ufcg.psoft.tccMatch.model.tcc.ProblemaOrientacaoTcc;
import com.ufcg.psoft.tccMatch.security.util.Role;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import java.util.List;

@Entity
public class Coordenador extends Usuario{
    public String getAutoridade() { return Role.USER_ADMIN; }
}
