package com.ufcg.psoft.tccMatch.model.usuario;

import com.ufcg.psoft.tccMatch.security.util.Role;

import javax.persistence.Entity;

@Entity
public class Coordenador extends Usuario{
    public String getAutoridade() { return Role.USER_ADMIN; }
}
