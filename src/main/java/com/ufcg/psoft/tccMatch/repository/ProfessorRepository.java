package com.ufcg.psoft.tccMatch.repository;

import com.ufcg.psoft.tccMatch.model.usuario.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Long> { }
