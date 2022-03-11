package com.ufcg.psoft.tccMatch.repository;

import com.ufcg.psoft.tccMatch.model.TemaTCC;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TemaTCCRepository extends JpaRepository<TemaTCC, Long> {
    boolean existsByTitulo(String titulo);
}
