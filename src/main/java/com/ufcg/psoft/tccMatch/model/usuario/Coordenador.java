package com.ufcg.psoft.tccMatch.model.usuario;

<<<<<<< Updated upstream
import com.ufcg.psoft.tccMatch.model.ProblemaOrientacaoTCC;
import com.ufcg.psoft.tccMatch.model.TCC;
import com.ufcg.psoft.tccMatch.model.usuario.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Coordenador extends Usuario{
    
	//private List<TCC> tccs;
=======
import com.ufcg.psoft.tccMatch.security.util.Role;

import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
public class Coordenador extends Usuario{

    @Transient
    public String getAutoridade() { return Role.USER_ADMIN; }

    //private List<TCC> tccs;
>>>>>>> Stashed changes
	//private List<ProblemaOrientacaoTCC> problemasOrientacaoTCC;
}
