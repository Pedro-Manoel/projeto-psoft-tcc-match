package com.ufcg.psoft.tccMatch.repository;

import com.ufcg.psoft.tccMatch.model.usuario.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> { }
