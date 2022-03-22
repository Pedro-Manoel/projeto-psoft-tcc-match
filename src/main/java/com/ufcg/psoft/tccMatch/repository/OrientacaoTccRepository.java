package com.ufcg.psoft.tccMatch.repository;

import com.ufcg.psoft.tccMatch.model.OrientacaoTcc;
import com.ufcg.psoft.tccMatch.model.usuario.Coordenador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrientacaoTccRepository extends JpaRepository<OrientacaoTcc, Long> {
    List<OrientacaoTcc> findByConcluidaIsFalseAndTccProfessor_Id(Long id);
}
