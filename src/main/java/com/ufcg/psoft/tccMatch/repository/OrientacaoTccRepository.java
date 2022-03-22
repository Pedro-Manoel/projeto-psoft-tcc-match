package com.ufcg.psoft.tccMatch.repository;

import com.ufcg.psoft.tccMatch.model.OrientacaoTcc;
import com.ufcg.psoft.tccMatch.model.usuario.Coordenador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrientacaoTccRepository extends JpaRepository<OrientacaoTcc, Long> {
}
