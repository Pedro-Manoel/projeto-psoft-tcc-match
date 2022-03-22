package com.ufcg.psoft.tccMatch.repository.tcc;

import com.ufcg.psoft.tccMatch.model.tcc.OrientacaoTcc;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrientacaoTccRepository extends JpaRepository<OrientacaoTcc, Long> {
    List<OrientacaoTcc> findByConcluidaIsFalseAndTccProfessor_Id(Long id);

    List<OrientacaoTcc> findByConcluidaAndSemestre(Boolean concluida, String semestre);
}
