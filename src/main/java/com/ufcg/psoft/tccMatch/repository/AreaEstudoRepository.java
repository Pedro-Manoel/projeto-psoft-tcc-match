package com.ufcg.psoft.tccMatch.repository;

import com.ufcg.psoft.tccMatch.model.AreaEstudo;
import com.ufcg.psoft.tccMatch.model.usuario.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AreaEstudoRepository extends JpaRepository<AreaEstudo, Long> {
    boolean existsByNome(String nome);
}
