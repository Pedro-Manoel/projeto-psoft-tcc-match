package com.ufcg.psoft.tccMatch.repository.usuario;

import com.ufcg.psoft.tccMatch.model.usuario.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
    List<Professor> findByQuotaGreaterThanEqual(Integer quota);
}
