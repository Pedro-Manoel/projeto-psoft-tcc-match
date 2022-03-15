package com.ufcg.psoft.tccMatch.repository;

import com.ufcg.psoft.tccMatch.model.AreaEstudo;
import com.ufcg.psoft.tccMatch.model.usuario.Aluno;
import org.aspectj.weaver.loadtime.Options;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface AreaEstudoRepository extends JpaRepository<AreaEstudo, Long> {
    boolean existsByNome(String nome);

    Optional<AreaEstudo> getByNome(String nome);
}
