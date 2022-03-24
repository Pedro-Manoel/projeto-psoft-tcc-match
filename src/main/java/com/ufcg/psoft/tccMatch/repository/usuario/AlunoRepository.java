package com.ufcg.psoft.tccMatch.repository.usuario;

import com.ufcg.psoft.tccMatch.model.AreaEstudo;
import com.ufcg.psoft.tccMatch.model.usuario.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    List<Aluno> findByAreasEstudoContains(AreaEstudo areaEstudo);
}
