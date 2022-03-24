package com.ufcg.psoft.tccMatch.repository.tcc;

import com.ufcg.psoft.tccMatch.model.tcc.ProblemaOrientacaoTcc;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProblemaOrientacaoTccRepository extends JpaRepository<ProblemaOrientacaoTcc, Long> {
    List<ProblemaOrientacaoTcc> findByOrientacaoTccSemestre(String semestre);
}
