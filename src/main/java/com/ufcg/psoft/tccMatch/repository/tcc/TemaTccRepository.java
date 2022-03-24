package com.ufcg.psoft.tccMatch.repository.tcc;

import com.ufcg.psoft.tccMatch.model.tcc.TemaTcc;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TemaTccRepository extends JpaRepository<TemaTcc, Long> {
    boolean existsByTitulo(String titulo);
}
