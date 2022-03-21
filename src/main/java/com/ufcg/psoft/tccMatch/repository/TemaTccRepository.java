package com.ufcg.psoft.tccMatch.repository;

import com.ufcg.psoft.tccMatch.model.TemaTcc;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TemaTccRepository extends JpaRepository<TemaTcc, Long> {
    boolean existsByTitulo(String titulo);
}